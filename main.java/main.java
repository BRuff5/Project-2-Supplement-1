/**
 * Represents a node in a binary tree.
 */
public class main {
    private int id;                // Unique ID for the node
    private int data;              // Data stored in the node
    private main left;             // Left child
    private main right;            // Right child

    /**
     * Constructor to create a new node.
     *
     * @param id   Unique ID for the node.
     * @param data Data to store in the node.
     */
    public main(int id, int data) {
        this.id = id;
        this.data = data;
        this.left = null;
        this.right = null;
    }

    /**
     * Inserts a new value into the binary tree.
     * If the value is smaller than the current node's data, it is inserted into the left child.
     * Otherwise, it is inserted into the right child.
     *
     * @param newData The value to insert.
     */
    public void insert(int newData) {
        if (newData < this.data) {
            // Insert into the left child
            if (this.left == null) {
                // Create a new node if left child does not exist
                this.left = new main(this.id * 2, newData); // Example for unique ID generation
            } else {
                this.left.insert(newData);
            }
        } else {
            // Insert into the right child
            if (this.right == null) {
                // Create a new node if right child does not exist
                this.right = new main(this.id * 2 + 1, newData); // Example for unique ID generation
            } else {
                this.right.insert(newData);
            }
        }
    }

    /**
     * Dumps the current node and its children to a string in a tree-like structure.
     *
     * @param level The depth of the current node in the tree (used for indentation).
     * @return A string representation of the tree structure.
     */
    public String dump(int level) {
        StringBuilder sb = new StringBuilder();
        // Add tab indentation based on the level
        for (int i = 0; i < level; i++) {
            sb.append("\t");
        }
        // Append the current node's info
        sb.append("Node ID: ").append(this.id).append(", Data: ").append(this.data).append("\n");

        // Print left and right children
        if (this.left != null) {
            sb.append(this.left.dump(level + 1));
        }
        if (this.right != null) {
            sb.append(this.right.dump(level + 1));
        }

        return sb.toString();
    }

    /**
     * The main method to test the Node class.
     * Accepts command-line arguments to build a binary tree and prints its structure.
     *
     * @param args A sequence of integers to insert into the binary tree.
     *             Each integer is converted to a node and added to the tree.
     *
     * Example:
     * <pre>
     * $ java Node 10 5 15 3 7
     * Inserted: 10
     * Inserted: 5
     * Inserted: 15
     * Inserted: 3
     * Inserted: 7
     *
     * Binary Tree Structure:
     * Node ID: 1, Data: 10
     *     Node ID: 2, Data: 5
     *         Node ID: 4, Data: 3
     *         Node ID: 5, Data: 7
     *     Node ID: 3, Data: 15
     * </pre>
     */
    public static void main(String[] args) {
        // Check if arguments are provided
        if (args.length == 0) {
            System.out.println("Please provide a sequence of integers to insert into the tree.");
            return;
        }

        main root = new main(1, Integer.parseInt(args[0])); // Create the root node with the first argument
        System.out.println("Inserted: " + args[0]);

        // Insert values from command-line arguments into the tree
        for (int i = 1; i < args.length; i++) {
            int valueToInsert = Integer.parseInt(args[i]);
            root.insert(valueToInsert);
            System.out.println("Inserted: " + valueToInsert);
        }

        // Dump the tree structure
        System.out.println("\nBinary Tree Structure:\n" + root.dump(0)); // Level 0 (root level)
    }
}
