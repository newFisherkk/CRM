package com.mapper;

import java.util.List;

import com.pojo.Customer;

public interface CustomerMapper {

	
	//��ѯ���пͻ�
	List<Customer> findAll();

	void save(Customer customer);

	Customer findById(Integer id);

	void update(Customer customer);

	void delete(Integer[] id);

	
}
