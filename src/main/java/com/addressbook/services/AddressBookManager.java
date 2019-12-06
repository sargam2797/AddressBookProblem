package com.addressbook.services;

import com.addressbook.models.AddressDetails;
import com.addressbook.models.PersonDetails;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonParseException;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class
AddressBookManager implements AddressbookInterface {
    static ObjectMapper mapper = new ObjectMapper();

    List<PersonDetails> list = new ArrayList<>();
    static String filePath = "/home/user/IdeaProjects/AddressBookProblem/src/main/resources/Details.json";

    @Override
    public PersonDetails addPerson(String fname, String lname, String add, String contact,
                                   AddressDetails addressDetails) throws IOException {
        PersonDetails personDetails = new PersonDetails(fname,lname,add,contact,addressDetails);
        List<PersonDetails> list= readFile(filePath);
        list.add(personDetails);
        writeToFile(list,filePath);
        return personDetails;
    }

    private List<PersonDetails> readFile(String filePath) throws FileNotFoundException {

        File file = new File(filePath);

        try {
            List<PersonDetails> list = new ArrayList(Arrays.asList(mapper.readValue(file, PersonDetails[].class)));
            return list;
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean isFileAvailable(String destinationFolder, String fileName) {
        String fullPath = destinationFolder + fileName;
        File file = new File(fullPath);
        if (file.exists()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String createNewFile(String destinationFile, String fileName) throws IOException {
        String fullPath = destinationFile + fileName;
        File file = new File(fullPath);
        if (file.createNewFile())
            return "True";
        else
            return "False";
    }

    @Override
    public String deleteFile(String destinationFile, String fileName) throws IOException {
        String fullPath = destinationFile + fileName;
        File file = new File(fullPath);
        if (file.delete())
            return "file deleted successfully";
        else
            return "file not found to delete";
    }

    public boolean writeToFile(List<PersonDetails> personDetails, String filePath) {
        String JSON_FILE_PATH = filePath;
        Gson gson = new Gson();
        String json = gson.toJson(personDetails);
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
    public String editPerson(String lastName,String add,String contactNo, AddressDetails addressDetails, String filePath) throws FileNotFoundException {
        List<PersonDetails> list = readFile(filePath);
        for (int i = 0; i < list.size(); i++) {
            if(contactNo.equalsIgnoreCase(list.get(i).getContact())) {
                list.get(i).setLastName(lastName);
              list.get(i).setAddress(add);
                list.get(i).setAddressDetailsObject(addressDetails);
                writeToFile(list,filePath);
                return "record edited successfully";
            }
        }
        return "no record found to edit";
    }

    @Override
    public String deletePerson(String firstName, String fileName) throws FileNotFoundException {
        List<PersonDetails> list = readFile(filePath);
        List<PersonDetails> anotherList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            if(!firstName.equalsIgnoreCase(list.get(i).getFirstName())) {
                anotherList.add(list.get(i));
            }
            else {
                return "record removed successfully";
            }
            writeToFile(anotherList,filePath);
        }
        return "record not present to remove";
    }

    @Override
    public boolean sortByName(String firstName) throws FileNotFoundException {
        List<PersonDetails> list = readFile(filePath);
        for (int i =0; i < list.size()-1; i++) {
            for (int j = 0; j < list.size()-i-1; j++) {
                if (list.get(j).getFirstName().compareTo(list.get(j+1).getFirstName()) > 0) {
                    PersonDetails temp = list.get(j);
                    list.set(j,list.get(j+1));
                    list.set(j+1,temp);
                }
            }
        }
        writeToFile(list,filePath);
        return true;
    }

    @Override
    public void sortByZip() {

    }

}
