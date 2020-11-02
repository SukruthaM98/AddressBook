package com.Mphasis.services;

import com.Mphasis.model.Person;
import utils.InputUtil;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**@author Sukrutha Manjunath
 * Created Date  : 29-October-2020
 * Functionality : Class for all the functions pertaining
 *                 to the Person services such as:
 *                 Adding person,Edit person,Delete person
 *                 sort person by Zipcode and FirstName
 *                 and Displaying details of records.
 */

public class PersonServices
{
    private static final int PERSON_FNAME = 0;
    private static final int PERSON_LNAME = 1;
    private static final int PERSON_ADDRESS = 2;
    private static final int PERSON_CITY = 3;
    private static final int PERSON_STATE = 4;
    private static final int PERSON_ZIP = 5;
    private static final int PERSON_PHONE = 6;
/**Functionality  : Function for storing person details in list
 * @return person : Returns the list of records
 */
    public static List<Person> getDataInList()
    {
        BufferedReader br = null;
        FileReader fr = null;
        List<Person> person = new ArrayList<Person>();
        try
        {
            String line = "";
            fr = new FileReader("address_book.csv");
            br = new BufferedReader(fr);

            while((line = br.readLine()) != null)
            {
                String[] tokens = line.split(",");
                if(tokens.length > 0)
                {
                    Person person1 = new Person(
                            tokens[PERSON_FNAME],
                            tokens[PERSON_LNAME],
                            tokens[PERSON_ADDRESS],
                            tokens[PERSON_CITY],
                            tokens[PERSON_STATE],
                            tokens[PERSON_ZIP],
                            tokens[PERSON_PHONE]
                            );
                    person.add(person1);
                }
            }
        }
        catch (IOException e)
        {
            System.out.println("Reading CSV Error");
            e.printStackTrace();
        }
        finally
        {
            try {
                fr.close();
            }
            catch (IOException e) {
                System.out.println("Closing File Reader error");
                e.printStackTrace();
            }
        }
        return person;
    }
    /**Functionality  : Function for adding new person to the CSV file
     */
    public void addRecord() throws IOException
    {
        final String fname, lname, address, city, state, phone,zip;

        System.out.print("Enter First Name : ");
        fname = InputUtil.getStringValue();
        System.out.print("Enter Last Name : ");
        lname = InputUtil.getStringValue();
        System.out.print("Enter address : ");
        address = InputUtil.getStringValue();
        System.out.print("Enter city : ");
        city = InputUtil.getStringValue();
        System.out.print("Enter state : ");
        state = InputUtil.getStringValue();
        System.out.print("Enter zip : ");
        zip = InputUtil.getStringValue();
        System.out.print("Enter Phone Number : ");
        phone = InputUtil.getStringValue();

        List<Person> person = Arrays.asList(
                new Person(fname,lname,address,city,state,zip,phone)
        );
        WriteToCSV.writeAddCSV(person);
    }
    /**Functionality  : Function for displaying all records
     */
    public void displayRecord() throws IOException
    {
        List<Person> person = getDataInList();
        for(Person p: person)
        {
            System.out.println(p);
        }

    }

    /**Functionality  : Function for editing details of person
     */
    public void editRecord() throws IOException
    {
        final List<Person> person = getDataInList();
        int id,choice = 0, i=0;
        String firstname,lastname,address,city,state,phone,zip;
        for(Person p: person)
        {
            System.out.println("ID: #"+person.indexOf(p)+" : "+p);
        }
        System.out.print("\nEnter #ID to Edit Contact : ");
        id = InputUtil.getIntValue();
        System.out.println(person.get(id));
        while(i==0) {
            System.out.println("What Do you Want to edit\n"
                    + "\t1: First Name\n"
                    + "\t2: Last Name\n"
                    + "\t3: Address\n"
                    + "\t4: city\n"
                    + "\t5: State\n"
                    + "\t6: Zip Code\n"
                    + "\t7: Phone\n"
                    + "\t8. Save And Exit\n");
            choice = InputUtil.getIntValue();
            switch (choice) {
                case 1:
                    System.out.print("Enter new First Name : ");
                    firstname = InputUtil.getStringValue();
                    person.get(id).setFirstname(firstname);
                    break;
                case 2:
                    System.out.print("Enter new Last Name : ");
                    lastname = InputUtil.getStringValue();
                    person.get(id).setLastname(lastname);
                    break;
                case 3:
                    System.out.print("Enter new Address : ");
                    address = InputUtil.getStringValue();
                    person.get(id).setAddress(address);
                    break;
                case 4:
                    System.out.print("Enter new City : ");
                    city = InputUtil.getStringValue();
                    person.get(id).setCity(city);
                    break;
                case 5:
                    System.out.print("Enter new State : ");
                    state = InputUtil.getStringValue();
                    person.get(id).setState(state);
                    break;
                case 6:
                    System.out.print("Enter new Zip Code : ");
                    zip = InputUtil.getStringValue();
                    person.get(id).setZip(zip);
                    break;
                case 7:
                    System.out.print("Enter new Phone : ");
                    phone = InputUtil.getStringValue();
                    person.get(id).setPhone(phone);
                    break;
                case 8:
                    WriteToCSV.writeFromEdit(person);
                    i=1;
                    break;
                default:
                    System.out.println("Please Enter Valid Option");
            }
            System.out.println(person.get(id));
        }
    }
    /**Functionality  : Function for deleting any record
     */
    public void deleteRecord() throws IOException
    {
        final List<Person> person = getDataInList();
        int id;
        for(Person p: person)
        {
            System.out.println("ID: #"+person.indexOf(p)+" : "+p);
        }
        System.out.print("\nEnter #ID to delete Contact : ");
        id = InputUtil.getIntValue();
        person.remove(id);
        WriteToCSV.writeFromDelete(person);

    }
    /**Functionality  : Function for sorting records according to ZipCode and FirstName
     */
    public void sortRecord() throws IOException
    {
        List<Person> person = getDataInList();
        System.out.println("Sort By...\n 1: First Name\n 2: Zip Code");
        int choice = InputUtil.getIntValue();
        switch (choice)
        {
            case 1:
                Sort.sortByName(person);
                break;
            case 2 :
                Sort.sortByZip(person);
                break;
            default:
                System.out.println("Please Enter Valid Option");
        }
    }

}
