package io.kanchi.oopsconcepts.relations;

/** Aggregation is a weak form of association which is unidirectional in nature.
 * Student has address , but vice versa not true, "has-a" relationship.
 * other object can exist meaningfully like Address.
 * @author kanchi
 *
 */

class Address
{
	int streetNum;
	String state;
	String country;
	Address(int street, String st, String coun)
	{
		this.streetNum=street;
		this.state = st;
		this.country = coun;
	}
	@Override
	public String toString() {
		return "Address [streetNum=" + streetNum + ", state=" + state + ", country=" + country + "]";
	}
	
}

class StudentClass
{
	int rollNum;
	String studentName;
	//Creating HAS-A relationship with Address class
	Address studentAddr; 
	StudentClass(int roll, String name, Address addr){
		this.rollNum=roll;
		this.studentName=name;
		this.studentAddr = addr;
	}
	@Override
	public String toString() {
		return "StudentClass [rollNum=" + rollNum + ", studentName=" + studentName + ", studentAddr=" + studentAddr
				+ "]";
	}
	
}

public class Aggregation {

	public static void main(String[] args) {
		Address ad = new Address(5, "Maharashtra", "India");
		StudentClass obj = new StudentClass(23, "Chaitanya", ad);
		System.out.println(obj.toString());

	}

}
