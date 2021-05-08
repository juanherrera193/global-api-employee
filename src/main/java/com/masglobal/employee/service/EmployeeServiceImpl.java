package com.masglobal.employee.service;

import com.masglobal.employee.exception.NotFoundException;
import com.masglobal.employee.facade.EmployeeClient;
import com.masglobal.employee.facade.mapper.EmployeeMapper;
import com.masglobal.employee.model.EmployeeDto;
import com.masglobal.employee.model.SalaryDto;
import com.masglobal.employee.service.factory.EmployeeSalaryFactorySelector;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

  private final EmployeeClient employeeClient;
  private final EmployeeMapper employeeMapper;
  private final EmployeeSalaryFactorySelector employeeSalaryFactorySelector;

  @Override
  public List<EmployeeDto> getEmployees() {
    List<EmployeeDto> employeeDtoList =
        employeeMapper.transformEmployeeDtoList(employeeClient.getEmployees());

    return employeeDtoList.stream()
        .peek(employeeDto -> employeeDto.setSalary(calculateSalary(employeeDto)))
        .collect(Collectors.toList());
  }

  @Override
  public EmployeeDto getEmployee(Integer id) {
    List<EmployeeDto> employeeDtoList =
        employeeMapper.transformEmployeeDtoList(employeeClient.getEmployees());

    return employeeDtoList.stream()
        .filter(employeeDto -> id.equals(employeeDto.getId()))
        .peek(employeeDto -> employeeDto.setSalary(calculateSalary(employeeDto)))
        .findFirst()
        .orElseThrow(NotFoundException::new);
  }

  private SalaryDto calculateSalary(EmployeeDto employeeDto) {
    return employeeSalaryFactorySelector
        .findSalaryFactory(employeeDto.getContractType())
        .calculate(employeeDto);
  }
}
