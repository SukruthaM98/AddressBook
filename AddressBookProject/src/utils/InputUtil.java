package utils;

import java.util.Scanner;
/**@author Sukrutha Manjunath
 * Created Date  : 29-October-2020
 * Functionality : Class for easy access of Scanner
 *
 */
public class InputUtil
{
    private final static Scanner sc = new Scanner(System.in);
    public static int getIntValue()
    {
        return sc.nextInt();
    }
    public static String getStringValue()
    {
        return sc.next();
    }
}
