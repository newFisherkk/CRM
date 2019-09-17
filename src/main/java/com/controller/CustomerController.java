package com.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pojo.Customer;
import com.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	//ע��ҵ����� save��Ҫ

	@Resource
	private CustomerService customerService;




	@RequestMapping("/list")
	@ResponseBody
	public List<Customer> list(){
		List<Customer> list =customerService.findAll();
		return list;
	}

	//���Map���ϴ洢��Ҫ��ҳ�������
	private Map<String, Object> result =new HashMap<>();

//	��ѯ��������,��ҳ�淵��json��ʽ������
//	easyui��datagrid�����չʾ�ṩjson���ݣ�[{id:xx,name:xx},{id:xx,name:xx}]
//datagridĬ�ϴ�������pageSizeΪ10����rows��
	@RequestMapping("/listByPage")
	@ResponseBody
	public Map<String,Object> listByPage(Integer page,Integer rows){
		//���÷�ҳ����\
		System.out.println("page"+page+"--rows:"+rows);
		PageHelper.startPage(page, rows);
		//��ѯ��������
		List<Customer> list =customerService.findAll();
		//ʹ��PageInfo��װ��ѯ���
		PageInfo<Customer> pageInfo =new PageInfo<>(list);

		//��pageInfo����ȡ����ѯ���
		//�ܼ�¼��
		long total=pageInfo.getTotal();
		//��ǰҳ�����б�
		List<Customer> custlist=pageInfo.getList();
		//���ظ�ҳ�������
		//��̨��ҳ�洫�ݵ�total�������ݵ������������ڣ�select count��*��from XX  ��rows��ʾ���ص����� List<?> data.
		result.put("total",total);
		result.put("rows", custlist);

		return result;
	}

	//�������� ��������������Զ������װΪCustomer����
	@RequestMapping("/save")
	@ResponseBody
	public Map<String,Object> save(Customer customer){
		try {
			System.out.println(customer);
			customerService.save(customer);
			result.put("success",true);
		}catch (Exception e) {
			result.put("success",false);
			e.printStackTrace();
			result.put("msg",e.getMessage());
		}
		return result;
	}

	//����id��ѯ����
	@RequestMapping("/findById")
	@ResponseBody
	public Customer findById(Integer id) {
		Customer customer=customerService.findById(id);
		return customer;
	}

	//ɾ������ ��������� id=1&id=2&id=3
	@RequestMapping("/delete")
	@ResponseBody
	public Map<String,Object> delete(Integer[] id){
		try {
			customerService.delete(id);
			result.put("success",true);
		}catch (Exception e) {
			e.printStackTrace();
			result.put("success",false);
			result.put("msg",e.getMessage());
		}
		return result;
	}
}
