package org.example.exception;

public class AbsendNotificationException extends RuntimeException {

  public AbsendNotificationException(String message) {
    super(message);
  }

  public AbsendNotificationException(String message, Throwable cause) {
    super(message, cause);
  }
}
