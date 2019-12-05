package com.addressbook;

public class PersonDetailsPojo {
    private String firstName;
    private String lastName;
    private String address;
    private String contact;
    AddressDetailsPojo addressDetailsObject;

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

    public AddressDetailsPojo getAddressDetailsObject() {
        return addressDetailsObject;
    }

    public void setAddressDetailsObject(AddressDetailsPojo addressDetailsObject) {
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
