package com.masglobal.employee.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeDto {

  private Integer id;
  private String name;
  private EmployeeContractType contractType;
  private Integer roleId;
  private String roleName;
  private String roleDescription;
  private SalaryDto salary;

  @JsonIgnore
  private BigDecimal hourlySalary;

  @JsonIgnore
  private BigDecimal monthlySalary;
}
