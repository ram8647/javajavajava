public class Temperature
{   
    public Temperature() {}

    public static double fahrToCels(double temp)
    {   
        return (5.0 * (temp - 32.0) / 9.0);
    }
    public static double celsToFahr(double temp)
    {   
        return (9.0 * temp / 5.0 + 32.0);
    }
}
