package com.rewards.service.beans.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.rewards.service.beans.request.RewardRequest;
import lombok.Data;

import java.util.Map;

/**
 * @author Abk on 12/27/2022
 * @project
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseData {
  private Long customerId;
  private RewardRequest.Filter filter;
  private Map<String, Integer> dataCount;
  private long totalRewardPoints;

  public ResponseData(Long customerId) {
    customerId = this.customerId;
  }

  public ResponseData() {}
}
