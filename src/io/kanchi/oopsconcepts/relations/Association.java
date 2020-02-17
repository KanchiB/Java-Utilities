package io.kanchi.oopsconcepts.relations;

/**Association is relationship between two separate classes through their objects. 
 * It can be one to one, One to many, many to one and many to many.
 * example shows one to manys relation.
 * 
 * @author kanchi
 *
 */

class Bank  
{ 
    private String name; 
      
    // bank name 
    Bank(String name) 
    { 
        this.name = name; 
    } 
      
    public String getBankName() 
    { 
        return this.name; 
    } 
}  
  
// employee class  
class Employee 
{ 
    private String name; 
      
    // employee name  
    Employee(String name)  
    { 
        this.name = name; 
    } 
      
    public String getEmployeeName() 
    { 
        return this.name; 
    }  
} 
  
// Association between both the  
// classes in main method 
class Association  
{ 
    public static void main (String[] args)  
    { 
        Bank bank = new Bank("Axis"); 
        Employee emp = new Employee("Neha"); 
          
        System.out.println(emp.getEmployeeName() +  
               " is employee of " + bank.getBankName()); 
    } 
} 
