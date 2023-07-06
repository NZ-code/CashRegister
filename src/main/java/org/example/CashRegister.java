package org.example;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class CashRegister {
    private Map<Integer, Integer> nominalToQuantity; // nominal measured in groszy
    public CashRegister(){
        nominalToQuantity = new TreeMap<>(Collections.reverseOrder());
        // cash register state at the beginning
        setStartState();
    }
    private void setStartState(){
        nominalToQuantity.put(zlotyToGroszy(5), 1);
        nominalToQuantity.put(zlotyToGroszy(2), 3);
        nominalToQuantity.put(zlotyToGroszy(1), 5);
        nominalToQuantity.put(50, 10);
        nominalToQuantity.put(20, 20);
        nominalToQuantity.put(10, 200);
        nominalToQuantity.put(5, 100);
        nominalToQuantity.put(2, 100);
        nominalToQuantity.put(1, 10000);
    }

    private String nominalToString(int nominal){
        String stateOfNominal = "";
        if(nominal %100 == 0){
            stateOfNominal = String.format("%d zł", (int)(nominal/100));
        }
        else{
            stateOfNominal = String.format("%d gr", (int)nominal);
        }
        return stateOfNominal;
    }
    private Integer zlotyToGroszy(double zloty) {
        return (int) (zloty * 100);
    }
    /*
        Returns current sum of all money in cash register
        in groszy.
     */
    private int getTotalMoney(){
        int sum =0;
        for(int nominal : nominalToQuantity.keySet()){
            sum += nominal * nominalToQuantity.get(nominal);
        }
        return sum;
    }
    /*
        Return true if the operation is possible. Otherwise, return false.
        Print the nominal values of coins along with the quantity needed to perform the change back operation.
        Remove these coins from the cash register.
    */

    public boolean giveChangeBack(double changeInZloty){

        int changeInGroszy = zlotyToGroszy(changeInZloty);
        if(changeInGroszy > getTotalMoney()) return false;
        for(int nominal : nominalToQuantity.keySet()){
            int quantityForNominal = nominalToQuantity.get(nominal);
            int coinsRemoved = 0;
            while(changeInGroszy!=0 && changeInGroszy >= nominal && quantityForNominal!=0){
                changeInGroszy -= nominal;
                quantityForNominal-=1;
                coinsRemoved +=1;
            }
            if(coinsRemoved >0){
                System.out.println(String.format("Wydaj %d monet %s", coinsRemoved, nominalToString(nominal)));
                nominalToQuantity.put(nominal, quantityForNominal);
            }
            if(changeInGroszy == 0) return true;

        }
        return false;
    }


}
