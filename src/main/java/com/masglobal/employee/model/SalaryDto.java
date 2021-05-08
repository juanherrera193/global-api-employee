package com.masglobal.employee.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class SalaryDto {

  private final BigDecimal annual;
}
