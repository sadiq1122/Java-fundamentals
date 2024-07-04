package com.example.splitwise.models;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDTO {

    @NotNull(message = "Amount cannot be null")
    private Double amount;
    @NotNull(message = "UserId is mandatory")
    private Long userId;
    private Long groupId;
    private Date createdAt;
    private String type;
}
