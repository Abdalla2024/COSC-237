// Abdalla Abdelmagid


public class SortedNameList {
    private NameNode head;
    private NameNode current;
  
    public SortedNameList(){
      head = null;
      current = null;
    }
  
    public boolean isEmpty() {
        return head == null;
    }

    public boolean contains(String name) {
          return current.getName().compareTo(name) == 0;
    }

    public void add(String name){
        if(head == null)
          head = new NameNode(name, null);
        else
          if(afterLastName(name))
            append(name);
          else
            insert(name);
    }

    public void delete(String name) {
        if(current.getName() == name) {
            current = null;
        } else {
            System.out.println("Name not in list");
        }
    }
  
    private boolean afterLastName(String new_name){
      return getLastNameInList().compareToIgnoreCase(new_name) > 0;
    }
  
    private String getLastNameInList(){
        NameNode ptr = head;
  
        while(ptr.getNextNode() != null){
          ptr = ptr.getNextNode();
  
        return ptr.getName();
        }
        return ptr.getName();
    }
  
    public void append(String name)
    {
        NameNode temp = name;
        
        if (name == null)
            name = new NameNode(name, null);
        else
        {
            while (temp.getNextNode() != null)
                temp = temp.getNextNode();
        
            temp.setNextNode(new NameNode(name, null));
        }
    }
  
    public void insert(String name)
    {
        if (name == null)
            name = new NameNode(name, null);
        else
        {
            NameNode temp = name;
            while (temp.getNextNode() != current)
                temp = temp.getNextNode();
        
            temp.setNextNode(new NameNode(name, current));
        }
    }
  
    // iterator methods
    public void reset() {
      current = head;
    }
  
    public boolean hasNext() {
       return current.getNextNode() != null;
    }
  
    public String getNext() {
       String saved_name = current.getName();
       current = current.getNextNode();
       
       return saved_name;
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