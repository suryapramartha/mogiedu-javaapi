package com.mitrais.todo.repository;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mitrais.todo.model.Promo;

public interface PromoRepository extends JpaRepository<Promo, Integer> {
	Promo findByPromoId(int promoId);
	List<Promo> findAll();
	
	@Transactional
	@Modifying
	@Query(value="Delete from Promo u WHERE u.promoId = :promoId")
	int deletePromoByPromoId(@Param("promoId") int promoId);
	
	@Query(nativeQuery = true,
			value = "SELECT * from mg_promo p "
					+ "where p.promo_start_duration <= :currDate"
					+ " and p.promo_end_duration >= :currDate"
					+ " and p.status = 'ACTIVE' LIMIT 0,1")
	Promo findTop1Promo(Date currDate);

}
