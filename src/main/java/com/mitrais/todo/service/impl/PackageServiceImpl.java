package com.mitrais.todo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitrais.todo.model.Package;
import com.mitrais.todo.repository.PackageRepository;
import com.mitrais.todo.service.PackageService;

@Service
public class PackageServiceImpl implements PackageService{

	@Autowired
	PackageRepository packageRepository;
	@Override
	public void createPackage(Package packageData) {
		this.packageRepository.save(packageData);
	}

	@Override
	public Package getPackageById(int packageId) {
		return this.packageRepository.findByPackageId(packageId);
	}

	@Override
	public List<Package> getAllPackage() {
		return this.packageRepository.findAll();
	}

	@Override
	public int deleteByPackageId(int packageId) {
		return this.packageRepository.deletePackageByPackageId(packageId);
	}

}
