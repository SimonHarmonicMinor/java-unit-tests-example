package org.example;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.example.action.NotificationAction;
import org.example.exception.AbsendNotificationException;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class NotificationServiceTest {

  @Test
  void shouldThrowExceptionIfActionsListIsEmpty() {
    NotificationService service = new NotificationService(Collections.emptyList());
    assertThrows(
        AbsendNotificationException.class,
        () -> service.notifyOrdering(new OrderId(1), NotificationType.SMS)
    );
  }

  @Test
  void shouldSucceedNotifying() {
    final var actionResult = new AtomicBoolean(false);
    final var notificationAction = new NotificationAction() {
      @Override
      public NotificationType type() {
        return NotificationType.EMAIL;
      }

      @Override
      public void notify(OrderId orderId) {
        actionResult.set(true);
      }
    };

    NotificationService service = new NotificationService(List.of(notificationAction));

    assertDoesNotThrow(
        () -> service.notifyOrdering(new OrderId(1), NotificationType.EMAIL)
    );
    assertTrue(actionResult.get());
  }

  @Test
  void shouldSucceedNotifyingWithMocks() {
    final var notificationAction = Mockito.mock(NotificationAction.class);
    Mockito.when(notificationAction.type())
        .thenReturn(NotificationType.EMAIL);

    NotificationService service = new NotificationService(List.of(notificationAction));

    assertDoesNotThrow(
        () -> service.notifyOrdering(new OrderId(1), NotificationType.EMAIL)
    );
    Mockito.verify(notificationAction, Mockito.times(1)).notify(Mockito.any());
  }
}