import java.util.Scanner;

/**
 * 
 */

/**
 * @author beethovenzhang
 *
 */
public class FractionCalculator {
	public static void main(String[] args) {
		intro();
		while(true) {
			String op=getOperation();
			if(op.equalsIgnoreCase("Q")) {
				return;
			} else {
				Fraction a=getFraction();
				Fraction b=getFraction();
				if(op.equals("+")) {
					Fraction c=a.add(b);
					//c.toLowestTerms();
					System.out.println(a.toString()+"+"+b.toString()+"="+c.toString());
				}
				if(op.equals("-")) {
					Fraction c=a.subtract(b);
					//c.toLowestTerms();
					System.out.println(a.toString()+"-"+b.toString()+"="+c.toString());
				}
				if(op.equals("*")) {
					Fraction c=a.multiply(b);
					//c.toLowestTerms();
					System.out.println(a.toString()+"*"+b.toString()+"="+c.toString());
				}
				if(op.equals("/")) {
					Fraction c=a.divide(b);
					//c.toLowestTerms();
					System.out.println(a.toString()+"/"+b.toString()+"="+c.toString());
				}
			}
		}
		
		
		
	}
	
	public static String getOperation() {
		System.out.println("Please enter an operation(+,-,*,/ or Q to quit):");
		Scanner input=new Scanner(System.in);
		String operation=input.nextLine();
		while(!(operation.equals("+")||operation.equals("-")||operation.equals("*")||operation.equals("/")||operation.equalsIgnoreCase("Q"))){
			System.out.println("Invalid input. Please enter an operation(+,-,*,/ or Q to quit):");
			operation=input.nextLine();
		}
		return operation;
		
	}
	
	public static boolean validFraction(String f) {
		if(f.charAt(0)=='-') {
			f=f.substring(1,f.length());
		}
		if(!f.contains("/")) {
			return isNumber(f);
		} else {
			String num=f.substring(0, f.indexOf('/'));
			//System.out.println(num);
			String den=f.substring(f.indexOf('/')+1 );
			//System.out.println(den);
			int intden=Integer.parseInt(den);
			if(intden==0) {
				return false;
			}
			return isNumber(den)&&isNumber(num);
			
		}
		
	}
	//a helper function to check is a string is non-empty and every char is between '0'-'9'
	public static boolean isNumber(String a) {
		if(a.length()==0) {
			return false;
		}
		for(int i=0;i<a.length();i++) {
			if(a.charAt(i)<'0'||a.charAt(i)>'9') {
				return false;
			}
		}
		
		return true;
	}
	
	public static Fraction getFraction() {
		System.out.println("Please enter a fraction(a/b) or an integer(a):");
		Scanner input=new Scanner(System.in);
		String fraction=input.nextLine();
		while(!validFraction(fraction)) {
			System.out.println("Invalid input. Please enter a fraction(a/b) or an integer(a):");
			fraction=input.nextLine();
		}
		int negative=1;
		if(fraction.charAt(0)=='-') {
			negative*=-1;
			fraction=fraction.substring(1,fraction.length());
		}
		if(!fraction.contains("/")) {
			int a=Integer.parseInt(fraction);
		
			return new Fraction(a);
		} else {
			String snum=fraction.substring(0, fraction.indexOf('/'));
			String sden=fraction.substring(fraction.indexOf('/')+1 );
			int intden=Integer.parseInt(sden);
			int intnum=Integer.parseInt(snum);
			return new Fraction(negative*intnum,intden);
		}
	}
	
	public static void intro() {
		System.out.println("This program is a fraction calculator.");
		System.out.println("----------------------------------------");
		System.out.println();
	}
	

}
