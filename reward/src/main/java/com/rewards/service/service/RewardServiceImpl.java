package com.rewards.service.service;

import com.rewards.service.beans.request.RewardRequest;
import com.rewards.service.beans.response.GenericResponse;
import com.rewards.service.beans.response.ResponseData;
import com.rewards.service.beans.response.RewardResponse;
import com.rewards.service.dao.TransactionDao;
import com.rewards.service.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * @author Abk on 12/27/2022
 * @project
 */
@Service
public class RewardServiceImpl implements RewardService {

  @Autowired private ValidationService validationService;
  @Autowired private TransactionDao transactionDao;

  @Override
  public GenericResponse getRewardByCustomer(Long customerId, RewardRequest.Filter filter) {
    validationService.validateRequest(customerId, filter);
    RewardResponse rewardResponse = new RewardResponse();
    Map<Long, List<Transaction>> listMap = transactionDao.getTransaction(customerId);
    for (Map.Entry<Long, List<Transaction>> entry : listMap.entrySet()) {
      rewardResponse.getList().add(prepareResponseData(entry, filter));
    }
    return rewardResponse;
  }

  @Override
  public GenericResponse getRewards(RewardRequest.Filter filter) {
    validationService.validateRequest(filter);
    RewardResponse rewardResponse = new RewardResponse();
    Map<Long, List<Transaction>> listMap = transactionDao.getTransactionForAllCustomer();

    for (Map.Entry<Long, List<Transaction>> entry : listMap.entrySet()) {
      rewardResponse.getList().add(prepareResponseData(entry, filter));
    }
    return rewardResponse;
  }

  private ResponseData prepareResponseData(
          Map.Entry<Long, List<Transaction>> data, RewardRequest.Filter filter) {
    ResponseData responseData = new ResponseData(data.getKey());
    responseData.setCustomerId(data.getKey());
    responseData.setFilter(filter);
    responseData.setTotalRewardPoints(calculateTotalRewardPoints(data.getValue()));
    responseData.setDataCount(CalculateDataByGrouping(data.getValue(), filter));
    return responseData;
  }

  private Map<String, Integer> CalculateDataByGrouping(
      List<Transaction> transactionList, RewardRequest.Filter filter) {

    switch (filter) {
      case MONTHLY:
        return prepareMonthlyData(transactionList);
      case YEARLY:
        return  prepareYearlyData(transactionList);
      default:
        break;
    }
    return null;
  }

  private Map<String, Integer> prepareYearlyData(List<Transaction> transactionList) {
    Map<String, Integer> groupByData = new HashMap<>();
    Map<LocalDateTime, List<Transaction>> transactionByMonth =
            transactionList.stream()
                    .collect(
                            Collectors.groupingBy(
                                    transaction -> transaction.getDateOccurred().withMonth(1).withDayOfMonth(1)));

    for (Map.Entry<LocalDateTime, List<Transaction>> mapData : transactionByMonth.entrySet()) {
      groupByData.put(String.valueOf(mapData.getKey().getYear()), calculateTotalRewardPoints(mapData.getValue()));
    }

    return groupByData;
  }

  private Map<String, Integer> prepareMonthlyData(List<Transaction> transactionList) {
    Map<String, Integer> groupByData = new HashMap<>();
    Map<LocalDateTime, List<Transaction>> transactionByMonth =
        transactionList.stream()
            .collect(
                Collectors.groupingBy(
                    transaction -> transaction.getDateOccurred().withDayOfMonth(1)));

    for (Map.Entry<LocalDateTime, List<Transaction>> mapData : transactionByMonth.entrySet()) {
      groupByData.put(mapData.getKey().getMonthValue() +"-"+mapData.getKey().getYear(), calculateTotalRewardPoints(mapData.getValue()));
    }

    return groupByData;
  }



  private Integer calculateTotalRewardPoints(List<Transaction> transactionList) {
    AtomicInteger points = new AtomicInteger();
    transactionList.stream()
        .forEach(
            transaction -> {
              if (transaction.getAmount().compareTo(new BigDecimal(50)) == 1
                  && new BigDecimal(100).compareTo(transaction.getAmount()) == 1) {
                points.addAndGet(transaction.getAmount().subtract(new BigDecimal(50)).intValue());
              }
              if (transaction.getAmount().compareTo(new BigDecimal(100)) == 1) {
                points.addAndGet(
                    transaction.getAmount().subtract(new BigDecimal(100)).intValue() * 2);
                points.addAndGet(50);
              }
              if(transaction.getAmount().compareTo(new BigDecimal(100)) == 0){
                points.addAndGet(50);
              }
            });
    return points.get();
  }
}
