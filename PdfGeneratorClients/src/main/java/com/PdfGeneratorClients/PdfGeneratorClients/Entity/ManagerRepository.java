package com.PdfGeneratorClients.PdfGeneratorClients.Entity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository<Manager,Integer> {
	public Manager findByManagerId(int id);

}
