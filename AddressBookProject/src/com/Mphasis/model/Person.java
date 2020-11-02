package com.Mphasis.model;

import java.util.Comparator;
/**@author Sukrutha Manjunath
 * Created Date  : 29-October-2020
 * Modified Date : 02-November-2020
 * Functionality : Model which contains constructors,
 *                 getter and setters for operations
 *                 on records stored.
 */
public class Person
{
    private String firstname, lastname, address, city, state, zip, phone;
/**Functionality : Constructor for class Person
 */
    public Person(String firstname, String lastname, String address, String city, String state,String zip,String phone)
    {
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
    }
    /**Functionality : Getter and setter for FirstName
     */
    public String getFirstname()
    {
        return firstname;
    }

    public void setFirstname(String firstname)
    {
        this.firstname = firstname;
    }
    /**Functionality : Getter and setter for LastName
     */
    public String getLastname()
    {
        return lastname;
    }

    public void setLastname(String lastname)
    {
        this.lastname = lastname;
    }
    /**Functionality : Getter and setter for Address
     */
    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }
    /**Functionality : Getter and setter for City
     */
    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }
    /**Functionality : Getter and setter for State
     */
    public String getState()
    {
        return state;
    }

    public void setState(String state)
    {
        this.state = state;
    }
    /**Functionality : Getter and setter for PhoneNumber
     */
    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }
    /**Functionality : Getter and setter for ZipCode
     */
    public String getZip()
    {
        return zip;
    }

    public void setZip(String zip)
    {
        this.zip = zip;
    }

    /** Functionality : Function for sorting records by ZipCode
     */
    public static Comparator<Person> zipCodeSorting = new Comparator<Person>() {


        @Override
        public int compare(Person p1, Person p2)
        {
            String zip1 = p1.getZip();
            String zip2 = p2.getZip();
            return zip1.compareTo(zip2);
        }
    };

    /** Functionality : Function for sorting records by FirstName
     */
    public static Comparator<Person> firstNameSorting = new Comparator<Person>() {


        @Override
        public int compare(Person p1, Person p2)
        {
            String fname1 = p1.getFirstname();
            String fname2 = p2.getFirstname();
            return fname2.compareTo(fname1);
        }
    };

    @Override
    public String toString() {
        return "Person [ firstname=" + firstname + "   lastname=" + lastname + "   address=" + address + "   city=" + city + "   state="
                + state + "  phone=" + phone + "   zip=" + zip + " ]";
    }

}
