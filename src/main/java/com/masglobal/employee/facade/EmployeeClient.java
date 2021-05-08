package com.masglobal.employee.facade;

import com.masglobal.employee.facade.model.Employee;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Client class in charge to consume employee services.
 */
@FeignClient(name = "${feign.name}", url = "${feign.url}")
public interface EmployeeClient {

  /**
   * Get employee list.
   *
   * @return a list of employees
   */
  @RequestMapping(method = RequestMethod.GET, value = "/employees")
  List<Employee> getEmployees();
}
