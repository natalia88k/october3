package October3;

import java.util.ArrayList;

public class Box<T extends Fruit> {
    private ArrayList<T> fruits;
    private static float EPS = 1e-6f;

    public Box() {
        this.fruits = new ArrayList<>();
    }

    public void AddFruit(T fruit) {
        fruits.add(fruit);
    }

    public float getWeight() {
        return fruits.isEmpty() ? 0.0f : fruits.size() * fruits.get(0).getWeight();
    }

    public boolean isEmpty() {
        return fruits.isEmpty();
    }

    public boolean compare(Box<?> other) {
        return Math.abs(this.getWeight() - other.getWeight()) < EPS;
    }

    public void MoveFruitsToOtherBox(Box<T> other) {
        for (int i = 0; i < fruits.size(); i++) {
            other.AddFruit(fruits.get(i));
        }
        fruits.clear();
    }

}
