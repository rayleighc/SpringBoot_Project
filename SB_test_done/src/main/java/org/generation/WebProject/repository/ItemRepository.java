package org.generation.WebProject.repository;

import org.generation.WebProject.repository.entity.Item;
import org.springframework.data.repository.CrudRepository;

// CRUD refers Create, Read, Update, Delete
public interface ItemRepository extends CrudRepository<Item, Integer >
{

}

//ItemRepository extends the CrudRepository Class and it is able to access the methods that is available in the CrudRepository Class
