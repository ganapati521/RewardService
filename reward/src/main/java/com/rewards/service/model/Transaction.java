package com.rewards.service.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author Abk on 12/27/2022
 * @project
 */
@Data
@Builder
public class Transaction {

  private Long id;
  private BigDecimal amount;
  private Long customerId;
  private LocalDateTime dateOccurred;
}
