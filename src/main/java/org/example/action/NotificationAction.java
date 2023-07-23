package org.example.action;

import org.example.NotificationType;
import org.example.OrderId;

public interface NotificationAction {
  NotificationType type();

  void notify(OrderId orderId);
}
