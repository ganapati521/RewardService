package com.rewards.service.service;

import com.rewards.service.beans.request.RewardRequest;
import com.rewards.service.dao.CustomerDao;
import com.rewards.service.exceptions.InvalidDataException;
import com.rewards.service.exceptions.NoDataFoundException;
import com.rewards.service.exceptions.code.CommonErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Abk on 12/27/2022
 * @project
 */
@Service
public class ValidationServiceImpl implements ValidationService {

  @Autowired private CustomerDao customerDao;

  @Override
  public void validateRequest(Long customerId, RewardRequest.Filter filter) {
    if (null == customerId) {
      throw new InvalidDataException(CommonErrorCode.CUSTOMER_ID_MISSING);
    }

    if (customerDao.get(customerId) == null) {
      throw new NoDataFoundException(
          CommonErrorCode.CUSTOMER_ID_INVALID, new Object[] {customerId});
    }

    if (null == filter) {
      filter = RewardRequest.Filter.MONTHLY;
    }
  }

  @Override
  public void validateRequest(RewardRequest.Filter filter) {
    if (null == filter) {
      filter = RewardRequest.Filter.MONTHLY;
    }
  }
}
