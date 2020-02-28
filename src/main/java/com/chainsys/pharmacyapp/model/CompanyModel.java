package com.chainsys.pharmacyapp.companyDetails;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import pharmacyapp.admin.AdminDetails;

/**Testmodel
 * 
 * @author veer2379
 *
 */
@Data
@ToString
@NoArgsConstructor
public class CompanyModel {
	private int companyId;
	private String companyName;
	private String companyType;
    private String companyAddress;
	
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyType() {
		return companyType;
	}
	public void setCompanyType(String companyType) {
		this.companyType = companyType;
	}
	public String getCompanyAddress() {
		return companyAddress;
	}
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}
	

}
