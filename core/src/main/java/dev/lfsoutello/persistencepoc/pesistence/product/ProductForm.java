package dev.lfsoutello.persistencepoc.pesistence.product;

import java.math.BigDecimal;

public interface ProductForm {
    String getName();
    String getDescription();
    BigDecimal getPrice();
    Integer getStock();
}
