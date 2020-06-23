
package network;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;


public class network {

    /**
     * @param <error>
     * @param args the command line arguments
     */
    
    public static String Start(Device d[]) throws InterruptedException{
        String str="";
                for (int i = 0; i < d.length ; i++) {
            Thread.sleep(1000);
            d[i].start();
        }
       return str;

    }
        
    public static void main(String[] args) throws InterruptedException, FileNotFoundException {
        
        Scanner input1 = new Scanner(System.in);
        
        System.out.println("Enter the maximam number of connection to the router");
        int nconnections = input1.nextInt();
        Router router = new Router(nconnections); 

        
        System.out.println("Enter the total number of devices");
        int nDevices = input1.nextInt();
        
        Device[] device = new Device[nDevices];

        System.out.println("What is the Device's Name and Type?");
        input1=new Scanner(System.in);
        
        for (int j = 0; j < nDevices; j++) {
            String str=input1.next();
            input1.reset();
            String str2 =input1.next();
            device[j] = new Device(str,str2,router);
            
            
        }

        /*for (int i = 0; i < nDevices; i++) {
            //Thread.sleep(1000);
            device[i].start();
        }*/
        PrintStream s=new PrintStream(new File("D:\\OS2.txt"));
        System.setOut(s);
        s.print(Start (device));
    }
    
    }
    

