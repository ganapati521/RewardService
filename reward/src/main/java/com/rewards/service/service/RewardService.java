package com.rewards.service.service;

import com.rewards.service.beans.request.RewardRequest;
import com.rewards.service.beans.response.GenericResponse;

/**
 * @author Abk on 12/27/2022
 * @project
 */
public interface RewardService {
  GenericResponse getRewardByCustomer(Long customerId, RewardRequest.Filter rewardRequest);

  GenericResponse getRewards(RewardRequest.Filter rewardRequest);
}
