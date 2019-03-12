package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

import java.util.ArrayList;

/*
 Fabio Pezzini 445353
 */
    public class TryWizard extends Wizard {
        private ArrayList<Integer> timeclosed;
        private int count;
        private int year;
        private int myOrder;
        private int averageT;
        private int previous;

        @Override
        public Decision askKeepOrLiquidate(int fundValue, int timespan) {
            if (year == 1)
                return Decision.KEEP_FUND;
            if (timespan < 11)
                return Decision.KEEP_FUND;
            else
                return Decision.LIQUIDATE_FUND;
            /*
            if (myOrder == 1) {
                if(timespan >= 7) {
                    return Decision.LIQUIDATE_FUND;
                }
            }
            if (myOrder == 2) {
                if(timespan >= 8) {
                    return Decision.LIQUIDATE_FUND;
                }
            }
            if (timeclosed.size() > 1 && previous==averageT) {
                if(timespan == (previous-1)) {
                    return Decision.LIQUIDATE_FUND;
                }
            }
            if(timeclosed.size() > 2 && timespan==(averageT-1)) {
                return Decision.LIQUIDATE_FUND;
            }
            return Decision.KEEP_FUND;
 */
        }


        @Override
        public void fundClosed(int time, int yourRevenue, int partnerRevenue) {
            super.fundClosed(time, yourRevenue, partnerRevenue);
            timeclosed.add(time);
            averageT = averageTime();
            previous = time;

        }

        public int averageTime() {
            int sum  = 0;
            int num = 0;
            for(int i = 0; i < timeclosed.size(); i++) {
                sum = sum + timeclosed.get(i);
                num++;
            }

            return sum/num;
        }

        @Override
        public void newFund(int year, int order, long yourCoins, long partnerCoins) {
            super.newFund(year, order, yourCoins, partnerCoins);
            this.year = year;
            this.myOrder = order;
        }

        public TryWizard() {
            timeclosed = new ArrayList<>();
            count = 0;
        }}


