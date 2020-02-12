package dev.bitByte.repositories;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import dev.bitByte.entities.Item;

@Repository
public interface ItemRepo extends CrudRepository<Item,Integer>{

	List<Item> findByName(String name);

}
