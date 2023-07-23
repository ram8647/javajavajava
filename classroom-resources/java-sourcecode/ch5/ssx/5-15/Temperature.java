/*
 * File: Temperature.java
 * Author: Java, Java, Java
 * Description: This class contains methods to convert
 *   temperature from Celsius to Fahrenheit and vice versa.
 */

public class Temperature             
{
    public Temperature() {}

    /** 
     * fahrToCels() converts its parameter to Celsius
     * @param temp -- gives the temperature in Fahrenheit 
     * @return -- a double giving the temperature in Celsius
     */
    public double fahrToCels(double temp)
    {
        return (5.0 * (temp - 32.0) / 9.0);
    }

    /** 
     * celsToFahr() converts its parameter to Fahrenheit
     * @param temp -- gives the temperature in Celsius
     * @return -- a double giving the temperature in Fahrenheit
     */
    public double celsToFahr(double temp)
    {
        return (9.0 * temp / 5.0 + 32.0);
    }
} // Temperature
