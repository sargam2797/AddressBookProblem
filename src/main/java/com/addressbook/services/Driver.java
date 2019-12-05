package com.addressbook.services;

import com.addressbook.models.PersonDetails;

public class Driver {
    public static void main(String[] args) {
        AddressBookManager<PersonDetails> personDetailsAddressBookManager = new AddressBookManager<>();
        personDetailsAddressBookManager.addPerson();

    }
}
