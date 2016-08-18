package com.hand.SpringMybatisExam.service;

import java.util.Date;
import java.util.Scanner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.hand.SpringMybatisExam.entity.Address;
import com.hand.SpringMybatisExam.entity.Customer;
import com.hand.SpringMybatisExam.mapper.AddressMapper;
import com.hand.SpringMybatisExam.mapper.CustomerMapper;
@RunWith(SpringJUnit4ClassRunner.class) //使用Springtest框架
@ContextConfiguration("/ApplicationContext.xml") //加载配置
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	 private PlatformTransactionManager transactionManager;
	@Autowired
	CustomerMapper customerMapper;
	@Autowired
	AddressMapper addressMapper;
	
	@Test
	public void insert() {
		 TransactionDefinition def=new DefaultTransactionDefinition();
		  TransactionStatus status=transactionManager.getTransaction(def);
		try {
			Customer customer=new Customer();
			Scanner input=new Scanner(System.in);
			System.out.println("please insert first name：");
			customer.setFirst_name(input.nextLine());
			System.out.println("please insert last name:");
			customer.setLast_name(input.nextLine());
			System.out.println("enter your email:");
			customer.setEmail(input.nextLine());
			System.out.println("your address id:");
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
					System.out.println("address id NOT FOUND，please re-enter：");
				}
			}
			customer.setStore_id(1);
			customer.setCreate_date(new Date());
			customerMapper.insert(customer);
			
			
			int id=customerMapper.getMaxCustomer();
			System.out.println("your id ："+id);
			Customer customer2=customerMapper.getCustomer(id);
			String address=addressMapper.getAddressById(customer.getAddress_id()).getAddress();
			
			System.out.println(customer2.getFirst_name());
			System.out.println(customer2.getLast_name());
			System.out.println(address);
			System.out.println(customer2.getEmail());
			System.out.println(customer2.getCreate_date());
		} catch (Exception e) {
			try{
				transactionManager.rollback(status);
				System.out.println("inserted failed，rollback  successfully!");
			}
			catch(Exception e1)
			{
				System.out.println("rollback failed");
			}
		}
	}
	
   public void deleteCustomer(){
	   TransactionDefinition def=new DefaultTransactionDefinition();
		  TransactionStatus status=transactionManager.getTransaction(def);
	   try {
		Scanner input=new Scanner(System.in);
		   System.out.println("请输入要删除的id：");
		   customerMapper.deleteCustomer(input.nextInt());
		   System.out.println("删除成功");
	} catch (Exception e) {
		transactionManager.rollback(status);
		System.out.println("删除失败，rollback成功");
	}
   }


}
