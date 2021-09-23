package org.generation.WebProject.controller;

import org.generation.WebProject.controller.dto.ItemDTO;
import org.generation.WebProject.repository.entity.Item;
import org.generation.WebProject.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/item")
public class ItemController {

    final ItemService itemService;


    //Autowired will implicitly inject the ItemService as a dependency to ItemController so that we can call the methods in the ItemService
    public ItemController( @Autowired ItemService itemService )
    {
        this.itemService = itemService;
    }

    //GetMapping is the route that corresponds to the HTTP GET method calls from the client
    //Cross-origin resource sharing (CORS)

    @CrossOrigin
    @GetMapping("/all")
    public Iterable<Item>getItems()
    {
        return itemService.all();
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public Item findItemById(@PathVariable Integer id )
    {
        return itemService.findById( id );
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public void delete( @PathVariable Integer id )
    {
        itemService.delete( id );
    }

    @CrossOrigin
    @PostMapping("/add")
    public Item save(  @RequestParam(name="title", required = true) String title,
                       @RequestParam(name="description", required = true) String description,
                       @RequestParam(name="target_date", required = true) String target_date ){


        ItemDTO itemDto = new ItemDTO(title, description, target_date);
        return itemService.save(new Item(itemDto));
    }

}
