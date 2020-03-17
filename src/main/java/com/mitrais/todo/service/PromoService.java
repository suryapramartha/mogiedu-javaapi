package com.mitrais.todo.service;

import java.util.Date;
import java.util.List;

import com.mitrais.todo.model.Promo;

public interface PromoService {
	void createPromo(Promo promo);
	Promo getPromoById(int promoId);
	List<Promo> getAllPromo();
	int deleteByPromoId(int promoId);
	Promo getTop1Promo(Date currDate);
}
