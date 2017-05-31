/*
 * File: TestBankCD.java
 * Author: Java, Java, Java
 * Description: Solution to Self-study exercise 5-21.
 * 
 * Problem: Design and implement a command-line user interface to the BankCD
 *  class that was implemented in exercise 5-20. It should use the NumberFormat
 *  class to format output.
 *
 * NOTE: This class must have access to the KeyboardReader and BankCD classes
 *  in order to compile and run.
 */
import java.text.NumberFormat;   // For formatting \$nn.dd or n\%

public class TestBankCD 
{ 
    private KeyboardReader reader = new KeyboardReader();   
    private NumberFormat dollars = NumberFormat.getCurrencyInstance(); 
    private NumberFormat percent = NumberFormat.getPercentInstance();
    private BankCD cd;

    /**
     *  run() gets input from the user and uses a BankCD object to calculate
     *   the maturity value of a CD.
     */
    public void run()
    { 
	reader.display("Compares daily and annual compounding for a CD.\n");
	reader.prompt("  Input the CD's initial principal, e.g.  1000.55 > ");
	double principal = reader.getKeyboardDouble();
	reader.prompt("  Input the CD's interest rate, e.g.  6.5 > ");
	double rate = reader.getKeyboardDouble() / 100.0;
	reader.prompt("  Input the number of years to maturity, e.g., 10.5 > ");
	double years = reader.getKeyboardDouble();
	cd = new BankCD(principal, rate, years);
	percent.setMaximumFractionDigits(2);
	System.out.println("For Principal = " + dollars.format(principal) +
			   " Rate= " + percent.format(rate) +
			   " Years= " + years);
	double cdAnnual = cd.calcYearly();  // Compounded yearly
	double cdDaily =  cd.calcDaily();   // Compounded annually
	System.out.println(" The maturity value compounded yearly is " +
			   dollars.format(cdAnnual));
	System.out.println(" The maturity value compounded daily is: " +
			   dollars.format(cdDaily));
    } // run()

    /**
     *  main() creates a TestBankCD object and invokes its run() method.
     */
    public static void main( String args[] ) 
    { 
	TestBankCD cd = new TestBankCD();
	cd.run();
    } // main()
}// TestBankCD
