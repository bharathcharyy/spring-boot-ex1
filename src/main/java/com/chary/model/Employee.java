package com.chary.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name="employee")
@Entity
public class Employee {
@Id
private Long id;
private String name;
private String department;

}
