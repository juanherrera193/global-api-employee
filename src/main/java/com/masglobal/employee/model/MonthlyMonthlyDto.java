package com.masglobal.employee.model;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class MonthlyMonthlyDto extends SalaryDto {

  private final BigDecimal monthly;

  @Builder
  public MonthlyMonthlyDto(BigDecimal annual, BigDecimal monthly) {
    super(annual);
    this.monthly = monthly;
  }
}
