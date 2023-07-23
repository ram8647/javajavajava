import java.io.*;                // Import the Java I/O Classes
import java.text.NumberFormat;   // For formatting as $nn.dd or n%

public class CDInterest {
    private KeyboardReader reader = new KeyboardReader();   // Keyboard interface

    private double principal;                     // The CD's initial principal
    private double rate;                          // CD's interest rate
    private double years;                         // Number of years to maturity
    private double cdAnnual;        // Accumulated principal with annual compounding
    private double cdDaily;         // Accumulated principal with daily compounding

    public void run()
    {   getInput();
        calcAndReportResult();
    }
    
    public void getInput()
    {                                              // Prompt the user and get the input
        reader.display("This program compares daily and annual compounding for a CD.\n");
        reader.prompt("     Input the CD's initial principal, e.g.  1000.55 > ");
        principal = reader.getKeyboardDouble();
        reader.prompt("     Input the CD's interest rate, e.g.  6.5 > ");
        rate = reader.getKeyboardDouble() / 100.0;
        reader.prompt("     Input the number of years to maturity, e.g., 10.5 > ");
        years = reader.getKeyboardDouble();
    } //getInput()

    public void calcAndReportResult() {
                                      // Calculate and output the result
        NumberFormat dollars = NumberFormat.getCurrencyInstance(); // Set up formats
        NumberFormat percent = NumberFormat.getPercentInstance();
        percent.setMaximumFractionDigits(2);

        cdAnnual = principal * Math.pow(1 + rate, years);        // Calculate interest
        cdDaily = principal * Math.pow(1 + rate/365, years*365);
                                                                 // Print the results
        System.out.println("The original principal is " + dollars.format(principal));
        System.out.println("The resulting principal compounded daily at " +
                       percent.format(rate) + " is " + dollars.format(cdDaily));
        System.out.println("The resulting principal compounded yearly at " +
                       percent.format(rate) + " is " + dollars.format(cdAnnual));
    }// calcAndReportResult()

    public static void main( String args[] ) 
    {   CDInterest cd = new CDInterest();
        cd.run();
    } // main()
}// CD Interest
