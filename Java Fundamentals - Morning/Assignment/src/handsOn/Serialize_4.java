
package handsOn;

import java.io.*; 

class Emp implements Serializable 
{ 
	
	     private static final long serialversionUID = 138344020485707635L; 
		 String name; 
		 int marks;
		 int age; 
	
		// Default constructor 
	public Emp(String name, int age, int marks) 
		{ 
			this.name = name; 
			this.age = age; 
			this.marks = marks; 
		} 
	public void disp()
	{
		System.out.println(serialversionUID);
	}
} 

public class Serialize_4 { 
public static void print(Emp obj) 
	{ 
		System.out.print("UUID is ");
		obj.disp();
		System.out.println("name = " + obj.name); 
		System.out.println("age = " + obj.age); 
		System.out.println("marks = " + obj.marks); 
	} 

public static void main(String[] args) 
	{ 
		Emp obj = new Emp("syed", 20, 25); 
		String file = "syed.txt"; 

		try { 

			FileOutputStream f = new FileOutputStream (file); 
			ObjectOutputStream out = new ObjectOutputStream (f); 

			out.writeObject(obj); 

			out.close(); 
			f.close(); 

			System.out.println("Object serialized\n"
							+ "Data before Deserialization"); 
			print(obj); 

		} 

		catch (IOException ex) { 
			System.out.println("IOException"); 
		} 

		obj = null; 

		try { 

			FileInputStream f = new FileInputStream (file); 
			ObjectInputStream in = new ObjectInputStream (f); 

			obj = (Emp)in.readObject(); 

			in.close(); 
			f.close(); 
			System.out.println("Object deserialized\n"
								+ "Data after Deserialization is"); 
			print(obj); 
		} 

		catch (IOException ex) { 
			System.out.println("IOException is caught"); 
		} 

		catch (ClassNotFoundException ex) { 
			System.out.println("ClassNotFoundException" + 
								" is caught"); 
		} 
	} 
} 
