package Util;

import DAO.ItemListDao;
import Model.Item;

public class Utils {

    private static boolean initialized = false;

    public static void deploy(ItemListDao dao) {
        if (!initialized) {
            dao.addItem(new Item("Snickers", 1.85f, 9));
            dao.addItem(new Item("M & Ms", 1.50f, 2));
            dao.addItem(new Item("Pringles", 2.10f, 5));
            dao.addItem(new Item("Reese's", 1.85f, 4));
            dao.addItem(new Item("Pretzels", 1.25f, 9));
            dao.addItem(new Item("Twinkies", 1.95f, 3));
            dao.addItem(new Item("Doritos", 1.75f, 11));
            dao.addItem(new Item("Almond Joy", 1.85f, 0));
            dao.addItem(new Item("Trident", 1.95f, 6));
            initialized = true;
        }
    }
}
