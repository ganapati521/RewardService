package com.rewards.service.exceptions;

import com.rewards.service.exceptions.code.CommonErrorCode;

public class BaseException extends RuntimeException {
  protected Throwable throwable;
  protected String errorMessage;
  protected CommonErrorCode errorCode;
  protected Object[] data;

  public BaseException(String errorMessage) {
    this.errorMessage = errorMessage;
  }

  public BaseException(CommonErrorCode errorCode) {
    this.errorCode = errorCode;
  }

  public BaseException(Throwable throwable, String errorMessage) {
    super(errorMessage, throwable);
    this.throwable = throwable;
    this.errorMessage = errorMessage;
  }

  public BaseException(CommonErrorCode commonErrorCode, Object[] objects) {
    this.errorCode = commonErrorCode;
    this.data = objects;
  }

  public CommonErrorCode getErrorCode() {
    return errorCode;
  }

  public void setErrorCode(CommonErrorCode errorCode) {
    this.errorCode = errorCode;
  }

  public Object[] getData() {
    return data;
  }

  public void setData(Object[] data) {
    this.data = data;
  }
}
