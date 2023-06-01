package com.zensar.stocks.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.zensar.stocks.dto.StockDTO;
import com.zensar.stocks.entity.StockEntity;
import com.zensar.stocks.repo.StockRepo;


@Service
public class StockServiceImplementation implements StockService {

	@Autowired
	StockRepo stockrepo;
	@Autowired
	ModelMapper mapp;
	
	
	@Override
	public List<StockDTO> getStocks() {
		List<StockEntity> stocksentity = stockrepo.findAll();
		List<StockDTO> stocksdto=new ArrayList<>();
		for(StockEntity stock:stocksentity)
		{
		 StockDTO map = mapp.map(stock, StockDTO.class);
		 stocksdto.add(map);	
		}
		 
		return stocksdto;
		
	}

}
