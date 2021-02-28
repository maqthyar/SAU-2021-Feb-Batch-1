package com.assignment.ecommerce;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Categories")
public class Categories
{
    @Id
    @Column(name="Category_Id")
    private int id;

    public Categories(int id, String name)
    {
        this.id = id;
        this.name = name;
    }

    private String name;

    @ManyToMany(targetEntity = Supplier.class, cascade = CascadeType.ALL)
    @JoinTable(name = "Categories_Supplier",
            joinColumns = @JoinColumn(referencedColumnName = "Category_id"),
            inverseJoinColumns = @JoinColumn(referencedColumnName = "Supplier_Id"))
    private Set<Supplier> supplier;

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

    public Set<Supplier> getSupplier()
    {
        return supplier;
    }

    public void setSupplier(Set<Supplier> supplier)
    {
        this.supplier = supplier;
    }
}
