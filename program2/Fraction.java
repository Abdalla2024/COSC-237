// Abdalla Abdelmagid

public class Fraction {

    private int numer;
    private int denom;
    
    // alternate constructor (for creating arbitrary fractions)
    // ---------------------------------------------
    // If denom is 0, then throws a ZeroDenominatorException.
    // Otherwise, initializes newly-created Fraction
    // to the numer and denom passed.
    // ---------------------------------------------
    public Fraction(int numer, int denom) throws DivideByZeroException {
        if (denom == 0) {
            throw new DivideByZeroException();
        } else {
            this.numer = numer;
            this.denom = denom;
        }
    } 

    // alternate constructor (for creating unit fractions)
    // ---------------------------------------------
    // If denom is 0, then throws a ZeroDenominatorException.
    // Otherwise, initializes newly-created Fraction
    // to unit fraction 1/denom.
    // ---------------------------------------------
    public Fraction(int denom) throws DivideByZeroException {
        if (denom == 0) {
            throw new DivideByZeroException();
        } else {
            numer = 1;
            this.denom = denom;
        }
    }

    // copy constructor (for creating a fraction with same value as another)
    // ---------------------------------------------
    // Initializes newly-created Fraction equal
    // to otherFrac passed.
    // ---------------------------------------------
    public Fraction(Fraction otherFrac) {
        if (otherFrac.denom == 0) {
            throw new DivideByZeroException();
        } else {
            this.numer = otherFrac.numer;
            this.denom = otherFrac.denom;
        }
    }

    // getters

    // ---------------------------------------------
    // Returns value of instance variable numer.
    // ---------------------------------------------
    public int getNumer() { 
        return numer;
    }

    // ---------------------------------------------
    // Returns value of instance variable denom.
    // ---------------------------------------------
    public int getDenom(){
        return denom;
    }

    // standard methods

    // ---------------------------------------------
    // Returns string of the form "<numer>/<denom>".
    // ---------------------------------------------
    public String toString() {
        return numer + "/" + denom;
    }

    
    // relational and Boolean operators

    // ---------------------------------------------
    // Returns true if Fraction object called on
    // is arithmetically equal to rFrac passed,
    // otherwise, returns false.
    // ---------------------------------------------
    public boolean equals(Fraction rFrac) {
        Fraction one = this.reduce();
        Fraction two = rFrac.reduce();

        return ((one.numer == two.numer) && (one.denom == two.denom));
    }

    // ---------------------------------------------
    // Returns true if the Fraction object called
    // on is less than the rFrac object passed,
    // otherwise returns false.
    // ---------------------------------------------
    public boolean lessThan(Fraction rFrac) {
        Fraction one = new Fraction(this.numer, this.denom);
        Fraction two = new Fraction(rFrac);

        return (one.convertToDecimal() < two.convertToDecimal());        
    }

    // ---------------------------------------------
    // Returns true if the Fraction object called
    // on is greater than the rFrac object passed,
    // otherwise returns false.
    // ---------------------------------------------
    public boolean greaterThan(Fraction rFrac) {
        Fraction one = new Fraction(this.numer, this.denom);
        Fraction two = new Fraction(rFrac);

        return (one.convertToDecimal() > two.convertToDecimal());
    }

    // ---------------------------------------------
    // Returns true if the value of the Fraction
    // object called on is in simplest form, otherwise
    // returns false.
    // ---------------------------------------------
    public boolean isReducedForm() {
        if (gcd(this.numer, this.denom) == 1) {
            return true;
        } else {
            return false;
        }
    }

    // ---------------------------------------------
    // Returns true if the Fraction object called
    // on is a unit fraction, otherwise, returns
    // false.
    // ---------------------------------------------
    public boolean isUnitFrac() {
        if (numer == 1 && denom > 0) {
            return true;
        } else 
            return false;
    }

    // ---------------------------------------------
    // Returns true if the numerator of the object
    // called on is less than its denominator.
    // ---------------------------------------------
    public boolean isProperFrac() {
        if (numer <  denom) {
            return true;
        } else 
            return false;
    } 
	
    // arithmetic operators

    // ---------------------------------------------
    // Returns a new Fraction which is the absolute
    // value of the object called on.
    // ---------------------------------------------
    public Fraction abs() {
        Fraction result = new Fraction(Math.abs(this.numer),
                                       Math.abs(this.denom)); 
        return result;       
   	}

    // ---------------------------------------------
    // Returns a new Fraction which is the sum of
    // the object called on and rFrac passed.
    // ---------------------------------------------
    public Fraction add(Fraction rFrac) {
        int d = denom * rFrac.denom;
        int n1 = numer * rFrac.denom;
        int n2 = rFrac.numer * denom;

        Fraction result = new Fraction((n1 + n2), d);
        return result.reduce();
    }

    // ---------------------------------------------
    // Returns a new Fraction which is the difference
    // of the value of the object called on and rFrac 
    // passed.
    // ---------------------------------------------
    public Fraction subtract(Fraction rFrac) {
        int d = denom * rFrac.denom;
        int n1 = numer * rFrac.denom;
        int n2 = rFrac.numer * denom;

        Fraction result = new Fraction((n1 - n2), d);
        if (n1 - n2 == 0) {
            return result;
        } else {
            return result.reduce();
        }

    }

    // ---------------------------------------------
    // Returns a new Fraction which is the result
    // of the multiplication of the object called
    // on and rFrac passed.
    // ---------------------------------------------
    public Fraction multiply(Fraction rFrac) {
        Fraction result = new Fraction(numer * rFrac.numer,
                                       denom * rFrac.denom);
        return result.reduce();
    }

    // ---------------------------------------------
    // Returns a new Fraction which is the result
    // of the division of the object called on
    // by rFrac passed.
    // ---------------------------------------------
    public Fraction divide(Fraction rFrac) {
        Fraction result = new Fraction(numer / rFrac.numer,
                                       denom / rFrac.denom);
        return result.reduce();
    }

    // conversion operators

    // ---------------------------------------------
    // Returns the decimal equivalent of the object
    // called on as type double.
    // ---------------------------------------------
    public double convertToDecimal(){
        double n = numer;
        double d = denom;
        return n/d;
    }

    // ---------------------------------------------
    // Returns a new Fraction that is equal to the
    // Fraction called on in simplest form.
    // ---------------------------------------------
    public Fraction reduce() {
      	if(isReducedForm())
	   // call to copy constructor returning a
           // copy of itself
           return new Fraction(this);
      	else
      {
           int GCD = gcd(numer, denom);
	   return new Fraction(numer/GCD, denom/GCD);
      }
    }

    // private methods

    private int gcd(int n1, int n2)
    // ---------------------------------------------
    // Euclidâ€™s Algorithm for finding the 
    // greatest common divisor of two integers.
    // ---------------------------------------------
    {
        int M, N, R;

        if (n1 < n2){
        	N = n1;
          	M = n2;
        }
        else{
          	N = n2;
         	M = n1;
        }

        R = M % N;
        while (R != 0){
        	M = N;
        	N = R;
         	R = M % N;
        }
        return N;
    }
}