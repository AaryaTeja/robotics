package com.company;

public class PlanRates
{
    private int dataRate ;
    private double base ;
    private double discount;
    private double callMessageRate;

    PlanRates()
    {
        dataRate = 3 ;
        base =  20.00 ;
        discount =  0.0 ;
        callMessageRate =  0.10 ;
    }

    PlanRates( int dataRate , double base , double discount, double callMessageRate)
    {
        this.dataRate = dataRate ;
        this.base = base ;
        this.discount =  discount ;
        this.callMessageRate = callMessageRate ;
    }

    public double getRatePerUser()
    {
        return base *  (1- discount) ;
    }

    public int getDataRate ()
    {
        return  dataRate ;
    }

    public double getCallMessageRate ()
    {
        return callMessageRate ;
    }









}
