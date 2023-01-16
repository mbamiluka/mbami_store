package com.mbamistore.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderItemsDto {
    private Long id;
    private String orderItemNumber;
    private String orderItemName;
    private String orderItemPrice;
    private String orderItemQuantity;
    private String orderItemTotal;
    private String orderItemCurrency;
}
