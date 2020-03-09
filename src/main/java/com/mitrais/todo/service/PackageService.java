package com.mitrais.todo.service;

import java.util.List;

import com.mitrais.todo.model.Package;

public interface PackageService {
	void createPackage(Package packageData);
	Package getPackageById(int packageId);
	List<Package> getAllPackage();
	int deleteByPackageId(int packageId);
}
