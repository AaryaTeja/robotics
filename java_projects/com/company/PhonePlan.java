package com.company;

import java.util.Scanner ;

public class PhonePlan
{
    private  int minMessages , data, numUsers ;

    PhonePlan()
    {
        minMessages = 0 ;
        data = 0  ;
        numUsers = 0 ;
    }


    public static void main(String[] args)
    {
        PhonePlan pp = new PhonePlan() ;
        pp.findInfo();
    }

    public void findInfo()
    {
        Scanner kb = new Scanner(System.in) ;
        System.out.print("\n\n\nHow many users you have in your group?  ");
        numUsers = kb.nextInt();
        System.out.print("How many GB does your group need per month?  ");
        data = kb.nextInt();
        System.out.print("How many minutes + messages does your  group use per month? ");
        minMessages = kb.nextInt();

        PlanRates individual =  new PlanRates() ;
        calculateAndPrint ("Individual plan(s)" , individual) ;


        PlanRates group =  new PlanRates(0,100,0.15,0 ) ;
        calculateAndPrint ("group plan " , group) ;

    }

    public  void  calculateAndPrint(String planName , PlanRates rate)
    {
        double costOfPlan = 0 ;

        costOfPlan = rate.getRatePerUser()*numUsers + rate.getDataRate()*data +rate.getCallMessageRate()*minMessages;
        System.out.println("The " + planName + " will cost you $" + costOfPlan );
    }



}
