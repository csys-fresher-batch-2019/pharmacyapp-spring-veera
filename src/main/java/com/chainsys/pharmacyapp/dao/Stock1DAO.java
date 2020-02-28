package com.chainsys.pharmacyapp.dao;

import com.chainsys.pharmacyapp.model.Stock1;

public interface Stock1DAO {
int addStockDetails(Stock1 s)throws Exception;
int updateClosingStock(Stock1 s) throws Exception;
int updateOpeningStock(int stockId) throws Exception;
}
