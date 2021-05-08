package com.masglobal.employee.service;

import com.masglobal.employee.model.EmployeeDto;

import java.util.List;

public interface EmployeeService {

  /**
   * Get all employees.
   *
   * @return a list of employees
   */
  List<EmployeeDto> getEmployees();

  /**
   * Get employee by id
   *
   * @param id employee identifier
   * @return employee
   */
  EmployeeDto getEmployee(Integer id);
}
