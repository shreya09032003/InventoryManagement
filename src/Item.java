public class Item implements Comparable<Item> {
    private final String id;
    private String name;
    private String category;
    private long quantity;

    public Item(String id, String name, String category, long quantity) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    @Override
    public int compareTo(Item other) {
        return Long.compare(other.quantity, this.quantity);
    }

    @Override
    public String toString() {
        return String.format("ID: %s | Name: %s | Category: %s | Quantity: %d", id, name, category, quantity);
    }
}
