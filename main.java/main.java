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
     * @param id   Unique ID.
     * @param data Data to store.
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
     * @param newData The value to insert.
     */

    public void insert(int newData) {
        if (newData < this.data) {
            // Insert into the left 
            if (this.left == null) {
                // Create a new node if left child does not exist
                this.left = new main(this.id * 2, newData); 
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
}
