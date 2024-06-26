package com.techmya.product.model.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ProductCategoryDTO {

    private int categoryCode;
    private String categoryName;
    private int refCategoryCode;
}
