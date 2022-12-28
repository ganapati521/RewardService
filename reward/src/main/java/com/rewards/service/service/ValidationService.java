package com.rewards.service.service;

import com.rewards.service.beans.request.RewardRequest;

/**
 * @author Abk on 12/27/2022
 * @project
 */
public interface ValidationService {
  void validateRequest(Long customerId, RewardRequest.Filter rewardRequest);

  void validateRequest(RewardRequest.Filter filter);
}
