package com.masglobal.employee.service;

import com.masglobal.employee.facade.EmployeeClient;
import com.masglobal.employee.facade.mapper.EmployeeMapper;
import com.masglobal.employee.model.EmployeeContractType;
import com.masglobal.employee.model.EmployeeDto;
import com.masglobal.employee.model.SalaryDto;
import com.masglobal.employee.service.factory.EmployeeSalaryFactorySelector;
import com.masglobal.employee.service.factory.SalaryFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTests {

  @InjectMocks
  private EmployeeServiceImpl employeeService;

  @Mock
  private EmployeeClient employeeClient;

  @Mock
  private EmployeeMapper employeeMapper;

  @Mock
  private EmployeeSalaryFactorySelector employeeSalaryFactorySelector;

  @Mock
  private SalaryFactory salaryFactory;

  @Test
  void testGetEmployees() {
    when(employeeClient.getEmployees()).thenReturn(Mockito.mock(List.class));

    when(employeeMapper.transformEmployeeDtoList(ArgumentMatchers.anyList()))
        .thenReturn(mockEmployeeList());

    when(salaryFactory.calculate(ArgumentMatchers.any())).thenReturn(Mockito.mock(SalaryDto.class));
    when(employeeSalaryFactorySelector.findSalaryFactory(ArgumentMatchers.any()))
        .thenReturn(salaryFactory);

    final List<EmployeeDto> employeeDtoList = employeeService.getEmployees();

    assertNotNull(employeeDtoList);

    verify(employeeClient).getEmployees();
    verify(employeeMapper).transformEmployeeDtoList(ArgumentMatchers.anyList());
    verify(salaryFactory, times(2)).calculate(ArgumentMatchers.any());
    verify(employeeSalaryFactorySelector, times(2)).findSalaryFactory(ArgumentMatchers.any());

    verifyNoMoreInteractions(
        employeeClient, employeeMapper, salaryFactory, employeeSalaryFactorySelector);
  }

  @Test
  void testGetEmployee() {
    when(employeeClient.getEmployees()).thenReturn(Mockito.mock(List.class));

    when(employeeMapper.transformEmployeeDtoList(ArgumentMatchers.anyList()))
            .thenReturn(mockEmployeeList());

    when(salaryFactory.calculate(ArgumentMatchers.any())).thenReturn(Mockito.mock(SalaryDto.class));
    when(employeeSalaryFactorySelector.findSalaryFactory(ArgumentMatchers.any()))
            .thenReturn(salaryFactory);

    final EmployeeDto employeeDto = employeeService.getEmployee(1);

    assertNotNull(employeeDto);

    verify(employeeClient).getEmployees();
    verify(employeeMapper).transformEmployeeDtoList(ArgumentMatchers.anyList());
    verify(salaryFactory, times(1)).calculate(ArgumentMatchers.any());
    verify(employeeSalaryFactorySelector, times(1)).findSalaryFactory(ArgumentMatchers.any());

    verifyNoMoreInteractions(
            employeeClient, employeeMapper, salaryFactory, employeeSalaryFactorySelector);
  }


  private static List<EmployeeDto> mockEmployeeList() {
    EmployeeDto employeeDto1 = new EmployeeDto();
    employeeDto1.setId(1);
    employeeDto1.setContractType(EmployeeContractType.HOURLY_SALARY);

    EmployeeDto employeeDto2 = new EmployeeDto();
    employeeDto2.setId(2);
    employeeDto2.setContractType(EmployeeContractType.MONTHLY_SALARY);
    return List.of(employeeDto1, employeeDto2);
  }
}
