package leetcode.blankfactor.oop.classes_and_objects.generic_method_task;

import java.util.ArrayList;
import java.util.List;

public class SwapElements {
    public static <T> ArrayList<T> swapElements(ArrayList<T> elements, int firstIndex, int secondIndex) {
        T temp = elements.get(firstIndex);
        elements.set(firstIndex, elements.get(secondIndex));
        elements.set(secondIndex, temp);

        return elements;
    }

    public static void main(String[] args) {
        ArrayList<String> elements = new ArrayList<>();

        elements.add("Maria");
        elements.add("Dimitar");
        elements.add("Petar");

        swapElements(elements, 0, 1);

        System.out.println(elements);
    }
}
