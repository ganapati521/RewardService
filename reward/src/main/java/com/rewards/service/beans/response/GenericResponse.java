package com.rewards.service.beans.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * @author Abk on 12/27/2022
 * @project
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GenericResponse implements ServiceResponse {
  protected String errorMessage;
  protected Status status;

  public enum Status {
    SUCCESS,
    ERROR;
  }
}
