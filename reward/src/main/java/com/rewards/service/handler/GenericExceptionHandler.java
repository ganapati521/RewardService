package com.rewards.service.handler;

import com.rewards.service.beans.response.GenericResponse;
import com.rewards.service.beans.response.ServiceResponse;
import com.rewards.service.exceptions.InvalidDataException;
import com.rewards.service.exceptions.NoDataFoundException;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@SuppressWarnings({"unchecked", "rawtypes"})
@Log4j2
@ControllerAdvice
public class GenericExceptionHandler {

  @ExceptionHandler(InvalidDataException.class)
  public final ResponseEntity<ServiceResponse> handleInvalidRequestException(
      InvalidDataException ex, WebRequest request) {
    String errorMsg =
            java.text.MessageFormat.format(ex.getErrorCode().getErrorMessage(), ex.getData());
    GenericResponse response = new GenericResponse();
    response.setStatus(GenericResponse.Status.ERROR);
    response.setErrorMessage(errorMsg);

    return ResponseEntity.badRequest().body(response);
  }

  @ExceptionHandler(NoDataFoundException.class)
  public final ResponseEntity<ServiceResponse> handleNoDataFoundException(
      NoDataFoundException ex, WebRequest request) {
    String errorMsg =
        java.text.MessageFormat.format(ex.getErrorCode().getErrorMessage(), ex.getData());
    GenericResponse response = new GenericResponse();
    response.setStatus(GenericResponse.Status.ERROR);
    response.setErrorMessage(errorMsg);
    return ResponseEntity.badRequest().body(response);
  }

  @ExceptionHandler(Exception.class)
  public final ResponseEntity<ServiceResponse> handleAllExceptions(
      Exception ex, WebRequest request) {
    return ResponseEntity.badRequest().body(null);
  }
}
