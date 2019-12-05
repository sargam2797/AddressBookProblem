package com.addressbook.services;

import com.addressbook.models.AddressDetails;
import com.addressbook.models.PersonDetails;

import java.util.ArrayList;
import java.util.List;

public class AddressBookManager implements AddressbookInterface {

    List<PersonDetails> list = new ArrayList<>();

    @Override
    public PersonDetails addPerson(String fname, String lname, String add, String contact,
                                   AddressDetails addressDetails) {
        PersonDetails personDetails = new PersonDetails(fname,lname,add,contact,addressDetails);
        list.add(personDetails);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        return personDetails;
    }

    @Override
    public void editPerson() {

    }

    @Override
    public void deletePerson() {

    }

    @Override
    public void sortByName() {

    }

    @Override
    public void sortByZip() {

    }



}
