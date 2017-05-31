public class BankCD {
    private double principal;       // The CD's initial principal
    private double rate;            // CD's interest rate
    private double years;           // Number of years to maturity

    public BankCD(double p, double r, double y) 
    {   principal = p;
        rate = r;
        years = y;
    }

    public double calcYearly() 
    {
        return principal * Math.pow(1 + rate, years);
    }

    public double calcDaily() 
    {
        return principal * Math.pow(1 + rate/365, years*365);
    }
}
