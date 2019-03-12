package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

import java.util.ArrayList;

public class Rocchetti2Wizard extends Wizard {

    /**
     * @author Francesco Rocchetti 445854
     *
     * @return
     */

    ArrayList<Integer> lista;
    private int target =8192;

    public Rocchetti2Wizard() {
        lista = new ArrayList<>();
        lista.add(8192);
    }

    @Override
    public void fundClosed(int time, int yourRevenue, int partnerRevenue) {
        int max;
        if(yourRevenue > partnerRevenue){
            max = yourRevenue;
        }
        else {
            max = partnerRevenue;
        }

        lista.add(max);

        int t=0;

        for(Integer a : lista){
            t+=a;
        }

        target= t/lista.size();

    }


    @Override
    public Decision askKeepOrLiquidate(int fundValue, int timespan) {

        if ((int)(fundValue * 0.80) >= target) {
            return Decision.LIQUIDATE_FUND;
        }
        else
            return Decision.KEEP_FUND;
    }
}
