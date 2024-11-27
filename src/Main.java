import java.util.List;

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory(10);

        System.out.println("### Adding Items ###");
        inventory.addOrUpdateItem("101", "Laptop", "Electronics", 50);
        inventory.addOrUpdateItem("102", "Table", "Furniture", 20);
        inventory.addOrUpdateItem("103", "Apple", "Groceries", 5); 
        inventory.addOrUpdateItem("104", "Monitor", "Electronics", 30);
        inventory.addOrUpdateItem("105", "Chair", "Furniture", 15);
        inventory.addOrUpdateItem("106", "Banana", "Groceries", 8); 
        inventory.addOrUpdateItem("107", "Smartphone", "Electronics", 40);
        inventory.addOrUpdateItem("108", "Desk Lamp", "Furniture", 12);
        inventory.addOrUpdateItem("109", "Rice", "Groceries", 25);

        System.out.println("\n### Searching Items ###");
        System.out.println("Search for item ID 102: " + inventory.searchItemById("102"));
        System.out.println("Search for non-existent item ID 110: " + inventory.searchItemById("110"));

        System.out.println("\n### Updating Items ###");
        inventory.addOrUpdateItem("103", "Apple", "Groceries", 15); 
        System.out.println("Updated item ID 103: " + inventory.searchItemById("103"));

        System.out.println("\n### Deleting Items ###");
        inventory.deleteItem("102"); 
        System.out.println("Furniture items after deleting Table: " + inventory.getCategoryItems("Furniture"));

        System.out.println("\n### Retrieving Category Items ###");
        System.out.println("Electronics: " + inventory.getCategoryItems("Electronics"));
        System.out.println("Furniture: " + inventory.getCategoryItems("Furniture"));
        System.out.println("Groceries: " + inventory.getCategoryItems("Groceries"));

        System.out.println("\n### Top K Items ###");
        List<Item> top3 = inventory.getTopKItems(3);
        System.out.println("Top 3 items by quantity: " + top3);

        System.out.println("\n### Restock Notifications ###");
        inventory.addOrUpdateItem("110", "Milk", "Groceries", 2); 
        inventory.addOrUpdateItem("111", "Fan", "Electronics", 1); 

        System.out.println("\n### Adding Items to Trigger Restock Notification ###");
        inventory.addOrUpdateItem("112", "Notebook", "Stationery", 3); 

        System.out.println("\n### Merge Inventories ###");
        Inventory otherInventory = new Inventory(10);
        otherInventory.addOrUpdateItem("101", "Laptop", "Electronics", 60); 
        otherInventory.addOrUpdateItem("113", "Pen", "Stationery", 50);
        otherInventory.addOrUpdateItem("105", "Chair", "Furniture", 25); 
        otherInventory.addOrUpdateItem("109", "Rice", "Groceries", 30); 
        otherInventory.addOrUpdateItem("114", "Chocolates", "Groceries", 100);

        inventory.mergeInventory(otherInventory);

        System.out.println("After merging inventories:");
        System.out.println("Electronics: " + inventory.getCategoryItems("Electronics"));
        System.out.println("Furniture: " + inventory.getCategoryItems("Furniture"));
        System.out.println("Groceries: " + inventory.getCategoryItems("Groceries"));
        System.out.println("Stationery: " + inventory.getCategoryItems("Stationery"));

        System.out.println("\n### Edge Cases ###");
        inventory.addOrUpdateItem("115", "ZeroQuantityItem", "Miscellaneous", 0);
        System.out.println("Miscellaneous items: " + inventory.getCategoryItems("Miscellaneous"));

        System.out.println("\nAttempting to delete non-existent item ID 200:");
        inventory.deleteItem("200");

        System.out.println("\n### Final State of Inventory ###");
        System.out.println("Electronics: " + inventory.getCategoryItems("Electronics"));
        System.out.println("Furniture: " + inventory.getCategoryItems("Furniture"));
        System.out.println("Groceries: " + inventory.getCategoryItems("Groceries"));
        System.out.println("Stationery: " + inventory.getCategoryItems("Stationery"));
        System.out.println("Miscellaneous: " + inventory.getCategoryItems("Miscellaneous"));
    }
}
