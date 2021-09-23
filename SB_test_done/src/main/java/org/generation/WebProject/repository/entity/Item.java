package org.generation.WebProject.repository.entity;

//Repository is the model layer
//JPA (Java Persistence API) map Java Objects (Class) to the database tables
//This concept is known as ORM (Object Relational Mapping)
//Item is an entity that will be used to map with the Item table in the database
//E.g. if you have a Category table, then you will need to create another entity (Category) Class

import org.generation.WebProject.controller.dto.ItemDTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Item {

    //Table Columns are the attributes of the class
    //database is responsible for auto generation of primary key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String description;
    private String target_date;

    public Item() {}

    public Item( ItemDTO itemDto )
    {
        this.title = itemDto.getTitle();
        this.description = itemDto.getDescription();
        this.target_date = itemDto.getTarget_date();
    }

    public Integer getId() { return id; }

    public void setId( Integer id ) { this.id = id; }

    public String getTitle() { return title; }

    public void setTitle ( String title ) { this.title = title; }

    public String getDescription() { return description; }

    public void setDescription( String description ) { this.description = description; }

    public String getTarget_date()
    {
        return target_date;
    }

    public void setTarget_date( String target_date) { this.target_date = target_date; }


    @Override
    public String toString()
    {
        return "Item{" + "id=" + id + ", title='" + title + '\'' + ", description='" + description + '\'' + ", target_date='" + target_date + '}';
    }



}
