package com.hand.SpringMybatisExam.service;

import java.util.Date;
import java.util.Scanner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hand.SpringMybatisExam.entity.Address;
import com.hand.SpringMybatisExam.entity.Customer;
import com.hand.SpringMybatisExam.mapper.AddressMapper;
import com.hand.SpringMybatisExam.mapper.CustomerMapper;
@RunWith(SpringJUnit4ClassRunner.class) //使用Springtest框架
@ContextConfiguration("/ApplicationContext.xml") //加载配置
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerMapper customerMapper;
	
	@Autowired
	AddressMapper addressMapper;
	
	
	public void insert() {
		Customer customer=new Customer();
        Scanner input=new Scanner(System.in);
        System.out.println("请输入First Name：");
        customer.setFirst_name(input.nextLine());
        System.out.println("请输入Last Name:");
        customer.setLast_name(input.nextLine());
        System.out.println("请输入email:");
        customer.setEmail(input.nextLine());
        System.out.println("请输入address id:");
        boolean address_id_isCorrect=true;
        while(address_id_isCorrect)
        {
        	int id=input.nextInt(); 
        	Address result=addressMapper.getAddress_id(id);
        	if(result!=null)
        	{
        		address_id_isCorrect=false;
        		customer.setAddress_id(id);
        	}
        	else
        	{
        		System.out.println("输入错误，请重新输入：");
        	}
        }
        customer.setStore_id(1);
        customer.setCreate_date(new Date());
        customerMapper.insert(customer);
	}
	
	@Test
	public void getCustomer() {
		int id=customerMapper.getMaxCustomer();
		System.out.println("您刚刚输入的id为："+id);
		Customer customer=customerMapper.getCustomer(id);
		System.out.println(customer.getFirst_name());
		System.out.println(customer.getLast_name());
		System.out.println(customer.getEmail());
		System.out.println(customer.getCreate_date());
	}

}
