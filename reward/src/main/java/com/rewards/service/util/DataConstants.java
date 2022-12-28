package com.rewards.service.util;

import com.rewards.service.model.Customer;
import com.rewards.service.model.Transaction;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Abk on 12/27/2022
 * @project
 */
public class DataConstants {

  private static List<Customer> customerList = getDataConstants();

  public static List<Customer> getDataConstants() {
    List<Customer> customerList = new LinkedList<>();
    customerList.add(
        Customer.builder()
            .id(1L)
            .name("Arudra")
            .transactionList(prepareTransactionList(1L))
            .build());
    customerList.add(
        Customer.builder()
            .id(2L)
            .name("Mohan")
            .transactionList(prepareTransactionList(2L))
            .build());
    customerList.add(
        Customer.builder()
            .id(3L)
            .name("Abhijit")
            .transactionList(prepareTransactionList(3L))
            .build());
    return customerList;
  }

  private static List<Transaction> prepareTransactionList(long customerId) {
    List<Transaction> transactionList = new LinkedList<>();
    if (customerId == 1L) {
      transactionList.add(
          Transaction.builder()
              .id(1L)
              .amount(new BigDecimal(100))
              .customerId(1L)
              .dateOccurred(LocalDateTime.now())
              .build());
      transactionList.add(
          Transaction.builder()
              .id(9L)
              .amount(new BigDecimal(300))
              .customerId(1L)
              .dateOccurred(LocalDateTime.now().plusMonths(4))
              .build());
      transactionList.add(
          Transaction.builder()
              .id(2L)
              .amount(new BigDecimal(200))
              .customerId(1L)
              .dateOccurred(LocalDateTime.now().minusMonths(1))
              .build());
      transactionList.add(
          Transaction.builder()
              .id(3L)
              .amount(new BigDecimal(150))
              .customerId(1L)
              .dateOccurred(LocalDateTime.now().minusMonths(2))
              .build());
      transactionList.add(
          Transaction.builder()
              .id(4L)
              .amount(new BigDecimal(170))
              .customerId(1L)
              .dateOccurred(LocalDateTime.now().minusMonths(3))
              .build());
      transactionList.add(
          Transaction.builder()
              .id(5L)
              .amount(new BigDecimal(100))
              .customerId(1L)
              .dateOccurred(LocalDateTime.now())
              .build());
      transactionList.add(
          Transaction.builder()
              .id(6L)
              .amount(new BigDecimal(200))
              .customerId(1L)
              .dateOccurred(LocalDateTime.now().minusMonths(1))
              .build());
      transactionList.add(
          Transaction.builder()
              .id(7L)
              .amount(new BigDecimal(150))
              .customerId(1L)
              .dateOccurred(LocalDateTime.now().minusMonths(2))
              .build());
      transactionList.add(
          Transaction.builder()
              .id(8L)
              .amount(new BigDecimal(170))
              .customerId(1L)
              .dateOccurred(LocalDateTime.now().minusMonths(3))
              .build());
    }
    if (customerId == 2L) {
      transactionList.add(
          Transaction.builder()
              .id(1L)
              .amount(new BigDecimal(100))
              .customerId(2L)
              .dateOccurred(LocalDateTime.now())
              .build());
      transactionList.add(
          Transaction.builder()
              .id(2L)
              .amount(new BigDecimal(200))
              .customerId(2L)
              .dateOccurred(LocalDateTime.now().minusMonths(1))
              .build());
      transactionList.add(
          Transaction.builder()
              .id(3L)
              .amount(new BigDecimal(150))
              .customerId(2L)
              .dateOccurred(LocalDateTime.now().minusMonths(2))
              .build());
      transactionList.add(
          Transaction.builder()
              .id(4L)
              .amount(new BigDecimal(170))
              .customerId(2L)
              .dateOccurred(LocalDateTime.now().minusMonths(3))
              .build());
      transactionList.add(
          Transaction.builder()
              .id(5L)
              .amount(new BigDecimal(100))
              .customerId(2L)
              .dateOccurred(LocalDateTime.now())
              .build());
      transactionList.add(
          Transaction.builder()
              .id(6L)
              .amount(new BigDecimal(200))
              .customerId(2L)
              .dateOccurred(LocalDateTime.now().minusMonths(1))
              .build());
      transactionList.add(
          Transaction.builder()
              .id(7L)
              .amount(new BigDecimal(150))
              .customerId(2L)
              .dateOccurred(LocalDateTime.now().minusMonths(2))
              .build());
      transactionList.add(
          Transaction.builder()
              .id(8L)
              .amount(new BigDecimal(170))
              .customerId(2L)
              .dateOccurred(LocalDateTime.now().minusMonths(3))
              .build());
    }
    if (customerId == 3L) {
      transactionList.add(
          Transaction.builder()
              .id(1L)
              .amount(new BigDecimal(100))
              .customerId(3L)
              .dateOccurred(LocalDateTime.now())
              .build());
      transactionList.add(
          Transaction.builder()
              .id(2L)
              .amount(new BigDecimal(200))
              .customerId(3L)
              .dateOccurred(LocalDateTime.now().minusMonths(1))
              .build());
      transactionList.add(
          Transaction.builder()
              .id(3L)
              .amount(new BigDecimal(150))
              .customerId(3L)
              .dateOccurred(LocalDateTime.now().minusMonths(2))
              .build());
      transactionList.add(
          Transaction.builder()
              .id(4L)
              .amount(new BigDecimal(170))
              .customerId(3L)
              .dateOccurred(LocalDateTime.now().minusMonths(3))
              .build());
      transactionList.add(
          Transaction.builder()
              .id(5L)
              .amount(new BigDecimal(100))
              .customerId(3L)
              .dateOccurred(LocalDateTime.now())
              .build());
      transactionList.add(
          Transaction.builder()
              .id(6L)
              .amount(new BigDecimal(200))
              .customerId(3L)
              .dateOccurred(LocalDateTime.now().minusMonths(1))
              .build());
      transactionList.add(
          Transaction.builder()
              .id(7L)
              .amount(new BigDecimal(150))
              .customerId(3L)
              .dateOccurred(LocalDateTime.now().minusMonths(2))
              .build());
      transactionList.add(
          Transaction.builder()
              .id(8L)
              .amount(new BigDecimal(170))
              .customerId(3L)
              .dateOccurred(LocalDateTime.now().minusMonths(3))
              .build());
    }
    return transactionList;
  }

  public static List<Customer> getCustomerData() {

    return customerList;
  }

  public static List<Transaction> getTransactionData() {
    List<Transaction> transactionList = new LinkedList<>();

    customerList.stream()
        .forEach(customer -> transactionList.addAll(customer.getTransactionList()));
    return transactionList;
  }
}
