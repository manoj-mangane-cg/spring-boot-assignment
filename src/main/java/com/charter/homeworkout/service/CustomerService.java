package com.charter.homeworkout.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.charter.homeworkout.dto.CustomerDTO;
import com.charter.homeworkout.utils.CustomerUtils;
import com.charter.homeworkout.vo.CustomerPointVO;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class CustomerService {
	
	/**
	 * @return List<CustomerDTO>
	 */
	public List<CustomerDTO> getCustomerList(){
		List<CustomerDTO> dtoCustList = null;
		
		// create Object Mapper
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);

		// read JSON file and map/convert to java POJO
		try {
			String strInputFilepath = new File("src//main//resources//customerData.json").getAbsolutePath();
			dtoCustList = Arrays.asList(mapper.readValue(Paths.get(strInputFilepath).toFile(), CustomerDTO[].class));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		return dtoCustList;
	}
	
	
	/**
	 * @return
	 */
	public List<CustomerPointVO> getCustomerPointList(){
		List<CustomerPointVO> custPointList = null;
		try {
			
			//STEP 1 : Get all the customerList
			List<CustomerDTO> dtoCustList = getCustomerList();
			
			//STEP2: Calculate the points based on each customer monthwise
			if(CustomerUtils.isValidList(dtoCustList)) {
				String strSeparator = ":~:";
				Double totalTrxAmt = 0.0;
				int noOfTrx = 1;
				Map<String, CustomerDTO> hm = new HashMap<>();
				
				for(CustomerDTO customerDTO : dtoCustList){
					String key = customerDTO.getCustId()+strSeparator+customerDTO.getCustName()+strSeparator+CustomerUtils.getMonthByDate(customerDTO.getCustTrxDate())+strSeparator+CustomerUtils.getYearByDate(customerDTO.getCustTrxDate());
					if(hm.get(key)!=null) {
						totalTrxAmt = hm.get(key).getTrxAmt() + customerDTO.getTrxAmt();
						noOfTrx = hm.get(key).getNoOfTrx()+noOfTrx;
					} else {
						totalTrxAmt = customerDTO.getTrxAmt();
					}
					customerDTO.setNoOfTrx(noOfTrx);
					customerDTO.setTrxAmt(totalTrxAmt);
					hm.put(key, customerDTO);
					totalTrxAmt = 0.0;
					noOfTrx = 1;
				}
				
				//STEP 3: Iterate & Set the values to Value/Response Object
				if(null!=hm && hm.size()>0) {
					custPointList = new ArrayList<>();
				
					for (Map.Entry<String, CustomerDTO> entry : hm.entrySet()) {
				        custPointList.add(setValuesToCustomerPointVO(entry));
				    }
				}
			}
			
		} catch (Exception e) {
			custPointList = null;
			e.printStackTrace();
		}
		return custPointList;
	}
	
	/**
	 * @param entry
	 * @return
	 */
	public CustomerPointVO setValuesToCustomerPointVO(Map.Entry<String, CustomerDTO> entry ) {
		CustomerPointVO customerPointVO = null;
		Integer custId = 0;
        String custName = "";
        Integer trxPoint = 0;
        String trxMonthYear = "";
        Double totalTrxAmt = 0.0;
        int noOfTrx = 0;
		try {
			custId = entry.getValue().getCustId();
			custName = entry.getValue().getCustName();
			totalTrxAmt = entry.getValue().getTrxAmt();
			trxPoint = CustomerUtils.calculatePoint(totalTrxAmt) ;
			trxMonthYear = CustomerUtils.getMonthByDate(entry.getValue().getCustTrxDate())+"-"+CustomerUtils.getYearByDate(entry.getValue().getCustTrxDate());
			noOfTrx =  entry.getValue().getNoOfTrx();
			customerPointVO = new CustomerPointVO(custId, custName, noOfTrx, trxPoint, trxMonthYear, totalTrxAmt);
		} catch (Exception e) {
			e.printStackTrace();
			customerPointVO = null;
		}
		
		return customerPointVO;
	}
	

}
