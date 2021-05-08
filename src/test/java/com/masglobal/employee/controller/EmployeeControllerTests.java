package com.masglobal.employee.controller;

import com.masglobal.employee.model.EmployeeDto;
import com.masglobal.employee.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmployeeControllerTests {

  @InjectMocks
  private EmployeeController employeeController;

  @Mock
  private EmployeeService employeeService;

  @Test
  public void testGetEmployeesOK() {
    when(employeeService.getEmployees()).thenReturn(Mockito.mock(List.class));

    final ResponseEntity<List<EmployeeDto>> responseEntity = employeeController.getEmployees();
    assertNotNull(responseEntity);
    assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

    verify(employeeService).getEmployees();
    verifyNoMoreInteractions(employeeService);
  }

  @Test
  public void testGetEmployeesEmpty() {
    when(employeeService.getEmployees()).thenReturn(List.of());

    final ResponseEntity<List<EmployeeDto>> responseEntity = employeeController.getEmployees();
    assertNotNull(responseEntity);
    assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());

    verify(employeeService).getEmployees();
    verifyNoMoreInteractions(employeeService);
  }

  @Test
  public void testGetEmployee() {
    when(employeeService.getEmployee(ArgumentMatchers.eq(1)))
        .thenReturn(Mockito.mock(EmployeeDto.class));

    final ResponseEntity<EmployeeDto> responseEntity = employeeController.getEmployee(1);
    assertNotNull(responseEntity);
    assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

    verify(employeeService).getEmployee(ArgumentMatchers.eq(1));
    verifyNoMoreInteractions(employeeService);
  }
}
