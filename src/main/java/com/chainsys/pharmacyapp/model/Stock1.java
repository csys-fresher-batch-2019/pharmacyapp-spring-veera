package com.chainsys.pharmacyapp.stock1Details;

import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class Stock1 {
	private int stockId;
	private Date stockDate;
	private int productId;
	private int openingStock;
	private int purchaseQuantity;
	private int salesQuantity;
	private int closingStock;
	
}
