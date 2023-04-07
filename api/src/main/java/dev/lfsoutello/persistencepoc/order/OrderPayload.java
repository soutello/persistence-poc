package dev.lfsoutello.persistencepoc.order;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class OrderPayload {
    List<OrderItemPayload> items;
}
