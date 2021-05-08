package com.masglobal.employee.model;

import java.util.Map;
import java.util.Objects;

/**
 * Enum class for employee contract type.
 */
public enum EmployeeContractType {
  HOURLY_SALARY,
  MONTHLY_SALARY,
  NOT_SPECIFIED;

  private static final Map<String, EmployeeContractType> CONTRACT_TYPE_MAP =
      Map.of(
          EmployeeContractType.HOURLY_SALARY_EMPLOYEE, HOURLY_SALARY,
          EmployeeContractType.MONTHLY_SALARY_EMPLOYEE, MONTHLY_SALARY);

  private static final String HOURLY_SALARY_EMPLOYEE = "HourlySalaryEmployee";
  private static final String MONTHLY_SALARY_EMPLOYEE = "MonthlySalaryEmployee";

  public static EmployeeContractType findByContractType(final String contractTypeDescription) {
    if (Objects.nonNull(contractTypeDescription)
        && CONTRACT_TYPE_MAP.containsKey(contractTypeDescription)) {
      return CONTRACT_TYPE_MAP.get(contractTypeDescription);
    }
    return NOT_SPECIFIED;
  }
}
