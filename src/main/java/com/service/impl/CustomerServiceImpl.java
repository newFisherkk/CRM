package com.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mapper.CustomerMapper;
import com.pojo.Customer;
import com.service.CustomerService;

@Service("customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService {
	
	@Resource
	private CustomerMapper customerMapper;

	@Override
	public List<Customer> findAll() {
		return customerMapper.findAll();
	}
	
	@Override
	public void save(Customer customer) {
		
		if(customer.getId() != null) {
			customerMapper.update(customer);
		}else {
			customerMapper.save(customer);
				}
	}
	
	@Override
	public Customer findById(Integer id) {
		return customerMapper.findById(id);
	}

	@Override
	public void delete(Integer[] id) {
		customerMapper.delete(id);
	}

}
