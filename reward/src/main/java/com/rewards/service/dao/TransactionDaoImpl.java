package com.rewards.service.dao;

import com.rewards.service.beans.response.RewardResponse;
import com.rewards.service.model.Customer;
import com.rewards.service.model.Transaction;
import com.rewards.service.util.DataConstants;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Abk on 12/27/2022
 * @project
 */
@Repository
public class TransactionDaoImpl implements TransactionDao {
  @Override
  public Map<Long, List<Transaction>> getTransaction(long customerId) {
    Map<Long, List<Transaction>> transactionMapBuCustomerId = new HashMap<>();
    for (Customer customer : DataConstants.getCustomerData()) {
      if (customer.getId().equals(customerId)) {
        transactionMapBuCustomerId.put(customerId, customer.getTransactionList());
      }
    }

    return transactionMapBuCustomerId;
  }

  @Override
  public Map<Long, List<Transaction>> getTransactionForAllCustomer() {
    RewardResponse rewardResponse = new RewardResponse();
    // get all the transaction customer wise
    return DataConstants.getTransactionData().stream()
        .collect(Collectors.groupingBy(transaction -> transaction.getCustomerId()));
  }
}
