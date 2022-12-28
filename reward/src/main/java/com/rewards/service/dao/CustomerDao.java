package com.rewards.service.dao;

import com.rewards.service.model.Customer;

/**
 * @author Abk on 12/27/2022
 * @project
 */
public interface CustomerDao {

    public Customer get(Long customerId);
}
