package com.addressbook.models;

public class PersonDetails {
    private String firstName;
    private String lastName;
    private String address;
    private String contact;
    AddressDetails addressDetailsObject;

    public PersonDetails(String firstName, String lastName, String address, String contact,
                         AddressDetails addressDetailsObject) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.contact = contact;
        this.addressDetailsObject = addressDetailsObject;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public AddressDetails getAddressDetailsObject() {
        return addressDetailsObject;
    }

    public void setAddressDetailsObject(AddressDetails addressDetailsObject) {
        this.addressDetailsObject = addressDetailsObject;
    }

    @Override
    public String toString() {
        return "PersonDetailsPojo{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", contact='" + contact + '\'' +
                ", addressDetailsObject=" + addressDetailsObject +
                '}';
    }
}
