package com.PdfGeneratorClients.PdfGeneratorClients.Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Clients {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String name;
    private String mail;
    private String project;
    private String description;
    private int amount;
    
    // Bidirectional OneToOne mapping with Manager
    @OneToOne(mappedBy = "client", cascade = CascadeType.ALL)
//    @OneToOne
    private Manager manager;

    // Constructors, getters, setters, and toString method
    public Clients() {
        super();
    }

    public Clients(int id, String name, String mail, String project, String description, int amount, Manager manager) {
        super();
        this.id = id;
        this.name = name;
        this.mail = mail;
        this.project = project;
        this.description = description;
        this.amount = amount;
        this.manager = manager;
    }

    // Getters and setters
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

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    @Override
    public String toString() {
        return "Clients [id=" + id + ", name=" + name + ", mail=" + mail + ", project=" + project + ", description="
                + description + ", amount=" + amount + "]";
    }
}
