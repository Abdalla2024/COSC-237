// Abdalla Abdelmagid

public class Accounts {
    
    private Account[] accts = new Account[100];
    private int current; // index of current account, only used by iterator methods

    public Accounts() {
        current = 0;
    }

    public void add(Account acct) {
        accts[current] = acct;
        current++; 
    }

    public Account getAccount(String creditCardNum) throws AccountNotFoundException{
        Account a = new Account(creditCardNum);
        for(int i = 0; i < accts.length; i++) {
            if(creditCardNum.equals(accts[i].getCreditCardNum())) {
                a = accts[i];
                break;
            } else if (accts[i + 1] == null) {
                throw new AccountNotFoundException();
            }
        }
        return a;
        
    }

    public void reset() {
        current = 0;
    }

    public boolean hasNext() {  
        return accts[current]!= null;
    }

    public Account getNext() {
        Account a;
        if (current == 0) {
            a = accts[0];
            current++;
            return a;
        } else {
            a = accts[current];
            current++;
            return a;
        }
    }
}
