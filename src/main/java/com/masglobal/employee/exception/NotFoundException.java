package com.masglobal.employee.exception;

/**
 * Specific class used when searching for an employee and it's not found in the list.
 */
public class NotFoundException extends RuntimeException {

  private static final String EMPLOYEE_NOT_FOUND = "The employee not found";

  public NotFoundException() {
    super(EMPLOYEE_NOT_FOUND);
  }
}
