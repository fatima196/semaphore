/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package network;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lenovo
 */
public class Device extends Thread{
    private String name ;
    private String type;
    public int assign;
    //public int wait=0;
    public static Router router;

    public Device(String name , String type,Router r) {
        router=r;
        this.name=name;
        this.type=type;
    }
    
    

    public void setname(String name){
        this.name = name;
    }
    public void setType(String type){
        this.type = type;
    }
    
    public String getname(){
        return this.name;
    }
    
    public String gettype(){
        return this.type;
    }
    public int getassign(){
        return this.assign;
    }
    
    public String connect(){
        return (name +" Occupied");
    }
    
    public String performActivity(){
       return (name +" performs online activity");
    }
    
    public String logout(){
        return(name+" Logged out");
    }

    @Override
    public void run(){
         //router.connectsem.P();
        
      //  try {
         //  File file=new File("D:\\OS.txt");
          //  FileWriter fileWriter = new FileWriter(file, true); //Set true for append mode
              //  PrintWriter printWriter = new PrintWriter(fileWriter);
                   
         try {
           // assign=router.occupy(this);
            String str=("connection " + this.assign + ": "  + router.occupy(this));
            sleep(800);
            System.out.println(str);
           // printWriter.println(str);
            
            
            
         }catch (InterruptedException e) {
            e.printStackTrace();}
       
            try {
                String str2=("connection " + this.assign + ": " + router.serve(this));
                sleep(2000);
                System.out.println(str2);
              //  printWriter.println(str2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        try {
            String str3=("connection " + this.assign + ": " + router.release(this));
            System.out.println(str3);
          //  printWriter.println(str3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
           // router.connectsem.V();
          // printWriter.close();
      //  } catch (IOException ex) {
       //     Logger.getLogger(Device.class.getName()).log(Level.SEVERE, null, ex);
       // }
    }
}
    
    
    

