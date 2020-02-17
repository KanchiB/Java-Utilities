package io.kanchi.oopsconcepts.design.coupling;

/**Tight Coupling is when any change in class A, forces class B to change often.
 * Example below: any change in the Topic class requires Subject class to change.
 * 
 * @author kanchi
 *
 */

 class Subject { 
    Topic t = new Topic(); 
    public void startReading() 
    { 
        t.understand(); 
    } 
} 
class Topic { 
    public void understand() 
    { 
        System.out.println("Tight coupling concept"); 
    } 
} 