/**
 * 
 */

/**
 * @author beethovenzhang
 *
 */
public class Fraction {
	private int num;
	private int den;
	
	public Fraction(int n, int d) {
		if (d==0) {
			throw new IllegalArgumentException("Denomenator can't be zero.");
		} else if (d<0) {
			n=-n;
			d=-d;
		} 				
		this.num=n;
		this.den=d;			
	}
	
	public Fraction(int n) {
		this(n,1);
	}
	
	public Fraction() {
		this(0,1);
	}
	
	public int getNumerator() { return num;}
	
	public int getDenomenator() { return den;}
	
	public String toString() {
		this.toLowestTerms();
		if(num%den==0) {
			return String.valueOf(num/den);
		}
		return num+"/"+den;
	}
	
	public double toDouble() { return (double) num/den;}
	
	public Fraction add(Fraction other) {
		return new Fraction(this.num*other.den+other.num*this.den,this.den*other.den);
		
	}
	
	public Fraction subtract(Fraction other) {
		return new Fraction(this.num*other.den-other.num*this.num,this.den*other.den);
		
	}
	
	public Fraction multiply(Fraction other) {
		return new Fraction(this.num*other.num,this.den*other.den);
		
	}
	
	public Fraction divide(Fraction other) {
		if(other.num==0) {
			throw new IllegalArgumentException("Can't divide by zero.");
		}
		return new Fraction(this.num*other.den,this.den*other.num);
	}
	
	public boolean equals(Object o) {//how to override equals method
		if (!(o instanceof Fraction)){//check if o is an instane of fraction
			return false;			
		}
		Fraction f=(Fraction) o;//type cast
		return this.num*f.den==this.den*f.num;
		
	}
	
	public int gcd(int a,int b) {
		while (a*b!=0) {
			int c=a%b;
			a=b;
			b=c;
		}
		return a;
	}
	
	public void toLowestTerms() {
		int c=gcd(this.num,this.den);
		this.num=this.num/c;
		this.den=this.den/c;
	
	}
	
	
	
}
