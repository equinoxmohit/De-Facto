/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohit.defacto.entity;

/**
 *
 * @author Mohit
 */
public class Author {
    private int authorId;
    private String authorName,address,mobileNumber,email;
    private boolean status;

    public Author() {
    }

    public Author(int authorId, String authorName, String address, String mobileNumber, String email,boolean status) {
        this.authorId = authorId;
        this.authorName = authorName;
        this.address = address;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.status=status;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    
    
}
