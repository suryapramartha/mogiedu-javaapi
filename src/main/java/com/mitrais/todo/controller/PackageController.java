package com.mitrais.todo.controller;

import java.util.Collections;
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

import com.mitrais.todo.model.Package;
import com.mitrais.todo.service.PackageService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class PackageController {
	@Autowired
	PackageService packageService;

	@PostMapping(value="/package" , consumes={"application/json"})
	public ResponseEntity<?> createPackage(@RequestBody Package packageData) {
		try {
			String packageName = packageData.getPackageName();
			String packageLevel = packageData.getPackageLevel();
			int packagePriceReg1 = packageData.getPackagePriceReg1();
			int packagePriceBil1 = packageData.getPackagePriceBil1();
			String status = packageData.getStatus();
 
			if (packageName == null || packageLevel == null ||packagePriceReg1 == 0 || packagePriceBil1 == 0 || status == null) {
				return ResponseEntity.badRequest()
						.body(Collections.singletonMap("errorMessage", "data package is invalid"));
			}
			Package newPackage = new Package(packageName, packageLevel, packagePriceReg1, packagePriceBil1, status);
			packageService.createPackage(packageData);
			return new ResponseEntity<>(newPackage,HttpStatus.CREATED);
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest()
					.body(Collections.singletonMap("errorMessage", "could not execute statement"));
		}
	}
	
	@PutMapping(value="/package" , consumes={"application/json"})
	public ResponseEntity<?> updatePackage(@RequestBody Package packageData) {
		try {
	        if (packageData == null) {
				return ResponseEntity.badRequest().body(Collections.singletonMap("errorMessage", "could not execute statement"));
	        }
	        packageService.createPackage(packageData);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(Collections.singletonMap("errorMessage", "could not execute statement"));
		}
	}
	
	@GetMapping("/package/{packageId}")
	public ResponseEntity<?> getPackageById(@PathVariable("packageId") int packageId) throws Exception {
		try{
			Package packageObj = packageService.getPackageById(packageId);
			if (packageObj == null) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}else {
				return new ResponseEntity<>(packageObj,HttpStatus.OK);
			}
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("/packages")
	public ResponseEntity<List<?>> getAllPackage() throws Exception {
		try{
			List<Package> packageObj = packageService.getAllPackage();
			if (packageObj == null) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}else {
				return new ResponseEntity<>(packageObj,HttpStatus.OK);
			}
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/package/{packageId}")
	public ResponseEntity<?> deletePackageById(@PathVariable("packageId") int packageId) throws Exception {
		try{
			int packageObj = packageService.deleteByPackageId(packageId);
			if (packageObj == 1) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}else {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("/package-sd/{packageId}")
	public ResponseEntity<?> getPackageSdById(@PathVariable("packageId") int packageId) throws Exception {
		try{
			Package packageObj = packageService.getPackageById(packageId);
			if (packageObj == null) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}else {
				return new ResponseEntity<>(packageObj,HttpStatus.OK);
			}
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}
