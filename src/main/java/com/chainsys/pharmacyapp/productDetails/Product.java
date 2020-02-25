package com.chainsys.pharmacyapp.productDetails;

import java.time.LocalDate;
import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import com.chainsys.pharmacyapp.companyDetails.CompanyModel;

/**TestModel
 * 
 * @author veer2379
 *
 */
@Data
@ToString
@NoArgsConstructor

public class Product {
	private int productId;
	private String productName;
	private String productType;
	private int cost;
	private int quantity;
	private LocalDate expiryDate;
@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productType=" + productType
				+ ", cost=" + cost + ", Quantity ="+quantity+", expiryDate=" + expiryDate + "]";
	}


}


