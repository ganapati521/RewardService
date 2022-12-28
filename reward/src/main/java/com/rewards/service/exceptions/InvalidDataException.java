package com.rewards.service.exceptions;

import com.rewards.service.exceptions.code.CommonErrorCode;
import lombok.Data;


public class InvalidDataException extends BaseException {

  public InvalidDataException(String errorMessage) {
    super(errorMessage);
  }

  public InvalidDataException(Throwable throwable, String errorMessage) {
    super(throwable, errorMessage);
  }

  public InvalidDataException(CommonErrorCode errorCode) {
    super(errorCode);
  }

}
