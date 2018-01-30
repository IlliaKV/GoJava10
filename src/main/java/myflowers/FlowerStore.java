package myflowers;

import myflowers.flowers.Chamomile;
import myflowers.flowers.Flower;
import myflowers.flowers.Rose;
import myflowers.flowers.Tulip;

import java.util.Arrays;

public class FlowerStore {
    public Flower[] flowers;
    private double purse;

    public FlowerStore() {
        purse = 0;
    }

    @Override
    public String toString() {
        String flowersStr = "";
        for (int i=0; i<flowers.length; i++)
            flowersStr += flowers[i].toString();
        return flowersStr;
    }

    public Flower[] sell(int countRoses, int countChamomile, int countTulips) {
        flowers = new Flower[countRoses + countChamomile + countTulips];

        for(int i=0; i<countRoses; i++){
            flowers[i] = new Rose();
            setPurse(getPurse()+((Rose)flowers[i]).getPrice());
        }
        for(int i=0; i<countChamomile; i++){
            flowers[i + countRoses] = new Chamomile();
            setPurse(getPurse()+((Chamomile)flowers[i + countRoses]).getPrice());
        }
        for(int i=0; i<countTulips; i++){
            flowers[i + countRoses + countChamomile] = new Tulip();
            setPurse(getPurse()+((Tulip)flowers[i + countRoses + countChamomile]).getPrice());
        }


        return flowers;
    }

    public Flower[] sellSequence(int countRoses, int countChamomile, int countTulips) {
        flowers = new Flower[countRoses + countChamomile + countTulips];

        int linkNumber = 1;

        for(int i=0; i<flowers.length; i++){
            if(linkNumber == 1){
                flowers[i] = new Rose();
                setPurse(getPurse()+((Rose)flowers[i]).getPrice());
                countRoses--;

                if(countChamomile > 0)      linkNumber = 2;
                else if(countTulips > 0)    linkNumber = 3;
                else if(countRoses > 0)     linkNumber = 1;

            }else if(linkNumber == 2){
                flowers[i] = new Chamomile();
                setPurse(getPurse()+((Chamomile)flowers[i]).getPrice());
                countChamomile--;

                if(countTulips > 0)         linkNumber = 3;
                else if(countRoses > 0)     linkNumber = 1;
                else if(countChamomile > 0) linkNumber = 2;

            }else if(linkNumber == 3){
                flowers[i] = new Tulip();
                setPurse(getPurse()+((Tulip)flowers[i]).getPrice());
                countTulips--;

                if(countRoses > 0)          linkNumber = 1;
                else if(countChamomile > 0) linkNumber = 2;
                else if(countTulips > 0)    linkNumber = 3;
            }
        }

        return flowers;
    }

    public double getPurse() {
        return purse;
    }

    public void setPurse(double purse) {
        this.purse = purse;
    }
}
