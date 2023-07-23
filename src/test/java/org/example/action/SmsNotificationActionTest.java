package org.example.action;

import static org.junit.jupiter.api.Assertions.*;

import org.example.OrderId;
import org.junit.jupiter.api.Test;

class SmsNotificationActionTest {
  @Test
  void shouldNotThrowException() {
    assertDoesNotThrow(
        () -> new SmsNotificationAction().notify(new OrderId(1))
    );
  }
}