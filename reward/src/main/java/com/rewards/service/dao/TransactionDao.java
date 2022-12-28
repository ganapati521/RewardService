package com.rewards.service.dao;

import com.rewards.service.beans.request.RewardRequest;
import com.rewards.service.model.Transaction;

import java.util.List;
import java.util.Map;

/**
 * @author Abk on 12/27/2022
 * @project
 */
public interface TransactionDao {

    Map<Long,List<Transaction>> getTransaction(long customerId);

    Map<Long, List<Transaction>> getTransactionForAllCustomer();
}
