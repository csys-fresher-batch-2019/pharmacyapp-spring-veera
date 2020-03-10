package com.chainsys.pharmacyapp.Exception;

public class InfoMessages {
	private InfoMessages() {
		throw new IllegalStateException("Utility Class");
	}

	public static final String CONNECTION = "Unable to Establish Connection 'SERVER ERROR'";
	public static final String INVALID_lOGIN = "Unable to lOGIN ";
	public static final String INVALID_COMPANY = "Unable to Add CompanyDetails";
	public static final String INVALID_ORDER = "Unable to Add OrderDetails";
	public static final String INVALID_ORDERDISPLAY = "Unable to Display ProductDetails";
	public static final String INVALID_PRODUCTUPDATETYPE = "Unable to Update ProductType";
	public static final String INVALID_PURCHASE = "Unable to Add PurchaseDetails";
	public static final String INVALID_UPDATECOST = "Unable to Update ProductCost";
	public static final String INVALID_ADDPRODUCT = "Unable to Add product Details";
	public static final String INVALID_DISPLAYPRODUCT = "Unable to Display the Product";
	public static final String INVALID_SELECTPRODUCT = "Unable to Select the Product";
	public static final String INVALID_UPDATECLOSINGSTOCK = "Unable to Update the stock";
	public static final String INVALID_UPDATEOPENINGSTOCK = "Unable to Update the stock";

}
