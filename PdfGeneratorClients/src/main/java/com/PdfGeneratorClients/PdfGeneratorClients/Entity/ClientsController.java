package com.PdfGeneratorClients.PdfGeneratorClients.Entity;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@CrossOrigin(origins = "http://localhost:3000")
@CrossOrigin("*")
@RequestMapping("/client")
public class ClientsController {
	
	@Autowired
	public ClientsService clientsService;
	@Autowired
	private PdfService pdfService;
	
	@GetMapping("/all-Clients")
	public List<ClientManagerDTO > allEmployee() {
		return clientsService.getData();
	}
	@PostMapping("/delete")
	public String deleteData(@RequestParam int id) {
		clientsService.deleteData(id);
		return "Employee deleted successfully";
	}
	@PostMapping("/find")
	public ClientManagerDTO find(@RequestParam int id) {
		return clientsService.oneEmplEmployee(id);
	}
	@GetMapping("/client-id")
	public int generatedId() {
		return clientsService.generateID();
	}
	
	@PostMapping("/add")
	public String addEmployee(@RequestBody Clients client) {
		clientsService.addData(client);
		return "Employee added successfully";
	}
	
	@PostMapping("/update-client")
	public void updateClients(@RequestBody Clients client) {
		clientsService.updateClients(client);
	}
	
	@GetMapping("/pdf-generate")
	public ResponseEntity<InputStreamResource> createPdf(@RequestParam int id){
//		Clients employee=new Clients(id, "Samirul","islamsksamirul70@gmail.com", "WIPRO", "Generate internal project", 50000,false,false);
		ClientManagerDTO emp1=clientsService.oneEmplEmployee(id);
		
		ByteArrayInputStream pdf=pdfService.createPdf(emp1);
		HttpHeaders httpHeader= new HttpHeaders();
		httpHeader.add("Content-Disposition", "inline; filename=clients.pdf");
//		httpHeader.add("Contend-Dispositions", "inline; file=employee.pdf");
//		
		return ResponseEntity.ok().headers(httpHeader).contentType(MediaType.APPLICATION_PDF).body(new InputStreamResource(pdf));
		
		
	}
	
	

}
