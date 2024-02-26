


public class Main
{
     public static void main(String[] args) {
        ToyQueue toyStore = new ToyQueue();

        Toy toy1 = new Toy(1, "Constructor", 10, 30);
        toyStore.addToy(toy1);

        Toy toy2 = new Toy(2, "Doll", 15, 30);
        toyStore.addToy(toy2);

        Toy toy3 = new Toy(3, "Car", 20, 40);
        toyStore.addToy(toy3);
        
        System.out.println("Toys available at the shop");

        toyStore.updateToyQuantitiesFromFile("toy_quantities.txt");

        toyStore.showAvailableToys();

        toyStore.updateToyWeight(2, 50);

        System.out.println("Start toy lottery!");

        toyStore.playToys();

        toyStore.saveToyQuantitiesToFile("toy_quantities.txt");

        toyStore.showAvailableToys();
    }
}   

