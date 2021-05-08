package com.masglobal.employee.service.factory;

import com.masglobal.employee.model.EmployeeContractType;
import com.masglobal.employee.model.EmployeeDto;
import com.masglobal.employee.model.HourlySalaryDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class HourlySalaryFactoryTests {

  private final HourlySalaryFactory factory = new HourlySalaryFactory();

  @Test
  void testGetEmployeeContractType() {
    final EmployeeContractType contractType = factory.getEmployeeContractType();

    assertEquals(EmployeeContractType.HOURLY_SALARY, contractType);
  }

  @Test
  void testCalculateOkSalary() {
    EmployeeDto employeeDto = new EmployeeDto();
    employeeDto.setHourlySalary(BigDecimal.TEN);

    final HourlySalaryDto hourlySalaryDto = factory.calculate(employeeDto);

    assertNotNull(hourlySalaryDto);
    assertEquals(BigDecimal.TEN, hourlySalaryDto.getHourly());
    assertEquals(
        BigDecimal.valueOf(120)
            .multiply(hourlySalaryDto.getHourly())
            .multiply(BigDecimal.valueOf(12)),
        hourlySalaryDto.getAnnual());
  }

  @Test
  void testCalculateEmptySalary() {
    final HourlySalaryDto hourlySalaryDto = factory.calculate(new EmployeeDto());

    assertNotNull(hourlySalaryDto);
    assertNull(hourlySalaryDto.getHourly());
    assertNull(hourlySalaryDto.getAnnual());
  }
}
