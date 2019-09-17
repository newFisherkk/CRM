package com.service;

import java.util.List;

import com.pojo.Customer;


public interface CustomerService {
	
	//查询所有数据
	List<Customer> findAll();
	
	//保存数据
	void save(Customer customer);

	//修改数据时的数据回显
	Customer findById(Integer id);

	void delete(Integer[] id);
}
