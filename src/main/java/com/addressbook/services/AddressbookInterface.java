package com.addressbook.services;

public interface AddressbookInterface <T> {
    public void addPerson();
    public void editPerson();
    public void deletePerson();
    public void sortByName();
    public void sortByZip();
}
