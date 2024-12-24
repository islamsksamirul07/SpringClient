package com.PdfGeneratorClients.PdfGeneratorClients.Entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClientsRepository extends JpaRepository<Clients, Integer> {
	Clients findById(int id);
	
	@Query("SELECT COALESCE(MAX(c.id), 0) FROM Clients c")
    Integer findMaxId();
	

}
