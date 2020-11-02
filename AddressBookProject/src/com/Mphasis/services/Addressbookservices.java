package com.Mphasis.services;

import com.Mphasis.controller.Controller;
import com.Mphasis.main.AddressBook;
import com.Mphasis.model.AddressbookModel;
import com.Mphasis.model.Person;
import utils.InputUtil;
import java.io.*;
import java.util.*;

/**@author Sukrutha Manjunath
 * Created Date  : 29-October-2020
 * Modified Date : 02-November-2020
 * Functionality : Class for all the functions pertaining
 *                 to the address book services such as
 *                 creating new addressbook,
 *                 opening existing addressbook,
 *                 save addressbook, save addressbook as.
 */

public class Addressbookservices {
    public static HashMap<AddressbookModel, String> adressbookmap = new HashMap<AddressbookModel, String>();
    String addressbookname;
    /**Functionality          : Function for Reading addressBook from CSV
     * @param addressbookname : Name of the addressBook
     * @return personList     : Returns the list of addressBooks
     */
    public static List readFromACsv(String addressbookname){
        final String COMMA_DELIMITER = ",";
        String PATH="C:/Users/Sukrutha Manjunath/IdeaProjects/Parctice+" + addressbookname;
        List<Person> personList=new ArrayList<Person>();
        BufferedReader br =null;
        try{
            br=new BufferedReader(new FileReader(PATH));
            String line = "";
            br.readLine();
            while ((line = br.readLine()) != null)
            {
                String[] personDetails = line.split(COMMA_DELIMITER);

                if(personDetails.length > 0 )
                {
                    //Save the employee details in Employee object
                    Person person = new Person(personDetails[0],personDetails[1],personDetails[2],
                            personDetails[3],personDetails[4], personDetails[5],personDetails[6]);
                    personList.add(person);
                }
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }
        finally {
            try{
                br.close();
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
        return personList;
    }
    /**Functionality          : Function for Writing addressBook to CSV
     * @param addressbookname : Name of the addressBook
     */
    public static void WriteToACsv(AddressbookModel addressbook,String addressbookname){
        final String COMMA_DELIMITER = ",";
        final String LINE_SEPARATOR = "\n";
        String PATH="C:\\Users\\Srikar\\IdeaProjects\\Addressbook\\src\\com\\mphasis\\data"+"\\"+addressbookname;
        final String HEADER = "Firstname,LastName,Address,City,Pincode,Number";
        List personList=addressbook.getAddressbook();
        FileWriter fileWriter=null;
        try{
            fileWriter=new FileWriter(PATH);
            fileWriter.append(HEADER);
            fileWriter.append("\n");
            Iterator it=personList.iterator();
            while (it.hasNext()){
                Person person=(Person) it.next();
                fileWriter.append(person.getFirstname());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(person.getLastname());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(person.getAddress());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(person.getCity());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(person.getZip());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(person.getPhone());
                fileWriter.append(LINE_SEPARATOR);
            }
        }
        catch(Exception ee)
        {
            ee.printStackTrace();
        }
        finally
        {
            try
            {
                fileWriter.close();
            }
            catch(IOException ie)
            {
                System.out.println("Error occured while closing the fileWriter");
                ie.printStackTrace();
            }
        }
    }
    /**Functionality : Function for Creating new AddressBook
     */
    public AddressbookModel newAddressbook() throws IOException {
        if (adressbookmap.containsValue("open")) {
            System.out.println("close the current addressbook to create new one");
            AddressBook.mainfunction();
        } else {
            System.out.println("enter the addressbook name :");
            Scanner scanner = new Scanner(System.in);
            addressbookname = scanner.nextLine() + ".csv";

            try {
                String PATH = "C:/Users/Sukrutha Manjunath/IdeaProjects/Parctice+" + addressbookname;
                File file = new File(PATH);
                if (file.createNewFile()) {
                    System.out.println("welcome to addressbook " + addressbookname);
                    return new AddressbookModel();
                } else {
                    System.out.println("file already exits");
                    AddressBook.mainfunction();
                }
            } catch (IOException ee) {
                System.out.println("error");
                ee.printStackTrace();
            }
            return null;
        }
        AddressbookModel addressbookModel = new AddressbookModel();
        addressbookModel.setaddressbookname(addressbookModel.getaddressbookname());
        addressbookModel.setSaved("yes");
        adressbookmap.put(addressbookModel, "open");
        System.out.println("choose a case ");
        System.out.println("Case1 :add a person , Case2 :Back to main menu");
        int input = InputUtil.getIntValue();
        switch (input) {
            case 1:
                PersonServices personServices = new PersonServices();
                personServices.addRecord();
                break;
            case 2:
                close();
                break;
        }

        return null;
    }
    /**Functionality : Function for opening existing AddressBook
     */
    public List openExistingAddressBook() throws IOException {
        String PATH = "C:/Users/Sukrutha Manjunath/IdeaProjects/Parctice+" + addressbookname;
        File file = new File(PATH);
        if (file.exists()) {
            return readFromACsv(addressbookname);
        } else {
            System.out.println("address book with given name donot exits");
        }

        if (adressbookmap.containsValue("open")) {
            System.out.println("please close current addressbook first");
            AddressBook.mainfunction();
        } else {
            System.out.println("enter the addressbook name :");
            String addressbookname = InputUtil.getStringValue();
            addressbookname = addressbookname + ".csv";
            List personlist=Addressbookservices.readFromACsv(addressbookname);
            AddressbookModel addressbookModel = new AddressbookModel();
            addressbookModel.setaddressbookname(addressbookname);
            addressbookModel.setAddressbook(personlist);
            addressbookModel.setSaved("yes");
            adressbookmap.put(addressbookModel, "open");
            Controller.person();
        }
        return null;
    }

    /**Functionality          :Function to save a addressbook as
     * @param:addressbookname :name of the addressbook
     * @param:addressbook     :object of addressbook
     */
    public void saveAs(String addressbookname,AddressbookModel addressbook){
        Addressbookservices.WriteToACsv(addressbook,addressbookname);
        String OldPATH="C:/Users/Sukrutha Manjunath/IdeaProjects/Parctice+"+"\\"+addressbookname;
        File oldfile=new File(OldPATH);
        System.out.println("enter the name of addressbook want to save as:");
        Scanner scanner=new Scanner(System.in);
        String newaddressbookname=scanner.nextLine()+".csv";
        String NewPATH="C:/Users/Sukrutha Manjunath/IdeaProjects/Parctice+"+"\\"+newaddressbookname;
        File newfile=new File(NewPATH);
        oldfile.renameTo(newfile);
    }
    public static void saveAS() throws IOException {
        AddressbookModel addressbookModel=null;
        for(AddressbookModel ad:adressbookmap.keySet()){
            if(adressbookmap.get(ad).equalsIgnoreCase("open")){
                addressbookModel=ad;
                break;
            }
        }
        if(addressbookModel==null){
            System.out.println("open or create addressbook to use saveas functionality");
            AddressBook.mainfunction();
        }
        addressbookModel.setSaved("yes");
        Addressbookservices addressbookservices=new Addressbookservices();
        addressbookservices.saveAs(addressbookModel.getaddressbookname(),addressbookModel);
        System.out.println("saved details sucessfully");
        AddressBook.mainfunction();
    }
    /**Functionality          :Function to save a addressbook
     * @param:addressbookname :name of the addressbook
     * @param:addressbook     :object of addressbook
     * */
    public void save(String addressbookname,AddressbookModel addressbook){
        Addressbookservices.WriteToACsv(addressbook,addressbookname);
    }
    public static void save() throws IOException {
        AddressbookModel addressbook=null;
        for(AddressbookModel ad:adressbookmap.keySet()){
            if(adressbookmap.get(ad).equalsIgnoreCase("open")){
                addressbook=ad;
                break;
            }
        }
        if(addressbook==null){
            System.out.println("open or create address book to use save functionallity");
            AddressBook.mainfunction();
        }
        if(addressbook.getSaved().equalsIgnoreCase("yes")){
            System.out.println("nothing to save");
            AddressBook.mainfunction();
        }
        else {
            addressbook.setSaved("yes");
            Addressbookservices addressbookservices=new Addressbookservices();
            addressbookservices.save(addressbook.getaddressbookname(),addressbook);
            System.out.println("details saved sucessfully");
            AddressBook.mainfunction();}
    }
    /**Functionality : Function for Closing AddressBook
     */
    public void close() throws IOException {
        System.out.println("address book is closed");
        AddressBook.mainfunction();
    }
    public static void closeAddressbook() throws IOException {
        AddressbookModel addressbook=null;
        Addressbookservices addressbookservices=new Addressbookservices();
        for(AddressbookModel ad:adressbookmap.keySet()){
            if(adressbookmap.get(ad).equalsIgnoreCase("open")){
                addressbook=ad;
                break;
            }
        }
        if(addressbook==null){
            System.out.println("open or create a addressbook to use close functionality");
            AddressBook.mainfunction();
        }
        adressbookmap.put(addressbook,"closed");
        if(addressbook.getSaved()=="yes"){
            System.out.println("addressbook closed sucessfully");
            AddressBook.mainfunction();
        }
        else {
            System.out.println("the addressbook is not saved:");
            System.out.println("choose a case below");
            System.out.println("case 1:save addressbook , case 2: save addressbook as , case 3:don't save changes");
            Scanner scanner=new Scanner(System.in);
            int input=scanner.nextInt();
            scanner.nextLine();
            switch (input){
                case 1:
                    addressbook.setSaved("yes");
                    addressbookservices.save(addressbook.getaddressbookname(),addressbook);
                    System.out.println("addressbook closed sucessfully");
                    AddressBook.mainfunction();
                case 2:
                    addressbook.setSaved("yes");
                    addressbookservices.saveAs(addressbook.getaddressbookname(),addressbook);
                    System.out.println("addressbook closed sucessfully");
                    AddressBook.mainfunction();
                case 3:
                    System.out.println("addressbook closed sucessfully");
                    AddressBook.mainfunction();
            }
        }

    }
    /**Functionality : Function for exiting AddressBook
     */
    public static void  exit(){
        AddressbookModel addressbook=null;
        Addressbookservices addressbookservices=new Addressbookservices();
        for(AddressbookModel ad:adressbookmap.keySet()){
            if(adressbookmap.get(ad).equalsIgnoreCase("open")){
                addressbook=ad;
                break;
            }
        }
        if(addressbook==null){
            System.out.println("program terminated");
            System.exit(0);
        }
        adressbookmap.put(addressbook,"closed");
        if(addressbook.getSaved()=="yes"){
            System.out.println("program terminated");
            System.exit(0);
        }
        else {
            System.out.println("the addressbook is not saved:");
            System.out.println("choose a case below");
            System.out.println("case 1:save addressbook , case 2: save addressbook as , case 3:don't save changes");
            Scanner scanner=new Scanner(System.in);
            int input=scanner.nextInt();
            scanner.nextLine();
            switch (input){
                case 1:
                    addressbook.setSaved("yes");
                    addressbookservices.save(addressbook.getaddressbookname(),addressbook);
                    System.out.println("program terminated");
                    System.exit(0);
                case 2:
                    addressbook.setSaved("yes");
                    addressbookservices.saveAs(addressbook.getaddressbookname(),addressbook);
                    System.out.println("program terminated");
                    System.exit(0);
                case 3:
                    System.out.println("program terminated");
                    System.exit(0);
            }
        }
    }
}
