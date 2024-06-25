package com.techmya.factorybean;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ProductDTO {

    private int productNo;
    private String productName;
    private int productPrice;
    private int categoryCode;
}
