package org.example.app.mrs.model;

import org.example.dao.ORM.ModelMapper;

public class Borrower extends ModelMapper<Borrower> {
    int id;
    String name;
    String phone;
    String mail;
    String cni;


    public Borrower(String name, String phone, String mail, String cni) {
        this.id = 0;
        this.name = name;
        this.phone = phone;
        this.mail = mail;
        this.cni = cni;
    }

    public Borrower() {

    }

    @Override
    public Borrower createInstance() {
        return new Borrower();
    }
}

