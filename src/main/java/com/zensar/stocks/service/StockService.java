package com.zensar.stocks.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.zensar.stocks.dto.StockDTO;

@Service
@Component
public interface StockService {
	List<StockDTO> getStocks();

}
