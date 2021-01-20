package bai11_HashMap_LinkedHashMap_TreeMap.baitap.LuyenTap_ArrayList_LinkedList;

import java.util.Comparator;

public class ComparatorByPrice implements Comparator<Product> {

    @Override
    public int compare(Product o1, Product o2) {
        if (o1.getCost() > o2.getCost()) {
            return 1;
        } else if (o1.getCost() < o2.getCost()) {
            return -1;
        } else {
            return o1.getName().compareTo(o2.getName());
        }
    }
}
