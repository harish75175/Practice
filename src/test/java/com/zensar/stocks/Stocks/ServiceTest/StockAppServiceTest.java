package com.zensar.stocks.Stocks.ServiceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.zensar.stocks.dto.StockDTO;
import com.zensar.stocks.entity.StockEntity;
import com.zensar.stocks.repo.StockRepo;
import com.zensar.stocks.service.StockService;
import com.zensar.stocks.service.StockServiceImplementation;

@WebMvcTest(StockServiceImplementation.class)
public class StockAppServiceTest {
	@MockBean
	StockRepo stockRepo;
	@Autowired
	StockService stockService;
	@MockBean
	ModelMapper mapper;
	@Test
	public void testStocks() {
		List<StockEntity> list = new ArrayList<>();
		list.add(new StockEntity(1, "IBM", 45.6));
//		list.add(new StockEntity(2, "Infosys", 67.6));
//		list.add(new StockEntity(3, "Zensar", 78.9));
//		list.add(new StockEntity(4, "Apple", 90.67));
//		list.add(new StockEntity(5, "Oracle", 89.06));
		when(stockRepo.saveAll(list)).thenReturn(list);
		List<StockDTO> list1 = new ArrayList<>();
		list1.add(new StockDTO(1, "IBM", 45.6));
//		list1.add(new StockDTO(2, "Infosys", 67.6));
//		list1.add(new StockDTO(3, "Zensar", 78.9));
//		list1.add(new StockDTO(4, "Apple", 90.67));
//		list1.add(new StockDTO(5, "Oracle", 89.06));
		when(stockRepo.findAll()).thenReturn(list);
		when(mapper.map(any(StockEntity.class),eq(StockDTO.class))).thenReturn(list1.get(0));
		List<StockDTO> stocks = stockService.getStocks();
		assertEquals(list1, stocks);
	}
}
