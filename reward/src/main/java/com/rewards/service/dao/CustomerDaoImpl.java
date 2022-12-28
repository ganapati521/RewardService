package com.rewards.service.dao;

import com.rewards.service.model.Customer;
import com.rewards.service.util.DataConstants;
import org.springframework.stereotype.Repository;

/**
 * @author Abk on 12/27/2022
 * @project
 */
@Repository
public class CustomerDaoImpl implements CustomerDao {

  // this data set cab be replace by the DB query.. so written in Repository Layer
  private DataConstants dataConstants;

  @Override
  public Customer get(Long customerId) {

    for (Customer customer : DataConstants.getCustomerData()) {
      if (customer.getId().equals(customerId)) {
        return customer;
      }
    }

    return null;
  }
}
