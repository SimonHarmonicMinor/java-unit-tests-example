package org.example;

import java.util.List;
import org.example.action.NotificationAction;
import org.example.exception.AbsendNotificationException;
import org.example.exception.NotificationActionException;

public class NotificationService {
  private final List<NotificationAction> actions;

  public NotificationService(List<NotificationAction> actions) {
    this.actions = actions;
  }

  public void notifyOrdering(OrderId orderId, NotificationType type) {
    boolean foundAction = false;
    for (NotificationAction action : actions) {
      if (action.type().equals(type)) {
        foundAction = true;
        try {
          action.notify(orderId);
          break; // выходим из цикла, если нашли нужный action
        } catch (NotificationActionException e) {
          System.err.printf("Couldn't execute action '%s'. Trying next one: %s%n", action, e.getMessage());
        }
      }
    }
    if (!foundAction) {
      // если не нашли подходящего action, кидаем исключение
      throw new AbsendNotificationException("Couldn't find NotificationAction for type=" + type);
    }
  }
}
