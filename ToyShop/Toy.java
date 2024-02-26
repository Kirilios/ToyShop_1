import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Toy implements Comparable<Toy>{
    private int id;
    private String name;
    private int quantity;
    private double weight;

    public Toy(int id, String name, int quantity, double weight) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getQuantity() {
        return quantity;
    }

    public void decreaseQuantity() {
        if(quantity > 0){
            quantity--;
        }
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Quantity: " + quantity + ", Weight: " + weight + "%";
    }

    public int getId() {
      return id;
    }

    @Override
    public int compareTo(Toy o) {
        return Integer.compare(this.id, o.id);
    }

    public void updateQuantityFromFile(String filePath) {
    try (Scanner scanner = new Scanner(new File(filePath))) {
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split(",");
            if (parts.length == 2) {
                int toyId = Integer.parseInt(parts[0].trim());
                int newQuantity = Integer.parseInt(parts[1].trim());
                if (this.id == toyId) {
                    this.quantity = newQuantity;
                    break;
                }
            }
        }
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
}
}
