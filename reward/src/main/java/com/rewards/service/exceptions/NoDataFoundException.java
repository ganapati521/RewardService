package com.rewards.service.exceptions;

import com.rewards.service.exceptions.code.CommonErrorCode;

public class NoDataFoundException extends BaseException {

  public NoDataFoundException(String errorMessage) {
    super(errorMessage);
  }

  public NoDataFoundException(Throwable throwable, String errorMessage) {
    super(throwable, errorMessage);
  }

  public NoDataFoundException(CommonErrorCode errorCode) {
    super(errorCode);
  }

    public NoDataFoundException(CommonErrorCode commonErrorCode, Object[] objects) {
        super(commonErrorCode,objects);
    }
}
