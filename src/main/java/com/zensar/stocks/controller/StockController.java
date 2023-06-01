package com.zensar.stocks.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.stocks.dto.StockDTO;
import com.zensar.stocks.service.StockService;

@RestController
@CrossOrigin(origins = "*")
//@RequestMapping("/stock")
public class StockController {

	@Autowired
	StockService stockservice;
	
//	 private final SimpMessagingTemplate messagingTemplate;
//
//	    @Autowired
//	    public StockController(SimpMessagingTemplate messagingTemplate) {
//	       this.messagingTemplate = messagingTemplate;
//	    }

    @GetMapping(value = "/stocks", produces = MediaType.APPLICATION_JSON_VALUE)
//	@MessageMapping("/stock-price")	
    @SendTo("/topic/stocks")
	public ResponseEntity<List<StockDTO>> getUserById() {
		return new ResponseEntity<List<StockDTO>>(stockservice.getStocks(), HttpStatus.OK);
	}
}
