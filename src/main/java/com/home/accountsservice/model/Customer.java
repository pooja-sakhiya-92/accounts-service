package com.home.accountsservice.model;

import javax.persistence.*;

@Entity
public class Customer {

    public Customer() {

    }

    public Customer(int customerNumber, String contactFirstName, String contactLastName) {

        this.contactFirstName = contactFirstName;
        this.contactLastName = contactLastName;
        this.customerNumber = customerNumber;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int customerNumber;

    @Column
    private String contactFirstName;

    @Column
    private String contactLastName;

    public int getCustomerNumber() {
        return customerNumber;
    }

    public String getContactFirstName() {
        return contactFirstName;
    }

    public String getContactLastName() {
        return contactLastName;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerNumber=" + customerNumber +
                ", contactFirstName='" + contactFirstName + '\'' +
                ", contactLastName='" + contactLastName + '\'' +
                '}';
    }
}
