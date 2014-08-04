package com.pos.dao.inter;

import java.util.List;

import com.pos.model.Item;


public interface ItemInterface {
	void save(Item item);
	public int saveItem(Item item);
	public Item getItemById(int id);
	void edit(int x);
	void delete(int x);
	List<Item> view();
	Item getItem(int x);
}
