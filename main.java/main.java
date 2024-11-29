/**
 * Node in a binary tree.
 */
public class main {
    private int id;                // Unique ID
    private int data;              // Data stored 
    private main left;             // Left 
    private main right;            // Right 


    /**
     * Constructor to create a new node.
     *
     * id: Unique ID.
     * data: Data to store.
     */
    public main(int id, int data) {
        this.id = id;
        this.data = data;
        this.left = null;
        this.right = null;
    }

    /**
     * Inserts a new value ]]
     * If value is smaller than the current data, its inserted into the left child.
     * If bigger inserted into the right child.
     *
     * newData: The value to insert.
     */
    public void insert(int newData) {
        if (newData < this.data) {
            // Insert into the left 
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
                this.right = new main(this.id * 2 + 1, newData);
            } else {
                this.right.insert(newData);
            }
        }
    }

    /**
     * Dumps the current node and its children.
     * Args:
     *  level: The depth of the current node in the tree (used for indentation).
     * Returns:
     *  A string representation of the tree structure.
     */

    public String dump(int level) {
        StringBuilder sb = new StringBuilder();
        // Add tab indentation based on the level
        for (int i = 0; i < level; i++) {
            sb.append("\t");
        }
        // Appends info
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
}

