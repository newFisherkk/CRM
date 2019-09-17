package com.service;

import java.util.List;

import com.pojo.Customer;


public interface CustomerService {
	
	//��ѯ��������
	List<Customer> findAll();
	
	//��������
	void save(Customer customer);

	//�޸�����ʱ�����ݻ���
	Customer findById(Integer id);

	void delete(Integer[] id);
}
