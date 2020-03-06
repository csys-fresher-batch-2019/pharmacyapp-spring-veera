package com.chainsys.pharmacyapp.Exception;

public class InfoMessages {
private InfoMessages()
{
	throw new IllegalStateException("Utility Class");
	}
public static final String CONNECTION = "Unable to Establish Connection 'SERVER ERROR'";
public static final String lOGIN = "Unable to lOGIN ";
public static final String COMPANY = "Unable to Add CompanyDetails";
public static final String ORDER = "Unable to Add OrderDetails";
public static final String ORDERDISPLAY = "Unable to Display ProductDetails";
public static final String PRODUCTUPDATETYPE = "Unable to Update ProductType";
public static final String PURCHASE = "Unable to Add PurchaseDetails";
public static final String UPDATECOST = "Unable to Update ProductCost";
public static final String DISPLAYPRODUCT = "Unable to Display the Product";
public static final String SELECTPRODUCT = "Unable to Select the Product";
public static final String UPDATECLOSINGSTOCK = "Unable to Update the stock";
public static final String UPDATEOPENINGSTOCK = "Unable to Update the stock";
public static final String ADDPRODUCT = "Unable to Add product Details";

}
