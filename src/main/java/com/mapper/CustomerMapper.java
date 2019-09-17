package com.mapper;

import java.util.List;

import com.pojo.Customer;

public interface CustomerMapper {

	
	//查询所有客户
	List<Customer> findAll();

	void save(Customer customer);

	Customer findById(Integer id);

	void update(Customer customer);

	void delete(Integer[] id);

	
}
