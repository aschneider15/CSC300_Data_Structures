package pkg;

public class Node {
    
    public int data;
    public Node next;
    
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
    
    @Override
    public String toString() {
        String out = "";
        out += this.data;
        
        if(this.next == null) {
            out += " [this is the final node.]";
        }
        
        else {
            out += (" [the next node is at address " + this.next + ".]");
        }
        return out;
    }
}