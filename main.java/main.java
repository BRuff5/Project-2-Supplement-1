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
}
