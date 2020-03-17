package com.mitrais.todo.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitrais.todo.model.Promo;
import com.mitrais.todo.repository.PromoRepository;
import com.mitrais.todo.service.PromoService;

@Service
public class PromoServiceImpl implements PromoService{

	@Autowired
	private PromoRepository promoRepository;

	@Override
	public void createPromo(Promo promo) {
		this.promoRepository.save(promo);
	}

	@Override
	public Promo getPromoById(int promoId) {
		return this.promoRepository.findByPromoId(promoId);
	}

	@Override
	public List<Promo> getAllPromo() {
		return this.promoRepository.findAll();
	}

	@Override
	public int deleteByPromoId(int promoId) {
		return this.promoRepository.deletePromoByPromoId(promoId);
	}

	@Override
	public Promo getTop1Promo(Date currDate) {
		return this.promoRepository.findTop1Promo(currDate);
	}
	
	
}
