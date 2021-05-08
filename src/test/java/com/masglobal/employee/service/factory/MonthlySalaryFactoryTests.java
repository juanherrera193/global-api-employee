package com.masglobal.employee.service.factory;

import com.masglobal.employee.model.EmployeeContractType;
import com.masglobal.employee.model.EmployeeDto;
import com.masglobal.employee.model.HourlySalaryDto;
import com.masglobal.employee.model.MonthlyMonthlyDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class MonthlySalaryFactoryTests {

  private final MonthlySalaryFactory factory = new MonthlySalaryFactory();

  @Test
  void testGetEmployeeContractType() {
    final EmployeeContractType contractType = factory.getEmployeeContractType();

    assertEquals(EmployeeContractType.MONTHLY_SALARY, contractType);
  }

  @Test
  void testCalculateOkSalary() {
    EmployeeDto employeeDto = new EmployeeDto();
    employeeDto.setMonthlySalary(BigDecimal.TEN);

    final MonthlyMonthlyDto monthlyMonthlyDto = factory.calculate(employeeDto);

    assertNotNull(monthlyMonthlyDto);
    assertEquals(BigDecimal.TEN, monthlyMonthlyDto.getMonthly());
    assertEquals(
        monthlyMonthlyDto.getMonthly().multiply(BigDecimal.valueOf(12)),
        monthlyMonthlyDto.getAnnual());
  }

  @Test
  void testCalculateEmptySalary() {
    final MonthlyMonthlyDto monthlyMonthlyDto = factory.calculate(new EmployeeDto());

    assertNotNull(monthlyMonthlyDto);
    assertNull(monthlyMonthlyDto.getMonthly());
    assertNull(monthlyMonthlyDto.getAnnual());
  }
}
