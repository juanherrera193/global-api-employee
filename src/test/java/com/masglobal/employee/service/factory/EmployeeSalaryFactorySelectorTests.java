package com.masglobal.employee.service.factory;

import com.masglobal.employee.model.EmployeeContractType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class EmployeeSalaryFactorySelectorTests {

  private EmployeeSalaryFactorySelector factorySelector;
  private final Set<SalaryFactory> salaryFactorySet = Set.of(new HourlySalaryFactory(), new MonthlySalaryFactory());

  @BeforeEach
  public void setUp() {
    factorySelector = new EmployeeSalaryFactorySelector(salaryFactorySet);
  }

  @Test
  public void testFindSalaryFactoryForHourlySalary() {
    final SalaryFactory salaryFactory =
        factorySelector.findSalaryFactory(EmployeeContractType.HOURLY_SALARY);
    assertNotNull(salaryFactory);
    assertTrue(salaryFactory instanceof HourlySalaryFactory);
  }

  @Test
  public void testFindSalaryFactoryForMonthlySalary() {
    final SalaryFactory salaryFactory =
            factorySelector.findSalaryFactory(EmployeeContractType.MONTHLY_SALARY);
    assertNotNull(salaryFactory);
    assertTrue(salaryFactory instanceof MonthlySalaryFactory);
  }
}
