package com.Mphasis.model;
import java.util.ArrayList;
import java.util.List;
/**@author Sukrutha Manjunath
 * Created Date  : 29-October-2020
 * Modified Date : 02-November-2020
 * Functionality : Model which contains constructors,
 *                 getter and setters for Addressbook
 *                 operations.
 */
public class AddressbookModel {
    private List book;
    private String name;
    private String saved;
    private List<Person> addressbook =new ArrayList<Person>();

    public AddressbookModel(){
        this.book= addressbook;
    }
    /**Functionality : Getter for List containing Person Details
    */
    public  List<Person> getAddressbook(){
        return this.book;
    }

    /**Functionality    : Setter for List of Person Details
     *@param personlist : Array list of person details
     */
    public void setAddressbook(List personlist){
        book=personlist;
    }
    /**Functionality : Setter for name of Address Book
     * @param name   : Name of the address book
     */
    public void setaddressbookname(String name){
        this.name=name;
    }
    /**Functionality : Getter for name of Address Book
     */
    public String getaddressbookname(){
        return this.name;
    }
    /**Functionality : Setter for saved value of addressbook
     * @param saved  : show if addressbook is saved or not
     * */
    public void setSaved(String saved){
        this.saved=saved;
    }
    /**Functionality : String for the saved value of addressbook
     */
    public String getSaved( ){
        return this.saved;
    }
}
