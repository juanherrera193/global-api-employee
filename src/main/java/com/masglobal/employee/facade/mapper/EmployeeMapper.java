package com.masglobal.employee.facade.mapper;

import com.masglobal.employee.facade.model.Employee;
import com.masglobal.employee.model.EmployeeContractType;
import com.masglobal.employee.model.EmployeeDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * Class responsible for transforming the service model to the Employee API model.
 */
@Mapper(componentModel = "spring", imports = EmployeeContractType.class)
public interface EmployeeMapper {

  List<EmployeeDto> transformEmployeeDtoList(List<Employee> employees);

  @Mapping(
      target = "contractType",
      expression = "java(EmployeeContractType.findByContractType(employee.getContractTypeName()))")
  @Mapping(target = "salary", ignore = true)
  EmployeeDto transformEmployeeDto(Employee employee);
}
