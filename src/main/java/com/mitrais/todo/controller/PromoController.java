package com.mitrais.todo.controller;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mitrais.todo.model.Promo;
import com.mitrais.todo.service.PromoService;


@CrossOrigin
@RestController
@RequestMapping("/api")
public class PromoController {

	@Autowired
	private PromoService promoService;
	
	@PostMapping(value="/promo" , consumes={"application/json"})
	public ResponseEntity<?> createPromo(@RequestBody Promo promo) {
		try {
			String promoName = promo.getPromoName();
			Date promoDateStart = promo.getPromoStartDuration();
			Date promoDateEnd = promo.getPromoEndDuration();
			String promoType = promo.getPromoType();
			String promoValType = promo.getPromoValType();
			int promoVal = promo.getPromoVal();
			String status = promo.getStatus();
			String applyToLevel = (promo.getPromoApplyToLevel() == "" || promo.getPromoApplyToLevel() == null) ? "" : promo.getPromoApplyToLevel();
			String applyToCourse = (promo.getPromoApplyToCourse() == "" || promo.getPromoApplyToCourse() == null) ? "" : promo.getPromoApplyToCourse();
			String imageUrl = (promo.getPromoImageUrl() == "" || promo.getPromoImageUrl() == null) ? "" : promo.getPromoImageUrl();

			if (promoName == null || promoType == null || promoDateStart == null ||promoDateEnd == null|| promoValType == null 
					|| promoVal == 0) {
				return ResponseEntity.badRequest()
						.body(Collections.singletonMap("errorMessage", "data promo is invalid"));
			}
			Promo newpromo = new Promo(promoName, promoDateStart, promoDateEnd, promoType,
					promoValType,promoVal, status, applyToLevel, applyToCourse, imageUrl);
			promoService.createPromo(newpromo);
			return new ResponseEntity<>(newpromo,HttpStatus.CREATED);
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest()
					.body(Collections.singletonMap("errorMessage", "could not execute statement"));
		}
	}
	
	@PutMapping(value="/promo" , consumes={"application/json"})
	public ResponseEntity<?> updatepromo(@RequestBody Promo promo) {
		try {
	        if (promo == null) {
				return ResponseEntity.badRequest().body(Collections.singletonMap("errorMessage", "could not execute statement"));
	        }
	        promoService.createPromo(promo);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(Collections.singletonMap("errorMessage", "could not execute statement"));
		}
	}
	
	@GetMapping("/promo/{promoId}")
	public ResponseEntity<?> getpromoById(@PathVariable("promoId") int promoId) throws Exception {
		try{
			Promo promo = promoService.getPromoById(promoId);
			if (promo == null) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}else {
				return new ResponseEntity<>(promo,HttpStatus.OK);
			}
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("/promos")
	public ResponseEntity<List<?>> getAllPromo() throws Exception {
		try{
			List<Promo> promo = promoService.getAllPromo();
			if (promo == null) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}else {
				return new ResponseEntity<>(promo,HttpStatus.OK);
			}
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/promo/{promoId}")
	public ResponseEntity<?> deletePromoById(@PathVariable("promoId") int promoId) throws Exception {
		try{
			int promo = promoService.deleteByPromoId(promoId);
			if (promo == 1) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}else {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("/promoTop1")
	public ResponseEntity<?> getTop1Promo() throws Exception {
		try{
			Promo promo = promoService.getTop1Promo(new Date());
			if (promo == null) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}else {
				return new ResponseEntity<>(promo,HttpStatus.OK);
			}
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}
