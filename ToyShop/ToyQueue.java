import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;



class ToyQueue
{   
    private PriorityQueue<Toy> toyQueue = new PriorityQueue<>(new ToyComparator());

    public void addToy(Toy toy) {
        toyQueue.add(toy);
    }

    public void updateToyWeight(int toyId, double newWeight) {
        Toy updatedToy = null;

        for (Toy toy : toyQueue) {
            if (toy.getId() == toyId) {
                updatedToy = toy;
                break;
            }
        }

        if (updatedToy != null) {
            updatedToy.setWeight(newWeight);

            toyQueue.remove(updatedToy);
            toyQueue.add(updatedToy);
        }
    }



public void playToys() {
    List<Toy> prizeToys = new ArrayList<>();

    for (Toy toy : toyQueue ) {
        int numPrizes = (int) ((toy.getWeight() / 100) * toy.getQuantity());
        for (int i = 0; i < numPrizes; i++) {
            prizeToys.add(toy);
        }
    }

    if (toyQueue.isEmpty()) {
        System.out.println("There are no toys to play with.");
        return;
    }

    Random random = new Random();
    Toy prizeToy = prizeToys.get(random.nextInt(prizeToys.size()));
    prizeToy.decreaseQuantity();

    try (FileWriter writer = new FileWriter("prize_toys.txt", true))
    {
        writer.write(prizeToy.toString() + "\n");
    } catch (IOException e) {
        e.printStackTrace();
    }

    System.out.println("The prize toy is: " + prizeToy.toString());
    }

    public void updateToyQuantitiesFromFile(String filePath) {
        for (Toy toy : toyQueue) {
            toy.updateQuantityFromFile(filePath);
        }
    }

    public void saveToyQuantitiesToFile(String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (Toy toy : toyQueue) {
                writer.write(toy.getId() + "," + toy.getQuantity() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public void showAvailableToys() {
        if (toyQueue.isEmpty()) {
            System.out.println("There are no available toys.");
            return;
        }

        for (Toy toy : toyQueue) {
            System.out.println(toy.toString());
        }
    }
}



