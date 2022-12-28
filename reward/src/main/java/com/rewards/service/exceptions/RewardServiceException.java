package com.rewards.service.exceptions;

import com.rewards.service.exceptions.code.CommonErrorCode;

public class RewardServiceException extends BaseException {
  public RewardServiceException(String errorMessage) {
    super(errorMessage);
  }

  public RewardServiceException(Throwable throwable, String errorMessage) {
    super(throwable, errorMessage);
  }

  public RewardServiceException(CommonErrorCode errorCode) {
    super(errorCode);
  }
}
