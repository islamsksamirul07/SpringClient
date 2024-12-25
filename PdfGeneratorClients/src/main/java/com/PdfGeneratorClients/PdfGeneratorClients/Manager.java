package com.PdfGeneratorClients.PdfGeneratorClients;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Manager {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int managerId;
    
    // Bidirectional OneToOne mapping with Clients
    @OneToOne
//    @OneToOne(mappedBy = "manager", cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private Clients client;
    
    private boolean approve;
    private boolean reject;
    private String meaasge;

    // Constructors, getters, setters, and toString method
    public Manager() {
        super();
    }
    

    public Manager(int managerId, Clients client, boolean approve, boolean reject, String meaasge) {
		super();
		this.managerId = managerId;
		this.client = client;
		this.approve = approve;
		this.reject = reject;
		this.meaasge = meaasge;
	}


//	public Manager(Clients client, boolean approve, boolean reject) {
//        super();
//        this.client = client;
//        this.approve = approve;
//        this.reject = reject;
//    }

    // Getters and setters
    

    public Clients getClient() {
        return client;
    }

    public void setClient(Clients client) {
        this.client = client;
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
    
    

    public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	

	public String getMeaasge() {
		return meaasge;
	}


	public void setMeaasge(String meaasge) {
		this.meaasge = meaasge;
	}


	@Override
    public String toString() {
        return "Manager [id=" + managerId + ", client=" + client + ", approve=" + approve + ", reject=" + reject + "]";
    }
}
