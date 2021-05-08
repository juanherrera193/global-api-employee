package com.masglobal.employee.facade.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class Employee {

  private Integer id;
  private String name;
  private String contractTypeName;
  private Integer roleId;
  private String roleName;
  private String roleDescription;
  private BigDecimal hourlySalary;
  private BigDecimal monthlySalary;
}
