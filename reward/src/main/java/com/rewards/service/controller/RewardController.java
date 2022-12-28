package com.rewards.service.controller;

import com.rewards.service.beans.request.RewardRequest;
import com.rewards.service.beans.response.ServiceResponse;
import com.rewards.service.service.RewardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Abk on 12/26/2022
 * @project
 */
@RestController
@RequestMapping(
    path = "/rewards",
    produces = {"application/json"})
public class RewardController {

  @Autowired private RewardService rewardService;

  @GetMapping(path = "/{customerId}/points")
  public ResponseEntity<ServiceResponse> getRewardDetails(
          @RequestParam(name = "filter") RewardRequest.Filter filter, @PathVariable("customerId") Long customerId) {

    return ResponseEntity.ok(rewardService.getRewardByCustomer(customerId, filter));
  }

  @GetMapping(path = "/points")
  public ResponseEntity<ServiceResponse> getRewardDetails(
          @RequestParam(name = "filter") RewardRequest.Filter filter) {

    return ResponseEntity.ok(rewardService.getRewards(filter));
  }
}
