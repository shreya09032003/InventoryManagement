

import java.util.*;

public class Inventory {
    private final Map<String, Item> items = new HashMap<>();
    private final Map<String, TreeSet<Item>> categoryMap = new HashMap<>();
    private final int restockThreshold;

    public Inventory(int restockThreshold) {
        this.restockThreshold = restockThreshold;
    }

    // Add or update an item
    public void addOrUpdateItem(String id, String name, String category, long quantity) {
        Item newItem = new Item(id, name, category, quantity);

        // Update existing item if it already exists
        if (items.containsKey(id)) {
            Item existingItem = items.get(id);
            categoryMap.get(existingItem.getCategory()).remove(existingItem);
        }

        // Add to main inventory
        items.put(id, newItem);

        // Add to category map
        categoryMap.putIfAbsent(category, new TreeSet<>());
        categoryMap.get(category).add(newItem);

        // Restock check
        if (quantity < restockThreshold) {
            System.out.println("Restock Notification: " + name + " (ID: " + id + ") needs restocking!");
        }
    }

    // Search item by ID
    public Item searchItemById(String id) {
        return items.getOrDefault(id, null);
    }

    // Delete an item by ID
    public void deleteItem(String id) {
        if (!items.containsKey(id)) {
            System.out.println("Item not found!");
            return;
        }

        Item item = items.remove(id);
        categoryMap.get(item.getCategory()).remove(item);

        // Remove empty category
        if (categoryMap.get(item.getCategory()).isEmpty()) {
            categoryMap.remove(item.getCategory());
        }
    }

    // Get all items in a category
    public List<Item> getCategoryItems(String category) {
        if (!categoryMap.containsKey(category)) return Collections.emptyList();
        return new ArrayList<>(categoryMap.get(category));
    }

    // Get top K items by quantity
    public List<Item> getTopKItems(int k) {
        PriorityQueue<Item> maxHeap = new PriorityQueue<>(items.values());
        List<Item> topKItems = new ArrayList<>();

        for (int i = 0; i < k && !maxHeap.isEmpty(); i++) {
            topKItems.add(maxHeap.poll());
        }
        return topKItems;
    }

    // Merge another inventory
    public void mergeInventory(Inventory other) {
        for (Item otherItem : other.items.values()) {
            if (items.containsKey(otherItem.getId())) {
                Item existingItem = items.get(otherItem.getId());
                if (otherItem.getQuantity() > existingItem.getQuantity()) {
                    addOrUpdateItem(otherItem.getId(), otherItem.getName(), otherItem.getCategory(), otherItem.getQuantity());
                }
            } else {
                addOrUpdateItem(otherItem.getId(), otherItem.getName(), otherItem.getCategory(), otherItem.getQuantity());
            }
        }
    }
}
