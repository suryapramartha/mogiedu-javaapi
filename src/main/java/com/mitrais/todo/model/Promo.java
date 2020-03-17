package com.mitrais.todo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mg_promo")
public class Promo {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="promo_id")
	private int promoId;
	
	@Column(name="promo_name")
	private String promoName;
	
	@Column(name="promo_start_duration")
	private Date promoStartDuration;
	
	@Column(name="promo_end_duration")
	private Date promoEndDuration;
	
	@Column(name="promo_type")
	private String promoType;
	
	@Column(name="promo_val_type")
	private String promoValType;
	
	@Column(name="promo_val")
	private int promoVal;
	
	@Column(name="promo_apply_to_level", nullable = true)
	private String promoApplyToLevel;
	
	@Column(name="promo_apply_to_course", nullable = true)
	private String promoApplyToCourse;
	
	@Column(name="promo_image_url", nullable = true)
	private String promoImageUrl;
	
	@Column(name="status", nullable = true)
	private String status;

	public Promo(String promoName, Date promoStartDuration, Date promoEndDuration, String promoType,
			String promoValType, int promoVal, String status , String promoApplyToLevel , String promoApplyToCourse, String promoImageUrl) {
		this.promoName = promoName;
		this.promoStartDuration = promoStartDuration;
		this.promoEndDuration = promoEndDuration;
		this.promoType = promoType;
		this.promoValType = promoValType;
		this.promoVal = promoVal;
		this.status = status;
		this.promoApplyToLevel = promoApplyToLevel;
		this.promoApplyToCourse = promoApplyToCourse;
		this.promoImageUrl = promoImageUrl;
	}

	public Promo() {
	}

	public int getPromoId() {
		return promoId;
	}

	public void setPromoId(int promoId) {
		this.promoId = promoId;
	}

	public String getPromoName() {
		return promoName;
	}

	public void setPromoName(String promoName) {
		this.promoName = promoName;
	}

	public Date getPromoStartDuration() {
		return promoStartDuration;
	}

	public void setPromoStartDuration(Date promoStartDuration) {
		this.promoStartDuration = promoStartDuration;
	}

	public Date getPromoEndDuration() {
		return promoEndDuration;
	}

	public void setPromoEndDuration(Date promoEndDuration) {
		this.promoEndDuration = promoEndDuration;
	}

	public String getPromoType() {
		return promoType;
	}

	public void setPromoType(String promoType) {
		this.promoType = promoType;
	}

	public String getPromoValType() {
		return promoValType;
	}

	public void setPromoValType(String promoValType) {
		this.promoValType = promoValType;
	}

	public int getPromoVal() {
		return promoVal;
	}

	public void setPromoVal(int promoVal) {
		this.promoVal = promoVal;
	}

	public String getPromoApplyToLevel() {
		return promoApplyToLevel;
	}

	public void setPromoApplyToLevel(String promoApplyToLevel) {
		this.promoApplyToLevel = promoApplyToLevel;
	}

	public String getPromoApplyToCourse() {
		return promoApplyToCourse;
	}

	public void setPromoApplyToCourse(String promoApplyToCourse) {
		this.promoApplyToCourse = promoApplyToCourse;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPromoImageUrl() {
		return promoImageUrl;
	}

	public void setPromoImageUrl(String promoImageUrl) {
		this.promoImageUrl = promoImageUrl;
	}
	
}
