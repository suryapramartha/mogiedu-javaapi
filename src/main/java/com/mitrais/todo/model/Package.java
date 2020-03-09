package com.mitrais.todo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "mg_package", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
            "package_id"
        })
})
public class Package {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="package_id")
	private int packageId;
	
	@Column(name="package_name")
	private String packageName;
	
	@Column(name = "package_level")
	private String packageLevel;
	
	@Column(name = "package_price_reg_1")
	private int packagePriceReg1;
	
	@Column(name = "package_price_reg_2")
	private int packagePriceReg2;

	@Column(name = "package_price_reg_3")
	private int packagePriceReg3;
	
	@Column(name = "package_price_reg_4")
	private int packagePriceReg4;
	
	@Column(name = "package_price_bil_1")
	private int packagePriceBil1;
	
	@Column(name = "package_price_bil_2")
	private int packagePriceBil2;
	
	@Column(name = "package_price_bil_3")
	private int packagePriceBil3;
	
	@Column(name = "package_price_bil_4")
	private int packagePriceBil4;
	
	@Column(name="status")
	private String status;

	public Package(String packageName, String packageLevel, int packagePriceReg1, int packagePriceBil1,
			String status) {
		super();
		this.packageName = packageName;
		this.packageLevel = packageLevel;
		this.packagePriceReg1 = packagePriceReg1;
		this.packagePriceBil1 = packagePriceBil1;
		this.status = status;
	}
	
	public Package() {}

	public int getPackageId() {
		return packageId;
	}

	public void setPackageId(int packageId) {
		this.packageId = packageId;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getPackageLevel() {
		return packageLevel;
	}

	public void setPackageLevel(String packageLevel) {
		this.packageLevel = packageLevel;
	}

	public int getPackagePriceReg1() {
		return packagePriceReg1;
	}

	public void setPackagePriceReg1(int packagePriceReg1) {
		this.packagePriceReg1 = packagePriceReg1;
	}

	public int getPackagePriceReg2() {
		return packagePriceReg2;
	}

	public void setPackagePriceReg2(int packagePriceReg2) {
		this.packagePriceReg2 = packagePriceReg2;
	}

	public int getPackagePriceReg3() {
		return packagePriceReg3;
	}

	public void setPackagePriceReg3(int packagePriceReg3) {
		this.packagePriceReg3 = packagePriceReg3;
	}

	public int getPackagePriceReg4() {
		return packagePriceReg4;
	}

	public void setPackagePriceReg4(int packagePriceReg4) {
		this.packagePriceReg4 = packagePriceReg4;
	}

	public int getPackagePriceBil1() {
		return packagePriceBil1;
	}

	public void setPackagePriceBil1(int packagePriceBil1) {
		this.packagePriceBil1 = packagePriceBil1;
	}

	public int getPackagePriceBil2() {
		return packagePriceBil2;
	}

	public void setPackagePriceBil2(int packagePriceBil2) {
		this.packagePriceBil2 = packagePriceBil2;
	}

	public int getPackagePriceBil3() {
		return packagePriceBil3;
	}

	public void setPackagePriceBil3(int packagePriceBil3) {
		this.packagePriceBil3 = packagePriceBil3;
	}

	public int getPackagePriceBil4() {
		return packagePriceBil4;
	}

	public void setPackagePriceBil4(int packagePriceBil4) {
		this.packagePriceBil4 = packagePriceBil4;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
