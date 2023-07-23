import java.text.NumberFormat;   // For formatting as $nn.dd or n%

public class TestBankCD {
    private KeyboardReader reader = new KeyboardReader();   // Keyboard interface
    private NumberFormat dollars = NumberFormat.getCurrencyInstance(); 
    private NumberFormat percent = NumberFormat.getPercentInstance();
    private BankCD cd;

    public void run()
    {   reader.display("This program compares daily and annual compounding for a Bank CD.\n");
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
                           " Yearss= " + years);

        double cdAnnual = cd.calcYearly();  // Compounded yearly
        double cdDaily =  cd.calcDaily();   // Compounded annually
        System.out.println(" The maturity value compounded yearly is " +
                       dollars.format(cdAnnual));
        System.out.println(" The maturity value compounded daily is: " +
                       dollars.format(cdDaily));
    } // run()

    public static void main( String args[] ) 
    {   TestBankCD cd = new TestBankCD();
        cd.run();
    } // main()
}// TestBankCD
