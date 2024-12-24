package com.PdfGeneratorClients.PdfGeneratorClients.Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientsService {
	
	@Autowired
	public ClientsRepository clientsRepository;
	 @Autowired
	 private ManagerRepository managerRepository;
	
	public List<ClientManagerDTO > getData(){
		
		List<Clients> clients=clientsRepository.findAll();
//		List<Manager> manager=managerRepository.findAll();
		List<ClientManagerDTO> dto=new ArrayList<>();
		
		
		for (Clients client : clients) {
            Manager manager = client.getManager();
            dto.add(new ClientManagerDTO(client, manager));
        }
		
		return dto;
		
		
	}
	
//	this will generate the ID from database
	public int generateID() {
		int maxId=clientsRepository.findMaxId();
		return maxId+1;
	}
	
	public void addData(Clients employee) {
		int maxId=generateID();
		employee.setId(maxId);
		Manager manager=new Manager();
		manager.setManagerId(employee.getId());
		manager.setApprove(false);
		manager.setReject(false);
		manager.setClient(employee);
		
		employee.setManager(manager);
		
		clientsRepository.save(employee);
	}
	
	public void deleteData(int id) {
		clientsRepository.deleteById(id);
	}
	public ClientManagerDTO oneEmplEmployee(int id) {
//		return clientsRepository.findById(id);
		
		Clients client=clientsRepository.findById(id);
		Manager manager=managerRepository.findByManagerId(id);
		return new ClientManagerDTO(client, manager);
	}
	public void updateClients(Clients client) {
		int id=client.getId();
		Manager manager=managerRepository.findByManagerId(id);
		manager.setClient(client);
		client.setManager(manager);
		clientsRepository.deleteById(id);
		clientsRepository.save(client);
	}

}
