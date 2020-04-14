package demo;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.apache.commons.codec.digest.DigestUtils;
/**
 * Hello world!
 *
 */

public class App {
    static String Account="";
    static String Password = "";
    public static void main(String[] args) throws IOException {
             Account=args[0];
             Password=args[1];
             login();

    }
    public static String sha256hex(String input) {
        return DigestUtils.sha256Hex(input);
    }
    public static Boolean login() throws IOException {
        //Scanner sc = new Scanner(System.in);
      //  System.out.print("Account:");
      //  String Account = sc.nextLine();
       // System.out.print("Password:");
       // String Password = sc.nextLine();
        BufferedReader br = new BufferedReader(new FileReader("information.txt"));
        String line;
        while((line=br.readLine())!=null) {

            String [] infor = line.split(" ");

            if(Account.equals(infor[0])&&App.sha256hex(Password).equals(infor[1])) {
                System.out.print("Load in successful");
                br.close();
                return true;
            }
        }
        System.out.print("Load in defeated");
        br.close();
        return false;
    }
}
