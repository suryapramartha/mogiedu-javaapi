package com.mitrais.todo.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mitrais.todo.model.Package;;


public interface PackageRepository extends JpaRepository<Package, Integer> {
	Package findByPackageId(int packageId);

	List<Package> findAll();
	
	@Transactional
	@Modifying
	@Query(value="Delete from Package u WHERE u.packageId = :packageId")
	int deletePackageByPackageId(@Param("packageId") int packageId);
}
