package com.rewards.service.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rewards.service.beans.request.RewardRequest;
import com.rewards.service.beans.response.RewardResponse;
import com.rewards.service.exceptions.NoDataFoundException;
import com.rewards.service.exceptions.code.CommonErrorCode;
import com.rewards.service.service.RewardService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.when;

/**
 * @author Abk on 12/28/2022
 * @project
 */
@ExtendWith(SpringExtension.class)
@WebMvcTest(value = RewardController.class)
class RewardControllerTest {

  @Autowired private MockMvc mockMvc;

  @MockBean private RewardService rewardService;

  private String json =
      "{\n"
          + "    \"errorMessage\": null,\n"
          + "    \"status\": \"SUCCESS\",\n"
          + "    \"list\": [\n"
          + "        {\n"
          + "            \"customerId\": 3,\n"
          + "            \"filter\": \"MONTHLY\",\n"
          + "            \"dataCount\": {\n"
          + "                \"9-2022\": 380,\n"
          + "                \"10-2022\": 300,\n"
          + "                \"11-2022\": 500,\n"
          + "                \"12-2022\": 100\n"
          + "            },\n"
          + "            \"totalRewardPoints\": 1280\n"
          + "        }\n"
          + "    ]\n"
          + "}";

  @Test
  void getRewardDetailsSuccess() throws Exception {

    when(rewardService.getRewards(RewardRequest.Filter.MONTHLY))
        .thenReturn(prepareRewardResponse());

    RequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/rewards/points")
            .param("filter", RewardRequest.Filter.MONTHLY.name());

    MvcResult result = mockMvc.perform(requestBuilder).andReturn();
    Assertions.assertNotNull(result);
  }

  private RewardResponse prepareRewardResponse() throws JsonProcessingException {
    ObjectMapper mapper = new ObjectMapper();
    RewardResponse rewardResponse = mapper.readValue(json, RewardResponse.class);
    return rewardResponse;
  }

  @Test
  void getRewardDetailsForCustomerSuccess() throws Exception {

    when(rewardService.getRewardByCustomer(1l, RewardRequest.Filter.YEARLY))
        .thenReturn(prepareRewardResponse());

    RequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/rewards/1/points")
            .param("filter", RewardRequest.Filter.MONTHLY.name());

    MvcResult result = mockMvc.perform(requestBuilder).andReturn();
    Assertions.assertNotNull(result);
  }
  @Test
  void getRewardDetailsForCustomerFailure() throws Exception {

    when(rewardService.getRewardByCustomer(4l, RewardRequest.Filter.YEARLY))
            .thenThrow(new NoDataFoundException(CommonErrorCode.CUSTOMER_ID_INVALID,new Object[]{4l}));

    RequestBuilder requestBuilder =
            MockMvcRequestBuilders.get("/rewards/1/points")
                    .param("filter", RewardRequest.Filter.MONTHLY.name());

    MvcResult result = mockMvc.perform(requestBuilder).andReturn();

    Assertions.assertNotNull(result);
  }
}
