package com.chainsys.pharmacyapp.model;

import java.time.LocalDateTime;
import java.util.*;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class Sales {
	private int salesId;
	private int productId;
	private Date salesDate;
	private int salesQuantity;
	private int amount;
}
