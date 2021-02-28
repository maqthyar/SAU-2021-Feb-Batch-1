package com.assignment.management;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

public class Menu
{
    static Scanner sc = new Scanner(System.in);

    public static void displaymenu()
    {
        System.out.println("Enter Your choice\n");
        System.out.println("1. Create Employee\n");
        System.out.println("2. Update  Employee\n");
        System.out.println("3. Delete Employee\n");
        System.out.println("4. Get all Employees\n");
        System.out.println("5. Get Employee by ID\n");
        System.out.println("6. Exit\n");
        System.out.println("Enter your choice\n");
    }

    public static Employee addEmployee()
    {
        Employee emp =new Employee();

        System.out.println("Enter First Name");
        emp.setFname(sc.next());

        System.out.println("Enter Last Name");
        emp.setLname(sc.next());

        System.out.println("Enter Age");
        int age = sc.nextInt();

        do
        {
            emp.setAge(age);
            if(age < 10)
            {
                System.out.println("Enter 2 digits");
                age = sc.nextInt();
            }
        }while (age < 10);

        System.out.println("Enter Salary");
        emp.setSalary(sc.nextInt());

        System.out.println("Enter DOB (dd-mm-yyyy)");
        emp.setDob(sc.next());

        System.out.println("Enter Designation");
        emp.setDesignation(sc.next());

        return emp;
    }

    public static void main(String[] args)
    {
        int opt = -1;
        do
        {
            Configuration configuration = new Configuration().configure().addAnnotatedClass(Employee.class);
            SessionFactory factory = configuration.buildSessionFactory();
            Session session = factory.openSession();
            Transaction tx = session.beginTransaction();


            displaymenu();
            opt = sc.nextInt();

            switch (opt)
            {
                case 1:
                    Employee newEmp = addEmployee();
                    session.save(newEmp);
                    tx.commit();
                    System.out.println("New Employee added\n");
                    break;

                case 2:
                    System.out.println("\n");
                    try
                    {
                        System.out.println("Enter Employee ID to Update ");
                        int id = sc.nextInt();

                        System.out.println("Enter the field to update \n1.Firstname\n2.Lastname\n3.Age\n" +
                                "4.Salary\n5.DOB\n6.Designation\n");
                        int choice = sc.nextInt();

                        Employee updEmp = (Employee) session.get(Employee.class, id);
                        switch(choice)
                        {
                            case 1:
                                System.out.println("Enter New Firstname\n");
                                String fname = sc.next();
                                updEmp.setFname(fname);
                                System.out.println("Firstname Updated");
                                tx.commit();
                                break;

                            case 2:
                                System.out.println("Enter New Lastname\n");
                                String lname = sc.next();
                                updEmp.setLname(lname);
                                System.out.println("Lastname Updated");
                                tx.commit();
                                break;

                            case 3:
                                System.out.println("Enter New Age\n");
                                int newAge = sc.nextInt();
                                updEmp.setAge(newAge);
                                System.out.println("Age Updated");
                                tx.commit();
                                break;

                            case 4:
                                System.out.println("Enter New Salary\n");
                                int newSal = sc.nextInt();
                                updEmp.setSalary(newSal);
                                System.out.println("Salary Updated");
                                tx.commit();
                                break;

                            case 5:
                                System.out.println("Enter New DOB\n");
                                String newdob = sc.next();
                                updEmp.setDob(newdob);
                                System.out.println("DOB Updated");
                                tx.commit();
                                break;

                            case 6:
                                System.out.println("Enter New Designation\n");
                                String newDsg = sc.next();
                                updEmp.setDesignation(newDsg);
                                System.out.println("Designation Updated");
                                tx.commit();
                                break;

                            default:
                                System.out.println("Invalid Choice");
                                break;
                        }
                    }
                    catch(Exception e)
                    {
                        System.out.println("ID not found");
                    }
                    break;

                case 3:
                    System.out.println("\n");
                    try
                    {
                        System.out.println("Enter ID of Employee to delete");
                        int id = sc.nextInt();
                        System.out.println("Warning: this can't be recovered \n Press Y/y to confirm... ");
                        char c = sc.next().charAt(0);
                        if(c=='Y' || c == 'y')
                        {
                            Employee delEmp = (Employee) session.load(Employee.class, id);
                            session.delete(delEmp);
                            System.out.println("Employee deleted");
                            tx.commit();

                        }
                        else if(c=='N')
                        {
                            System.out.println("No employee deleted");
                            break;
                        }
                    }
                    catch(Exception e)
                    {
                        System.out.println("No such employee");
                    }
                    break;

                case 4:
                    System.out.println("\n");
                    Query query = session.createQuery("from Employee");
                    List<Employee> emp =  query.list();
                    System.out.println("Employee details");
                    for(Employee e : emp) {
                        System.out.println(e.toString());
                    }
                    tx.commit();
                    break;
                case 5:
                    System.out.println("\n");
                    System.out.println("Enter employee ID");
                    int id = sc.nextInt();
                    System.out.println("Employee Detail");
                    Employee em = (Employee) session.get(Employee.class, id);
                    if(em != null)
                        System.out.println(em.toString());
                    else
                        System.out.println("No employee found\n");
                    tx.commit();
                    break;

                case 6:
                    System.out.println("Exiting");
                	session.close();
                	factory.close();
                    break;

                default:
                    System.out.println("Invalid OPtion");
                    continue;

            }


        }while (opt != 6);

        sc.close();
    }
}
