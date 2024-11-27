# Advanced Inventory Management System

## Overview
The **Advanced Inventory Management System** is a Java-based application designed for efficient and scalable management of warehouse inventory. This system leverages advanced Java Collections to perform key inventory operations, including adding, updating, deleting, and querying items. It is optimized for performance, handling up to 100,000 items efficiently.

## Features
1. **Inventory Tracking**
   - Each item has a **unique ID**, **name**, **category**, and **quantity**.
   - Supports:
     - Adding new items.
     - Searching items by their unique ID.
     - Updating item details.
     - Deleting items.

2. **Category-wise Sorting and Retrieval**
   - Items are sorted in **descending order of quantity** within each category.
   - Efficient retrieval of all items belonging to a specific category.

3. **Restocking Notification**
   - Generates a **console notification** if an item's quantity falls below a defined threshold.

4. **Bulk Operations**
   - Allows merging of two inventories while ensuring:
     - **No duplicate item IDs**.
     - Retention of items with the **higher quantity** in case of duplicates.

5. **Complex Query Support**
   - Provides a feature to retrieve the **top K items** with the highest quantity across all categories.

## Constraints
- The system is designed to handle at least **100,000 items** efficiently.
- Optimized use of Java's **Collection Framework** (e.g., `Map`, `Set`, `Queue`, etc.).

## Deliverables
1. A well-documented Java class implementing the inventory system.
2. A test suite to validate functionality and handle edge cases.

## How to Run
1. Clone the repository or copy the source code into your Java development environment.
2. Compile the code using any Java IDE or `javac` command:
   ```bash
   javac Main.java
