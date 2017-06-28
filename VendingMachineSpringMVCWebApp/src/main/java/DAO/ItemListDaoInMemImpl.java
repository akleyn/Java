package DAO;

import Model.Item;

import java.util.*;

public class ItemListDaoInMemImpl implements ItemListDao {
    private Map<Long, Item> itemMap = new HashMap<>();
    private static long itemIdCounter = 0;

    @Override
    public Item addItem(Item item) {
        itemIdCounter++;
        item.setId(itemIdCounter);
        itemMap.put(item.getId(), item);
        return item;
    }

    @Override
    public void removeItem(long itemId) {
        itemMap.remove(itemId);
    }

    @Override
    public void updateItem(Item item) {
        itemMap.put(item.getId(), item);
    }

    @Override
    public List<Item> getAllItems() {
        Collection<Item> c = itemMap.values();
        return new ArrayList(c);
    }

    @Override
    public Item getItemById(long itemId) {
        return itemMap.get(itemId);
    }
}
