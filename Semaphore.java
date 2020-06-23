/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package network;

/**
 *
 * @author lenovo
 */
public class Semaphore {
    Device d;
    protected int value = 0 ;
    protected Semaphore() { value = 0 ; }
    protected Semaphore(int initial) { value = initial ; }
    public synchronized void P() {
    value-- ;
    if (value < 0)
    try { wait() ;} catch( InterruptedException e ) { }
    }
    public synchronized void V() {
    value++ ; if (value <= 0) notify();
    }
}
