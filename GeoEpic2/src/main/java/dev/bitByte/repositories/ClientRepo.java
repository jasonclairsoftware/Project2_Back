package dev.bitByte.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.bitByte.entities.Client;


@Repository
public interface ClientRepo extends CrudRepository<Client,Integer>{

	Client findByUsername(String username);
}
