package org.pallas.alaprest.dtos;

import org.pallas.alaprest.models.Address;

public class PersonResponse {
    private String name;
    private int birthYear;
    private Address address;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
