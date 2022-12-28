package com.rewards.service.beans.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Abk on 12/27/2022
 * @project
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RewardResponse extends GenericResponse {

  private List<ResponseData> list=new LinkedList<>();

  public RewardResponse() {
    super();
    this.status = Status.SUCCESS;
    list = new LinkedList<>();
  }
}
