package org.example.app.mrs.model.entity;

import org.example.dao.ORM.ModelMapper;

public class Borrower extends ModelMapper<Borrower> {
    private int  id;
    private String name;
    private String phone;
    private String mail;
    private String cni;


    public Borrower(String name, String phone, String mail, String cni) {
        this.id = 0;
        this.name = name;
        this.phone = phone;
        this.mail = mail;
        this.cni = cni;
    }

    public Borrower() {
    }

    public Borrower(int id, String name, String phone, String mail, String cni) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.mail = mail;
        this.cni = cni;
    }

    @Override
    public Borrower createInstance() {
        return new Borrower();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setCni(String cni) {
        this.cni = cni;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getMail() {
        return mail;
    }

    public String getCni() {
        return cni;
    }

    public void setId(int borrowerId) {
        this.id = borrowerId;
    }
}



