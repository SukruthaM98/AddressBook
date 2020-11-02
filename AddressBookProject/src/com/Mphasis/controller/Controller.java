package com.Mphasis.controller;
import com.Mphasis.services.Addressbookservices;
import com.Mphasis.services.PersonServices;
import utils.InputUtil;
import java.io.IOException;
/**@author Sukrutha Manjunath
 * Created Date  : 29-October-2020
 * Modified Date : 02-November-2020
 * Functionality : Controller operates different functions
 *                 and methods for different features
 *
 */
public class Controller {
    final Addressbookservices addressbookservices = new Addressbookservices();

    public void newAddressbook() throws IOException {
        addressbookservices.newAddressbook();
    }

    public void openExistingAddressBook() throws IOException {
        addressbookservices.openExistingAddressBook();
    }

    public void save() throws IOException {
        addressbookservices.save();
    }

    public void saveAs() throws IOException {
        addressbookservices.saveAS();
    }

    public void closeAddressbook() throws IOException {
        addressbookservices.closeAddressbook();
    }

    public void exit() {
        addressbookservices.exit();
    }

    final PersonServices personServices = new PersonServices();

    public void addperson() throws IOException {
        personServices.addRecord();
    }

    public void editperson() throws IOException {
        personServices.editRecord();
    }

    public void deleteperson() throws IOException {
        personServices.deleteRecord();
    }

    public void sort() throws IOException {
        personServices.sortRecord();
    }

    public void displayperson() throws IOException {
        personServices.displayRecord();
    }

    /*Functionality : Function for accessing different features such as: adding,editing,deleting,
     *                 sorting and displaying details of records
     */
    public static void person() throws IOException {
        {
            int choice, i = 0;
            final Controller controller = new Controller();
            while (i == 0) {
                System.out.println("--- Enter Your Choice ---");
                System.out.println("1: Add New Person\n2: Edit Record\n3: Delete Person Record\n4: Sort Person Record\n" +
                        "5: Display Person Record\n6: Exit ");
                choice = InputUtil.getIntValue();
                switch (choice) {
                    case 1:
                        controller.addperson();
                        break;
                    case 2:
                        controller.editperson();
                        break;
                    case 3:
                        controller.deleteperson();
                        break;
                    case 4:
                        controller.sort();
                        break;
                    case 5:
                        controller.displayperson();
                        break;
                    case 6:
                        i = 1;
                        break;
                    default:
                        System.out.println("Please Enter Valid Option!!!");
                }
            }
        }
    }
}
