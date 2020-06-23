
package network;

import static java.lang.Thread.sleep;


public class Router {

    public boolean[] connectionArray;
    public int nRouterConnections;
    public Semaphore connectsem;
    public int nOccupied;
    int wait=1;
    
    
    Router (int nRouterConnections ){
        this.nRouterConnections=nRouterConnections;
        connectsem=new Semaphore (this.nRouterConnections);
        connectionArray=new boolean[this.nRouterConnections];
        for (int i=0 ; i<connectionArray.length ; i++){
            connectionArray[i] = false;
        }
        
    }
    
    public synchronized String occupy(Device d)throws InterruptedException{
         System.out.println("----->"+d.getname());
         
        for (int i = 0; i < nRouterConnections; i++) {
            if (connectionArray[i] == false  ) { 
                connectsem.P();
                
                //System.out.println(d.getname());
               // nOccupied++;
                d.assign=i+1;
                //System.out.println("assignBefore-->"+d.assign);
                //System.out.println("connection " + d.assign + ": " + d.getname() + " occupied");
                //d.connect() ;
                connectionArray[i] = true;
                
                return d.connect();
            }
        }//d.assign=wait;
        return ( d.getname() + " arrived and is waiting");
    }
    
    public String serve(Device d) throws InterruptedException {
        
       return d.performActivity(); 
        
    }
    
    
    public synchronized String release(Device d) throws InterruptedException { 
             //wait =d.getassign();//1
             //System.out.println("assign--->"+wait);
             connectsem.V();
            //connectionArray[d.assign-1] = false;
            
            
            
           // System.out.println("assignAfter-->"+d.assign);
            
            
        return d.logout();
        
    }
    
}
