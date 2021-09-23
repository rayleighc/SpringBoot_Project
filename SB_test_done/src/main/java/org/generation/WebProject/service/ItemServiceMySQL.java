package org.generation.WebProject.service;

import org.generation.WebProject.repository.ItemRepository;
import org.generation.WebProject.repository.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ItemServiceMySQL implements ItemService {

    private final ItemRepository itemRepository;

    public ItemServiceMySQL( @Autowired ItemRepository itemRepository )
    {
        this.itemRepository = itemRepository;
    }

    //this save method is in the service layer, and will be called by the controller
    @Override
    public Item save( Item item )
    {
        //Save an item into the database
        //Perform the action CRUD - Create (new item), update (existing item)
        return itemRepository.save( item );
    }

    @Override
    public void delete( int itemId )
    {
        //Delete an item from the database
        //Perform CRUD - Delete
        itemRepository.deleteById( itemId );
    }

    @Override
    public List<Item> all()
    {
        //List all the items from the database
        //Perform CRUD - Read
        List<Item> result = new ArrayList<>();
        itemRepository.findAll().forEach( result::add );
        return result;   //in a form of List (ArrayList)
    }

    @Override
    public Item findById( int itemId )
    {
        //TODO implement this method
        Optional<Item> item = itemRepository.findById( itemId );
        Item itemResponse = item.get();
        return itemResponse;
    }

}
