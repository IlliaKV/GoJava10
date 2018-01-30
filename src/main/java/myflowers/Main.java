package myflowers;

import myflowers.flowers.Chamomile;
import myflowers.flowers.Flower;
import myflowers.flowers.Rose;
import myflowers.flowers.Tulip;
import myflowers.FlowersSaver;
import myflowers.FlowersLoader;

public class Main {
    public static void main(String[] args) {
        FlowerStore flowerStore = new FlowerStore();

        flowerStore.sell(5, 3, 1);
        System.out.println(flowerStore.toString());
        System.out.println(flowerStore.getPurse());

        flowerStore.sellSequence(5, 3, 1);
        System.out.println(flowerStore.toString());
        System.out.println(flowerStore.getPurse());

        FlowersSaver.save("Files/Flowers/myflowers.txt", flowerStore.flowers);

        flowerStore.flowers = FlowersLoader.load("Files/Flowers/myflowers.txt");
        System.out.println(flowerStore.toString());
    }
}
