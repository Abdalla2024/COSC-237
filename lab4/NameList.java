// Abdalla Abdelmagid
public class NameList {
    private NameNode head;

    public NameList(){
      head = null;  
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void add(String name) {
        if(head == null)
          head = new NameNode(name, null);
        else {
          NameNode tempPtr = head;
          while(tempPtr.getNextNode() != null)
            tempPtr = tempPtr.getNextNode();  
    
          tempPtr.setNextNode(new NameNode(name, null));
        }
    }

    public void print(){
        if(isEmpty())
          System.out.println("ss");
        else {
          NameNode tempPtr = head;
          while(tempPtr != null){
            System.out.println(tempPtr.getName());
            tempPtr = tempPtr.getNextNode();
          }
        }
    }

}
