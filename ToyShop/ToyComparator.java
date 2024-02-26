import java.util.Comparator;

public class ToyComparator implements Comparator<Toy>
{
    @Override
    public int compare(Toy o1, Toy o2) {
        int weightComparison = Double.compare(o1.getWeight(), o2.getWeight());

        if(weightComparison == 0){
            return Integer.compare(o1.getQuantity(), o2.getQuantity());
        }

        return weightComparison;
    }
        
}
