package com.example.api.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="users")
public class UserModel {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false)
    private Long id;
    private String name;
    private String email;
}
