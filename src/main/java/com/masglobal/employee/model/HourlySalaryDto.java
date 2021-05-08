package com.masglobal.employee.model;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class HourlySalaryDto extends SalaryDto {

  private final BigDecimal hourly;

  @Builder
  public HourlySalaryDto(BigDecimal annual, BigDecimal hourly) {
    super(annual);
    this.hourly = hourly;
  }
}
