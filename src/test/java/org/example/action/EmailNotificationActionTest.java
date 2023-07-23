package org.example.action;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.example.OrderId;
import org.junit.jupiter.api.Test;

class EmailNotificationActionTest {

  @Test
  void shouldNotThrowException() {
    assertDoesNotThrow(
        () -> new EmailNotificationAction().notify(new OrderId(1))
    );
  }
}