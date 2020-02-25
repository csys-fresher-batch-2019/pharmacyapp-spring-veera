package com.chainsys.pharmacyapp.stock1Details;

public interface Stock1DAO {
int addStockDetails(Stock1 s)throws Exception;
int updateClosingStock(Stock1 s) throws Exception;
int updateOpeningStock(int stockId) throws Exception;
}
