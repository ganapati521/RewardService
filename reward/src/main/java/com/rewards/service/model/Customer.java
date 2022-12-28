package com.rewards.service.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author Abk on 12/27/2022
 * @project
 */
@Data
@Builder
public class Customer {
  private Long id;
  private String name;
  private List<Transaction> transactionList;
}
