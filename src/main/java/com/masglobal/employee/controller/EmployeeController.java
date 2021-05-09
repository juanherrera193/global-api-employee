package com.masglobal.employee.controller;

import com.masglobal.employee.model.EmployeeDto;
import com.masglobal.employee.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/employees")
@CrossOrigin(origins = "*", maxAge = 3600)
public class EmployeeController {

  private final EmployeeService employeeService;

  /**
   * Get all employees.
   *
   * @return responseEntity of employee list
   */
  @GetMapping
  public ResponseEntity<List<EmployeeDto>> getEmployees() {
    final List<EmployeeDto> response = employeeService.getEmployees();
    if (CollectionUtils.isEmpty(response)) {
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  /**
   * Get employee by id.
   *
   * @param id employee identifier
   * @return employee
   */
  @GetMapping("/{id}")
  public ResponseEntity<EmployeeDto> getEmployee(@PathVariable final Integer id) {
    return new ResponseEntity<>(employeeService.getEmployee(id), HttpStatus.OK);
  }
}
