package com.chainsys.pharmacyapp.service;

import com.chainsys.pharmacyapp.dao.Stock1DAO;
import com.chainsys.pharmacyapp.dao.impl.Stock1Implementation;
import com.chainsys.pharmacyapp.model.Stock1;

public class Stock1Service {
	Stock1DAO S=new Stock1Implementation();
	public int addStockDetails(Stock1 s)throws Exception
	{
		return S.addStockDetails(s);
		
	}
	public int updateClosingStock(Stock1 s) throws Exception
	{
		return S.updateClosingStock(s);
		
	}
	public int updateOpeningStock(int stockId) throws Exception
	{
		return S.updateOpeningStock(stockId);
		
	}
}
