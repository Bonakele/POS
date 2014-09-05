package com.pos.dao.inter;

import java.util.List;

import com.pos.model.Item;


public interface ItemInterface {
	public int saveItem(Item item);
	public Item getItemById(int id);
	public List<Item> getAllItems();
	public List<Item> getItemByTypeSizeColour(String type, String colour, String size);

}
