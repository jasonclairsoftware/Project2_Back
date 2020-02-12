package dev.bitByte.repositories;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.bitByte.entities.Location;


@Repository
public interface LocationRepo extends CrudRepository<Location,Integer>{

}
