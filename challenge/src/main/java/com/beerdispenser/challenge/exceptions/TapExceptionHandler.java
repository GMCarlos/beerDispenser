package com.beerdispenser.challenge.exceptions;

import com.beerdispenser.challenge.controllers.BeerDispenserController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice(assignableTypes = {BeerDispenserController.class})
public class TapExceptionHandler {

  @ExceptionHandler(TapNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ResponseEntity<ErrorMessage> notFoundTapException(
      TapNotFoundException tapNotFoundException) {
    return createErrorMessageResponseEntity(HttpStatus.NOT_FOUND, tapNotFoundException);
  }

  @ExceptionHandler(TapCreatedException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ResponseEntity<ErrorMessage> tapCreatedException(
          TapCreatedException tapCreatedException) {
    return createErrorMessageResponseEntity(HttpStatus.BAD_REQUEST, tapCreatedException);
  }

  private ResponseEntity<ErrorMessage> createErrorMessageResponseEntity(HttpStatus status, RuntimeException exception) {
    return ResponseEntity.status(status)
        .body(new ErrorMessage(status.toString(), exception.getMessage()));
  }
}
