package com.example.springjdbc_sql.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Employee {
    private int id;
    private String name;
    private int age;
}
