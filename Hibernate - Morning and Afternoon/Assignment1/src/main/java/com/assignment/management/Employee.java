package com.assignment.management;

import javax.persistence.*;

@Entity
@Table(name = "Employee")
public class Employee
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String fname;
    private String lname;
    private int age;
    private int salary;
    private String dob;
    private String designation;




    public String getFname()
    {
        return fname;
    }

    public void setFname(String fname)
    {
        this.fname = fname;
    }

    public String getLname()
    {
        return lname;
    }

    public void setLname(String lname)
    {
        this.lname = lname;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public int getSalary()
    {
        return salary;
    }

    public void setSalary(int salary)
    {
        this.salary = salary;
    }

    public String getDob()
    {
        return dob;
    }

    public void setDob(String dob)
    {
        this.dob = dob;
    }

    public String getDesignation()
    {
        return designation;
    }

    @Override
    public String toString()
    {
        return "Employee{" +
                "id=" + id +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", dob='" + dob + '\'' +
                ", designation='" + designation + '\'' +
                '}';
    }

    public void setDesignation(String designation)
    {
        this.designation = designation;
    }
}
