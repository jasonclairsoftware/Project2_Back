package com.bitbyte.daos;


import com.bitbyte.entities.Item;

public interface ItemDAO {

			//create
			Item createItem(Item item);
			
			//read
			Item getItemById(int id); 
			Item getItemByName(String name); 
			
			//update
			Item updateItem(Item item); 
			
			//delete
//			 boolean deleteItem(Item item); 
//			



}
