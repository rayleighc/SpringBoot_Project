package org.generation.WebProject.service;

import org.generation.WebProject.repository.entity.Item;
import java.util.List;

public interface ItemService {

    //Create methods/actions that you want to do with the item
    //Controller layer will call the respective methods to perform the necessary tasks requested by the client
    Item save ( Item item );

    void delete ( int itemId );

    List<Item> all();

    Item findById( int itemId );

}
