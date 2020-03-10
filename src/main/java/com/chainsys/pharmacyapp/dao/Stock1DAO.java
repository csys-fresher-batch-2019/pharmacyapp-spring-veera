package com.chainsys.pharmacyapp.dao;

import com.chainsys.pharmacyapp.model.Stock1;

public interface Stock1DAO {
	public int save(Stock1 s) throws Exception;

	public int updateClosingStock(Stock1 s) throws Exception;

	public int updateOpeningStock(int stockId) throws Exception;
}
