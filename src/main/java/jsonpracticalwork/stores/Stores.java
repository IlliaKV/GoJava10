package jsonpracticalwork.stores;

public class Stores {
    public Store<ProductFruit>  fruitStore;
    public Store<ProductTech>   techStore;
    public Store<ProductAnimal> animalStore;

    public Stores(Store<ProductFruit> fruitStore, Store<ProductTech> techStore, Store<ProductAnimal> animalStore) {
        this.fruitStore = fruitStore;
        this.techStore = techStore;
        this.animalStore = animalStore;
    }

    @Override
    public String toString() {
        return "{" +
                "fruitStore=" + fruitStore +
                ", techStore=" + techStore +
                ", animalStore=" + animalStore +
                '}';
    }
}
