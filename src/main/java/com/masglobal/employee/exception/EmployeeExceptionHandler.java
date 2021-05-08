package com.masglobal.employee.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class EmployeeExceptionHandler {

  private static final String ERROR_MESSAGE = "Rejected: Field (%s) Value (%s) ";

  /**
   * Handler MethodArgumentTypeMismatchException when path param don't have the correct type.
   *
   * @param ex MethodArgumentTypeMismatch exception
   * @return HTTP Bad Request with specified message.
   */
  @ExceptionHandler(MethodArgumentTypeMismatchException.class)
  public final ResponseEntity<ErrorResponse> handleInvalidFormatException(
      MethodArgumentTypeMismatchException ex) {

    String errorMessage = String.format(ERROR_MESSAGE, ex.getName(), ex.getValue());
    ErrorResponse error = new ErrorResponse(HttpStatus.BAD_REQUEST.getReasonPhrase(), errorMessage);
    return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
  }

  /**
   * Handler NotFoundException when employee doesn't exist.
   *
   * @param ex NotFound exception
   * @return HTTP Not Found with specified message.
   */
  @ExceptionHandler(NotFoundException.class)
  public final ResponseEntity<ErrorResponse> handleNotFoundException(NotFoundException ex) {
    ErrorResponse error =
        new ErrorResponse(HttpStatus.NOT_FOUND.getReasonPhrase(), ex.getMessage());
    return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
  }
}
