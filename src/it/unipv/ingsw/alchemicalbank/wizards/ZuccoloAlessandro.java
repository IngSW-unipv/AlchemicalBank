package it.unipv.ingsw.alchemicalbank.wizards;

import it.unipv.ingsw.alchemicalbank.Decision;
import it.unipv.ingsw.alchemicalbank.Wizard;

public class ZuccoloAlessandro extends Wizard {
private int anno;
private int ordine;
private long mieMonete;
private long sueMonete;

    @Override
    public void newFund(int year, int order, long yourCoins, long partnerCoins) {
        anno=year;
        ordine=order;
        mieMonete=yourCoins;
        sueMonete=partnerCoins;
    }


    @Override
    public Decision askKeepOrLiquidate(int fundValue, int timespan) {
        switch(anno){
            case 1: if(ordine==1 && timespan >=11){
                return Decision.LIQUIDATE_FUND;
            }else if(ordine==2 && timespan >=10){
                return Decision.LIQUIDATE_FUND;
            }else{
                return Decision.KEEP_FUND;
            }

            case 2:
                if(ordine==1 && timespan >=11){
                    return Decision.LIQUIDATE_FUND;
                }else if(ordine==2 && timespan >=10){
                    return Decision.LIQUIDATE_FUND;
                }else{
                    return Decision.KEEP_FUND;
                }

            case 3:
                if(ordine==1 && timespan >=11){
                    return Decision.LIQUIDATE_FUND;
                }else if(ordine==2 && timespan >=10){
                    return Decision.LIQUIDATE_FUND;
                }else{
                    return Decision.KEEP_FUND;
                }


            case 4:
                if(ordine==1 && timespan >=11){
                    return Decision.LIQUIDATE_FUND;
                }else if(ordine==2 && timespan >=10){
                    return Decision.LIQUIDATE_FUND;
                }else{
                    return Decision.KEEP_FUND;
                }


                case 5:
                    if(ordine==1 && timespan >=11){
                        return Decision.LIQUIDATE_FUND;
                    }else if(ordine==2 && timespan >=10){
                        return Decision.LIQUIDATE_FUND;
                    }else{
                        return Decision.KEEP_FUND;
                    }


            case 6:
                if(mieMonete>=sueMonete) {
                    if (ordine == 1 && timespan >= 7) {
                        return Decision.LIQUIDATE_FUND;
                    } else if (ordine == 2 && timespan >= 8) {
                        return Decision.LIQUIDATE_FUND;
                    } else {
                        return Decision.KEEP_FUND;
                    }
                }else {
                    if (ordine == 1 && timespan >= 11) {
                        return Decision.LIQUIDATE_FUND;
                    } else if (ordine == 2 && timespan >= 10) {
                        return Decision.LIQUIDATE_FUND;
                    } else {
                        return Decision.KEEP_FUND;
                    }
                }


                case 7:
                    if(mieMonete>=sueMonete) {
                        if (ordine == 1 && timespan >= 7) {
                            return Decision.LIQUIDATE_FUND;
                        } else if (ordine == 2 && timespan >= 8) {
                            return Decision.LIQUIDATE_FUND;
                        } else {
                            return Decision.KEEP_FUND;
                        }
                    }else {
                        if (ordine == 1 && timespan >= 11) {
                            return Decision.LIQUIDATE_FUND;
                        } else if (ordine == 2 && timespan >= 10) {
                            return Decision.LIQUIDATE_FUND;
                        } else {
                            return Decision.KEEP_FUND;
                        }
                    }


            case 8:
                if(mieMonete>=sueMonete) {
                    if (ordine == 1 && timespan >= 7) {
                        return Decision.LIQUIDATE_FUND;
                    } else if (ordine == 2 && timespan >= 8) {
                        return Decision.LIQUIDATE_FUND;
                    } else {
                        return Decision.KEEP_FUND;
                    }
                }else {
                    if (ordine == 1 && timespan >= 11) {
                        return Decision.LIQUIDATE_FUND;
                    } else if (ordine == 2 && timespan >= 10) {
                        return Decision.LIQUIDATE_FUND;
                    } else {
                        return Decision.KEEP_FUND;
                    }
                }


                case 9:
                    if(mieMonete>=sueMonete) {
                        if (ordine == 1 && timespan >= 7) {
                            return Decision.LIQUIDATE_FUND;
                        } else if (ordine == 2 && timespan >= 8) {
                            return Decision.LIQUIDATE_FUND;
                        } else {
                            return Decision.KEEP_FUND;
                        }
                    }else {
                        if (ordine == 1 && timespan >= 11) {
                            return Decision.LIQUIDATE_FUND;
                        } else if (ordine == 2 && timespan >= 10) {
                            return Decision.LIQUIDATE_FUND;
                        } else {
                            return Decision.KEEP_FUND;
                        }
                    }


            case 10:
                if(mieMonete>=sueMonete) {
                    if (ordine == 1 && timespan >= 7) {
                        return Decision.LIQUIDATE_FUND;
                    } else if (ordine == 2 && timespan >= 8) {
                        return Decision.LIQUIDATE_FUND;
                    } else {
                        return Decision.KEEP_FUND;
                    }
                }else {
                    if (ordine == 1 && timespan >= 11) {
                        return Decision.LIQUIDATE_FUND;
                    } else if (ordine == 2 && timespan >= 10) {
                        return Decision.LIQUIDATE_FUND;
                    } else {
                        return Decision.KEEP_FUND;
                    }
                }
                default:if(timespan>10){
                    return Decision.LIQUIDATE_FUND;
                }

        }
        return null;
    }
}