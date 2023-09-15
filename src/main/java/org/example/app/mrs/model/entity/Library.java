package org.example.app.mrs.model.entity;

import org.example.framwork.dao.ORM.ModelMapper;

public class Library extends ModelMapper<Library> {


    private int id;
    private  String name ;
    private  String address ;
    private  String ouner ;
    private    int capacity ;
    private int totalBooks;
    private String password;

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setOuner(String ouner) {
        this.ouner = ouner;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getOuner() {
        return ouner;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getTotalBooks() {
        return totalBooks;
    }

    public String getPassword() {
        return password;
    }



    public Library(int totalBooks) {
        this.totalBooks = totalBooks;
    }

    public Library(String name, String address, String ouner, int capacity , String password) {
        this.name = name;
        this.address = address;
        this.ouner = ouner;
        this.capacity = capacity;
        this.password = password;
    }

    public Library() {

    }


    @Override
    public Library createInstance() {
        return  new Library();
    }

    public void setTotalBooks(int newBooksNumber) {
        this.totalBooks = newBooksNumber;
    }

}
