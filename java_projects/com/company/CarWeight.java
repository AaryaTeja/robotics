package com.company;

public class CarWeight
{

    private double passOne, passTwo;
    public CarWeight ()
    {
        passOne = 210.60;
        passTwo =  148.37;

    }
    public static void main(String[] args)
    {
        CarWeight newCar = new CarWeight();
        newCar.driverWeight();
        CarWeight oldCar = new CarWeight();

    }


    public void driverWeight()
    {

        double driver = 250.45;
        double total = 0.0;
        total = totalCarWeight(driver);
        System.out.printf("The total weight is: %.10f.\n", total);
    }




    public double totalCarWeight(double driverWeight)

    {
        return driverWeight + passOne + passTwo;
    }



}
