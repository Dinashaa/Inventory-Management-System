package com.app.Inventory.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Document(value = "product")
public class Product {

    @Id
    private String id;

    private String name;
    private String description;
    private BigDecimal price;
    private String supplierId;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
   

}
