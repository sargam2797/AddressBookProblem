package com.addressbook.services;

import com.addressbook.models.AddressDetails;
import com.addressbook.models.PersonDetails;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class AddressBookManager implements AddressbookInterface {

    List<PersonDetails> list = new ArrayList<>();
    static String filePath = "/home/user/IdeaProjects/AddressBookProblem/src/main/resources/Details.json";

    @Override
    public PersonDetails addPerson(String fname, String lname, String add, String contact,
                                   AddressDetails addressDetails) throws IOException {
        PersonDetails personDetails = new PersonDetails(fname,lname,add,contact,addressDetails);
        list.add(personDetails);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
            writeToFile(personDetails,filePath);
        }
        return personDetails;
    }

    public boolean writeToFile(PersonDetails personDetails, String filePath) {
        String JSON_FILE_PATH = filePath;
        Gson gson = new Gson();
        String json = gson.toJson(list);
        FileWriter writer = null;
        try {
            writer = new FileWriter(JSON_FILE_PATH);
            writer.write(json);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
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
