package com.example.mcalc;

public class MortgageModel {
    private double p;
    private double r;
    private int n;

    /**
     * Description: parameterized constructor accept three parameter n, p r, all strings
     * and convert and stored them accordingly
     * Method: Using the parseDouble and parseInt in Double and Integer classes to convert
     *        them to the correct states ACCORDINGLY.
     */
    public MortgageModel (String a , String b, String c)
    {
        p = Double.parseDouble(a);
        n = Integer.parseInt(b) * 12;
        r = (Double.parseDouble(c) / 12) / 100;

    }


    public String getPayment()
    {
        double result = 1;
        double nom = r * p;
        double denom1 = (1)/((1 + (n * r) + (( n * (n - 1) * (Math.pow(r,2))/2))));
        double denom2 = 1 - denom1;
        //System.out.println("The Rate value , R is "+R );
        //System.out.println("The Principle value, P is "+P);
        //System.out.println("The Interest  value , n is "+n);

        result =  (nom) / (denom2);
        //System.out.println("The Result is "+result);
        return String.format("%,.2f", result);

    }
    public String computeExactPayment()
    {
        double result = 1;
        double nom = r * p;
        double denom = 1 - (Math.pow( 1 + r , -n ));

        result = (nom) / (denom);

        return String.format("%,.2f", result);
    }
    public static void main(String[] args) {
        MortgageModel myModel= new MortgageModel("7000", "25", "2.75");
        System.out.println(myModel.getPayment());
    }


}
