package com.masglobal.employee.service.factory;

import com.masglobal.employee.model.EmployeeContractType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Class responsible for mapping the employee contract types with it respective factory class.
 */
@Component
public class EmployeeSalaryFactorySelector {

  private final Map<EmployeeContractType, SalaryFactory> contractTypeSalaryFactoryMap;

  @Autowired
  public EmployeeSalaryFactorySelector(Set<SalaryFactory> salaryFactorySet) {
    contractTypeSalaryFactoryMap = new HashMap<>();
    salaryFactorySet.forEach(
        factory -> contractTypeSalaryFactoryMap.put(factory.getEmployeeContractType(), factory));
  }

  public SalaryFactory findSalaryFactory(EmployeeContractType invoiceDocumentTypeCode) {
    return contractTypeSalaryFactoryMap.get(invoiceDocumentTypeCode);
  }
}
