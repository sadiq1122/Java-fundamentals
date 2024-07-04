package com.example.splitwise.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

    @Entity
    @Table(name = "transactions")
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public class Transaction {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        private Double amount;

        private Long userId;

        private Date createdAt;

        private Long groupId;

    }
