// Abdalla Abelmagid

public class Transactions {
    
    private Transaction[] trans = new Transaction[500];
    private int current;

    public Transactions() {
        current = 0;
    }

    public void add(Transaction tran) {
        trans[current] = tran;
        current++; 
    }

    public void reset() {
        current = 0;
    }

    public boolean hasNext() {  
        return trans[current]!= null;
    }

    public Transaction getNext() {
        Transaction t;
        if (current == 0) {
            t = trans[0];
            current++;
            return t;
        } else {
            t = trans[current];
            current++;
            return t;
        }
    }
}
