package DAO;

import Model.Item;

import java.util.List;

public interface ItemListDao {
    Item addItem(Item item);

    void removeItem(long itemId);

    void updateItem(Item item);

    List<Item> getAllItems();

    Item getItemById(long itemId);
}
