package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

import java.util.ArrayList;

public class GullottiAlessio extends Wizard {
    int year,order;
    long yourCoins,partnerCoins;
    ArrayList<Integer> time;
    int mediatempo;
    public GullottiAlessio() {
        time=new ArrayList<>();
    }

    @Override
    public Decision askKeepOrLiquidate(int fundValue, int timespan) {
        if (timespan % 2 == 0) {
            if (timespan > (mediatempo+8)/2)
                return Decision.LIQUIDATE_FUND;
            else
                return Decision.KEEP_FUND;
        }
        else {
            if (timespan > (mediatempo+9)/2)
                return Decision.LIQUIDATE_FUND;
            else
                return Decision.KEEP_FUND;
        }
    }

    @Override
    public void newFund(int year, int order, long yourCoins, long partnerCoins) {
        super.newFund(year, order, yourCoins, partnerCoins);
        this.year=year;
        this.order=order;
        this.partnerCoins=partnerCoins;
        this.yourCoins=yourCoins;
    }

    @Override
    public void fundClosed(int time, int yourRevenue, int partnerRevenue) {
        super.fundClosed(time, yourRevenue, partnerRevenue);
        this.time.add(time);
        mediatempo=media(this.time);
    }
    public int media(ArrayList<Integer> a){
        int sum=0;
        int i=0;
        for(int x: a){
            sum+=x;
            i++;
        }
        return sum/i;
    }
}
