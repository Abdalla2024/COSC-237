// Abdalla Abdelmagid
public class NameNode {
    private String lastName;
    private NameNode next;

    public NameNode(String lastName, NameNode next) {
        this.lastName = lastName;
        this.next = next;
    }

    public String getName() {
        return lastName;
    }

    public NameNode getNextNode() {
        return next;
    }

    public void setNextNode(NameNode next) {
        this.next = next;
    }
}
