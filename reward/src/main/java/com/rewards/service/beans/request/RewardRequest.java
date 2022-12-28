package com.rewards.service.beans.request;

import lombok.Data;

/**
 * @author Abk on 12/27/2022
 * @project
 */
@Data
public class RewardRequest implements ServiceRequest {

  private Filter filter;

  public enum Filter {
    MONTHLY,
    YEARLY;
  }
}
