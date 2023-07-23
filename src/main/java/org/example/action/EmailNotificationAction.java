package org.example.action;

import org.example.NotificationType;
import org.example.OrderId;

public class EmailNotificationAction implements NotificationAction {

  @Override
  public NotificationType type() {
    return NotificationType.EMAIL;
  }

  @Override
  public void notify(OrderId orderId) {
    System.out.println("Отправка email для " + orderId);
  }
}
