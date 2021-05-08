package com.masglobal.employee.service.factory;

import com.masglobal.employee.model.EmployeeContractType;
import com.masglobal.employee.model.EmployeeDto;
import com.masglobal.employee.model.SalaryDto;

import java.math.BigDecimal;

/**
 * Salary factory class.
 */
public abstract class SalaryFactory {

  protected static final BigDecimal MONTHS_OF_YEAR = BigDecimal.valueOf(12);

  /**
   * Get employee contract type.
   *
   * @return employee contract type
   */
  public abstract EmployeeContractType getEmployeeContractType();

  /**
   * Calculate employee salary
   *
   * @param employeeDto employee DTO.
   * @return salary calculated
   */
  public abstract SalaryDto calculate(EmployeeDto employeeDto);
}
