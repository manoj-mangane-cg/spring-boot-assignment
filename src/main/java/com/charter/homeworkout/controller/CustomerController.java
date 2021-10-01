package com.charter.homeworkout.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.charter.homeworkout.dto.CustomerDTO;
import com.charter.homeworkout.service.CustomerService;
import com.charter.homeworkout.vo.CustomerPointVO;


@RestController("/")
public class CustomerController {
	
	@Autowired
	private CustomerService custService;
	
	@GetMapping("getCustomerList")
	public List<CustomerDTO> getCustomerList(){
		List<CustomerDTO> dtoCustList = null;
		try {
			dtoCustList = custService.getCustomerList();
		} catch (Exception e) {
			// TODO: handle exception
			dtoCustList = null;
			e.printStackTrace();
		}
		return dtoCustList;
	} 
	
	@GetMapping("getCustomerPointList")
	public List<CustomerPointVO> getCustomerPointList(){
		List<CustomerPointVO> custPointList = null;
		try {
			custPointList = custService.getCustomerPointList();
		} catch (Exception e) {
			custPointList = null;
			e.printStackTrace();
		}
		return custPointList;
	}
	

}
