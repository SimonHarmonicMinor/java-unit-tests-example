package org.example.action;

import org.example.NotificationType;
import org.example.OrderId;

public class SmsNotificationAction implements NotificationAction {

  @Override
  public NotificationType type() {
    return NotificationType.SMS;
  }

  @Override
  public void notify(OrderId orderId) {
    System.out.println("Отправка SMS для " + orderId);
  }
}
