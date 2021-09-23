package org.generation.WebProject.controller.dto;

public class ItemDTO {

    private String title;
    private String description;
    private String target_date;

    public ItemDTO( String title, String description, String target_date )
    {
        this.title = title;
        this.description = description;
        this.target_date = target_date;

    }

    public String getTitle() { return title; }

    public void setTitle( String title ) { this.title = title; }

    public String getDescription() { return description; }

    public void setDescription( String description ) { this.description = description; }

    public String getTarget_date() { return target_date; }

    public void setTarget_date( String target_date ) { this.target_date = target_date; }



}
