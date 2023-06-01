package com.zensar.stocks.Stocks.service_test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zensar.stocks.controller.StockController;
import com.zensar.stocks.dto.StockDTO;
import com.zensar.stocks.service.StockService;


@WebMvcTest(StockController.class)
public class StockAppServiceImplTest {
	@Autowired
	MockMvc mockMvc;
	@MockBean
	StockService stockService;
	@Autowired
	ObjectMapper objectMapper;
	@Test
	public void showStocks() throws JsonProcessingException, Exception
	{
		List<StockDTO> list=new ArrayList<>();
		list.add(new StockDTO(1,"IBM",45.6));
		list.add(new StockDTO(2,"Infosys",67.6));
		list.add(new StockDTO(3,"Zensar",78.9));
		list.add(new StockDTO(4,"Apple",90.67));
		list.add(new StockDTO(5,"Oracle",89.06));
		MvcResult andReturn = this.mockMvc.perform(get("http://localhost:8050/stocks").contentType("application/json").content(objectMapper.writeValueAsString(list))).andExpect(status().isOk()).andReturn();
		int status2 = andReturn.getResponse().getStatus();
		assertEquals(status2, 200);	
	}
}
