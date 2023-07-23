package org.example;

import java.util.Objects;

public class OrderId {

  private final long value;

  public OrderId(long value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return "OrderId{" +
        "value=" + value +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrderId orderId = (OrderId) o;
    return value == orderId.value;
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }
}
