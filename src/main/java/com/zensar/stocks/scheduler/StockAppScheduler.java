package com.zensar.stocks.scheduler;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


import com.zensar.stocks.entity.StockEntity;
import com.zensar.stocks.repo.StockRepo;

@Component
@Transactional
public class StockAppScheduler {
	
	@Autowired
    private StockRepo stockrepo;
	@Autowired
	private SimpMessagingTemplate simpMessagingTemplate;
	
	@Scheduled(fixedDelay = 3000) // Runs every 3 seconds
	    public void updateStockPriceForComanyApple() {
		 
		 
		 
	        // Retrieve the company from the database
	         StockEntity appleStock = stockrepo.findByName("APPLE");
	        
	        // Update the stock price value
	        double currentStockPrice = appleStock.getPrice();
	        double minChange = -0.5; // Minimum change in stock price (-0.5 in this example)
	        double maxChange = 0.5;  // Maximum change in stock price (+0.5 in this example)
	        double randomChange = minChange + Math.random() * (maxChange - minChange);
	        double newStockPrice = currentStockPrice + randomChange;
	        appleStock.setPrice(newStockPrice);
	        //System.out.println(newStockPrice);
	        
	        // Save the updated company back to the database
	        stockrepo.save(appleStock);
	       
	    }
	 
	 @Scheduled(fixedDelay = 3000) 
	    public void updateStockPriceForCompanyIBM() {

		 StockEntity ibmStock = stockrepo.findByName("IBM");
	        
	        // Update the stock price value
	        double currentStockPrice = ibmStock.getPrice();
	        double minChange = -0.5; // Minimum change in stock price (-0.5 in this example)
	        double maxChange = 0.5;  // Maximum change in stock price (+0.5 in this example)
	        double randomChange = minChange + Math.random() * (maxChange - minChange);
	        double newStockPrice = currentStockPrice + randomChange;
	        ibmStock.setPrice(newStockPrice);
	      //  System.out.println(newStockPrice);
	        
	        // Save the updated company back to the database
	        stockrepo.save(ibmStock);
	       
	    }
	 
	 @Scheduled(fixedDelay = 3000) 
	    public void updateStockPriceForCompanyInfosys() {
	       
		 StockEntity infosysStock = stockrepo.findByName("Infosys");
	        
	        // Update the stock price value
	        double currentStockPrice = infosysStock.getPrice();
	        double minChange = -0.5; // Minimum change in stock price (-0.5 in this example)
	        double maxChange = 0.5;  // Maximum change in stock price (+0.5 in this example)
	        double randomChange = minChange + Math.random() * (maxChange - minChange);
	        double newStockPrice = currentStockPrice + randomChange;
	        infosysStock.setPrice(newStockPrice);
	        //System.out.println(newStockPrice);
	        
	        // Save the updated company back to the database
	       stockrepo.save(infosysStock);
	       
	    }
	 
	 @Scheduled(fixedDelay = 3000) 
	    public void updateStockPriceForCompanyReliance() {
	        
		 StockEntity relianceStock = stockrepo.findByName("Reliance");
	        
	        // Update the stock price value
	        double currentStockPrice = relianceStock.getPrice();
	        double minChange = -0.5; // Minimum change in stock price (-0.5 in this example)
	        double maxChange = 0.5;  // Maximum change in stock price (+0.5 in this example)
	        double randomChange = minChange + Math.random() * (maxChange - minChange);
	        double newStockPrice = currentStockPrice + randomChange;
	        relianceStock.setPrice(newStockPrice);
	       // System.out.println(newStockPrice);
	        
	        // Save the updated company back to the database
	        
	        stockrepo.save(relianceStock);
	        
	    }
	    
	 
	 
	 @Scheduled(fixedDelay = 3000) 
	    public void updateStockPriceForCompanyZensar() {
	   
		 StockEntity zensarStock = stockrepo.findByName("Zensar");
	        
	        // Update the stock price value
	        double currentStockPrice = zensarStock.getPrice();
	        double minChange = -0.5; // Minimum change in stock price (-0.5 in this example)
	        double maxChange = 0.5;  // Maximum change in stock price (+0.5 in this example)
	        double randomChange = minChange + Math.random() * (maxChange - minChange);
	        double newStockPrice = currentStockPrice + randomChange;
	        zensarStock.setPrice(newStockPrice);
	        //System.out.println(newStockPrice);
	        
	        // Save the updated company back to the database
	        
	        stockrepo.save(zensarStock);
	        
	    }
	 
	 public List<StockEntity> getAllUpdatedStocks(){
		 return stockrepo.findAll();
	 }
	 
	 @Scheduled(fixedDelay = 3000)
		public void updatedPrice() {
			simpMessagingTemplate.convertAndSend("/topic/stocks", stockrepo.findAll());
		}

}