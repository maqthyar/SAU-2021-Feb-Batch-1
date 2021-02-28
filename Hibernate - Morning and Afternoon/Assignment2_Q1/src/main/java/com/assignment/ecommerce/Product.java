package com.assignment.ecommerce;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Product")
public class Product
{
    @Id
    @Column(name="Product_Id")
    private int id;
    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "Category_ID")
    private Categories category;

    public Product(int id, String name)
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

    public Categories getCategory()
    {
        return category;
    }

    public void setCategory(Categories category)
    {
        this.category = category;
    }
}
