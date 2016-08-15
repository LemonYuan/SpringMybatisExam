package com.hand.SpringMybatisExam.mapper;

import com.hand.SpringMybatisExam.entity.Customer;

public interface CustomerMapper {
     public void insert(Customer customer);
     public Customer getCustomer(int i);
     public int getMaxCustomer();
     public void deleteCustomer(int i);
     
}
