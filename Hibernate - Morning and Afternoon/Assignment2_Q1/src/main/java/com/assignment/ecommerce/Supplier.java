package com.assignment.ecommerce;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Supplier")
public class Supplier
{
    @Id
    @Column(name="Supplier_Id")

    private int id;
    private String name;


    @ManyToMany(targetEntity = Categories.class)
    @JoinColumn(referencedColumnName = "Supplier_id")
    private Set<Categories> categories;

    public Set<Categories> getCategories()
    {
        return categories;
    }

    public void setCategories(Set<Categories> categories)
    {
        this.categories = categories;
    }

    public Supplier(int id, String name)
    {
        this.id = id;
        this.name = name;
    }


    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
