package pkg;

public class Node {
    
    public int payload;
    public Node nextPointer;
    
    public Node(int payload) {
        this.payload = payload;
        this.nextPointer = null;
    }
    
    @Override
    public String toString() {
        String out = "";
        out += this.payload;
        
        if(this.nextPointer == null) {
            out += " [this is the final node.]";
        }
        
        else {
            out += (" [the next node is at address " + this.nextPointer + ".]");
        }
        return out;
    }
}