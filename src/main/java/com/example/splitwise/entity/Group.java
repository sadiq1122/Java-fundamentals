package com.example.splitwise.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "groups")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Group extends Base{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long groupId;
    private String name;
}
