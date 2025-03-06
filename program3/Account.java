// Abdalla Abdelmagid

public class Account {

    private String creditCardNum;
    private String companyName;
    private boolean primeCustomer;

    public Account (String ccn, String compName, boolean prime) {
        this.creditCardNum = ccn;
        this.companyName = compName;
        this.primeCustomer = prime;
    }

    public Account(String ccn) {

    }

    public String getCreditCardNum() {
        return creditCardNum;
    }

    public String getCompanyName() {
        return companyName;
    }

    public boolean primeCustomer() {
        return primeCustomer;
    }

    public String toString() {
        return "Name: " + companyName + "\nCredit card num: " +
         creditCardNum + "\nPrime customer: " + primeCustomer;
    }

}
