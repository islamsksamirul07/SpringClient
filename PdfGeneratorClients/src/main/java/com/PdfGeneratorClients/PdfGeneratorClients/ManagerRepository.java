package com.PdfGeneratorClients.PdfGeneratorClients;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository<Manager,Integer> {
	public Manager findByManagerId(int id);

}
