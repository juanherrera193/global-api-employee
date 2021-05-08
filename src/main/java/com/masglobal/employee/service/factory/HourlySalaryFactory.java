package com.masglobal.employee.service.factory;

import com.masglobal.employee.model.EmployeeContractType;
import com.masglobal.employee.model.EmployeeDto;
import com.masglobal.employee.model.HourlySalaryDto;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Objects;

@Component
public class HourlySalaryFactory extends SalaryFactory {

  private static final BigDecimal HOURS = BigDecimal.valueOf(120);

  @Override
  public EmployeeContractType getEmployeeContractType() {
    return EmployeeContractType.HOURLY_SALARY;
  }

  /**
   * Calculate the annual salary of the employee from the hourly salary.
   *
   * @param employeeDto employee DTO
   * @return hourly salary calculated
   */
  @Override
  public HourlySalaryDto calculate(EmployeeDto employeeDto) {
    if (Objects.isNull(employeeDto.getHourlySalary())) {
      return HourlySalaryDto.builder().build();
    }
    return HourlySalaryDto.builder()
        .hourly(employeeDto.getHourlySalary())
        .annual(HOURS.multiply(employeeDto.getHourlySalary()).multiply(MONTHS_OF_YEAR))
        .build();
  }
}
