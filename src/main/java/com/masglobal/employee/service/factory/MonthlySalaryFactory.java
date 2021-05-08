package com.masglobal.employee.service.factory;

import com.masglobal.employee.model.EmployeeContractType;
import com.masglobal.employee.model.EmployeeDto;
import com.masglobal.employee.model.MonthlyMonthlyDto;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class MonthlySalaryFactory extends SalaryFactory {

  @Override
  public EmployeeContractType getEmployeeContractType() {
    return EmployeeContractType.MONTHLY_SALARY;
  }

  /**
   * Calculate the annual salary of the employee from the monthly salary.
   *
   * @param employeeDto employee DTO
   * @return monthly salary calculated
   */
  @Override
  public MonthlyMonthlyDto calculate(EmployeeDto employeeDto) {
    if (Objects.isNull(employeeDto.getMonthlySalary())) {
      return MonthlyMonthlyDto.builder().build();
    }
    return MonthlyMonthlyDto.builder()
        .monthly(employeeDto.getMonthlySalary())
        .annual(employeeDto.getMonthlySalary().multiply(MONTHS_OF_YEAR))
        .build();
  }
}
