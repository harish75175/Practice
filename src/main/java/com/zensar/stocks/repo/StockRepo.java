package com.zensar.stocks.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.zensar.stocks.entity.StockEntity;
@Repository
@Transactional
public interface StockRepo extends JpaRepository<StockEntity, Integer>{
	StockEntity findByName(String name);

}
