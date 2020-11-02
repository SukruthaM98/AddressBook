package com.Mphasis.main;
import com.Mphasis.controller.Controller;
import utils.InputUtil;
import java.io.IOException;
/**@author Sukrutha Manjunath
 * Created Date  : 29-October-2020
 * Modified Date : 02-November-2020
 * Functionality : Program for Address book storing
 *                 addresses of people with advance
 *                 features.
 */

public class AddressBook {

    public static void main(String[] args) throws IOException
    {
        AddressBook addressBook=new AddressBook();
        addressBook.mainfunction();
    }
    public static void mainfunction() throws IOException {
        int choice,i=0;
        final Controller controller = new Controller();

            System.out.println("--- Enter Your Choice ---");
            System.out.println("1: Add New Address Book\n2:Open Existing Address Book\n3:Save Address Book\n" +
                    "4: Save Address Book As\n5: Close Address Book\n6: Exit ");
            choice = InputUtil.getIntValue();
            switch(choice)
            {
                case 1 :
                    controller.newAddressbook();
                    break;
                case 2 :
                    controller.openExistingAddressBook();
                    break;
                case 3 :
                   controller.save();
                    break;
                case 4 :
                   controller.saveAs() ;
                    break;
                case 5 :
                    controller.closeAddressbook();
                    break;
                case 6 :
                  controller.exit();
                    break;
                default :
                    System.out.println("Please Enter Valid Option!!!");
            }
    }
}
