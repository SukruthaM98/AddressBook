package com.Mphasis.services;

import java.util.Collections;
import java.util.List;
import com.Mphasis.model.Person;
/**@author Sukrutha Manjunath
 * Created Date  : 29-October-2020
 * Functionality : Class for all sorting functions pertaining
 *                 to records such as sort records by ZipCode
 *                 and sort record by FirstName
 */
public class Sort
{
    public static void sortByZip(List<Person> person)
    {
        Collections.sort(person, Person.zipCodeSorting);
        for(Person p: person)
        {
            System.out.println(p);
        }
    }

    public static void sortByName(List<Person> person)
    {
        Collections.sort(person, Person.firstNameSorting);
        for(Person p: person)
        {
            System.out.println(p);
        }
    }
}