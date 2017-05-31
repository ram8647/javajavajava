/*
 * File: BankCD.java
 * Author: Java, Java, Java
 * Description: Solution to Self-study exercise 5-20.
 * 
 * Problem: Implement a BankCD class that calculates the maturity
 *  of a Certificate of Deposit.
 */
public class BankCD 
{   
    private double principal;   // The CD's initial principal
    private double rate;        // CD's interest rate
    private double years;       // Number of years to maturity

    /**
     * BankCD() constructor sets the principal, interest rate and
     *  number of years.
     * @param p the initial principal
     * @param r the interest rate
     * @param y the number of years
     */
    public BankCD(double p, double r, double y) 
    {   
	principal = p;
        rate = r;
        years = y;
    } // BandCD()

    /**
     * calcYearly() calculates the CD's maturity value assuming
     *   that interest is compounded yearly.
     */
    public double calcYearly() 
    {   
        return principal * Math.pow(1 + rate, years);
    } // calcYearly()

    /**
     * calcDaily() calculates the CD's maturity value assuming
     *   that interest is compounded dailyly.
     */
    public double calcDaily() 
    {   
	return principal * Math.pow(1 + rate/365, years*365);
    } // calcDaily()
} // BankCD
