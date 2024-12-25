package com.PdfGeneratorClients.PdfGeneratorClients;

public class ClientManagerDTO {
	
//	this are clients data
	private int id;
    private String name;
    private String mail;
    private String project;
    private String description;
    private int amount;
    
//    this are manager data
    private int managerId;
    private boolean approve;
    private boolean reject;
    private String message;
    
    
    
	public ClientManagerDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ClientManagerDTO(Clients client, Manager manager) {
		super();
		this.id = client.getId();
		this.name = client.getName();
		this.mail = client.getMail();
		this.project = client.getProject();
		this.description = client.getDescription();
		this.amount = client.getAmount();
		this.managerId = manager.getManagerId();
		this.approve = manager.isApprove();
		this.reject = manager.isReject();
		this.message=manager.getMeaasge();
	}

	
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public boolean isApprove() {
		return approve;
	}
	public void setApprove(boolean approve) {
		this.approve = approve;
	}
	public boolean isReject() {
		return reject;
	}
	public void setReject(boolean reject) {
		this.reject = reject;
	}
    
    

}
