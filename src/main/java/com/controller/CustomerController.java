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

	//注入业务对象 save需要

	@Resource
	private CustomerService customerService;




	@RequestMapping("/list")
	@ResponseBody
	public List<Customer> list(){
		List<Customer> list =customerService.findAll();
		return list;
	}

	//设计Map集合存储需要给页面的数据
	private Map<String, Object> result =new HashMap<>();

//	查询所有数据,给页面返回json格式的数据
//	easyui的datagrid组件，展示提供json数据：[{id:xx,name:xx},{id:xx,name:xx}]
//datagrid默认穿过来的pageSize为10（即rows）
	@RequestMapping("/listByPage")
	@ResponseBody
	public Map<String,Object> listByPage(Integer page,Integer rows){
		//设置分页参数\
		System.out.println("page"+page+"--rows:"+rows);
		PageHelper.startPage(page, rows);
		//查询所有数据
		List<Customer> list =customerService.findAll();
		//使用PageInfo封装查询结果
		PageInfo<Customer> pageInfo =new PageInfo<>(list);

		//从pageInfo里面取出查询结果
		//总记录数
		long total=pageInfo.getTotal();
		//当前页数据列表
		List<Customer> custlist=pageInfo.getList();
		//返回给页面的数据
		//后台向页面传递的total代表数据的总数，类似于：select count（*）from XX  。rows表示返回的数据 List<?> data.
		result.put("total",total);
		result.put("rows", custlist);

		return result;
	}

	//保存数据 不用请求参数，自动帮你封装为Customer对象
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

	//根据id查询对象
	@RequestMapping("/findById")
	@ResponseBody
	public Customer findById(Integer id) {
		Customer customer=customerService.findById(id);
		return customer;
	}

	//删除数据 用数组接收 id=1&id=2&id=3
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
