package it.unipv.ingsw.alchemicalbank.wizards;

import java.security.Timestamp;
import java.util.ArrayList;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

//Angelica Seiberl 457995

public class AngelicaSeiberl extends Wizard {

	private int order;
	private int timeclose;
	private Boolean wonLastYear;

	public AngelicaSeiberl() {
		this.wonLastYear = true;
		this.timeclose = 12;

	}

	@Override
	public void newFund(int year, int order, long yourCoins, long partnerCoins) {
		// TODO Auto-generated method stub
		super.newFund(year, order, yourCoins, partnerCoins);

		this.order = order;

	}

	@Override
	public Decision askKeepOrLiquidate(int fundValue, int timespan) {

		if ((this.order == 2) && (timespan == this.timeclose)) {
			return Decision.LIQUIDATE_FUND;
		} else if ((this.order == 1) && (timespan == this.timeclose - 1)) {
			return Decision.LIQUIDATE_FUND;
		}

		return Decision.KEEP_FUND;

	}

	@Override
	public void fundClosed(int time, int yourRevenue, int partnerRevenue) {
		// TODO Auto-generated method stub
		super.fundClosed(time, yourRevenue, partnerRevenue);
		if (((this.order == 2) && (time % 2 == 0)) || ((this.order == 1) && (time % 2 != 0))) {

			this.wonLastYear = true;
			timeclose = 12;

		} else {
			this.wonLastYear = false;
			if (timeclose == 12) {
				timeclose = timeclose - 2;
			}
		}

	}

}
