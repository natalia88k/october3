package October3;

public class Main {
    public static void TestSwapper() {
        Integer[] intArray = new Integer[3];
        intArray[0] = 1;
        intArray[1] = 1234;
        intArray[2] = 3;
        new Swapper<Integer>().swapElements(intArray, 0, 1);
        if (intArray[0] == 1234 && intArray[1] == 1) {
            System.out.println("Test passed! Elements were swapped!");
        } else {
            System.out.println("Test failed! Elements were not swapped.");
        }

        String[] stringArray = new String[2];
        stringArray[0] = "Vasya";
        stringArray[1] = "Petya";
        new Swapper<String>().swapElements(stringArray, 0, 1);
        if (stringArray[0].equals("Petya") && stringArray[1].equals("Vasya")) {
            System.out.println("Test passed! Elements were swapped!");
        } else {
            System.out.println("Test failed! Elements were not swapped.");
        }

        try {
            new Swapper<String>().swapElements(stringArray, -1, 100);
        } catch (RuntimeException e) {
            System.out.println("Test passed! Incorrect indexes were passed!");
        }
    }

    public static void TestFruits() {
        Box<Apple> applesBox = new Box<>();
        Box<Orange> orangesBox = new Box<>();

        int numOfApplesToAdd = 3;
        int numOfOrangesToAdd = 2;

        for (int i = 0; i < numOfApplesToAdd; i++) {
            applesBox.AddFruit(new Apple());
        }

        for (int i = 0; i < numOfOrangesToAdd; i++) {
            orangesBox.AddFruit(new Orange());
        }

        if (orangesBox.compare(applesBox) && applesBox.compare(orangesBox)) {
            System.out.println("Test passed! 3 * 1 == 2 * 1.5");
        } else {
            System.out.println("Test failed! Weight for boxes should be equal");
        }

        orangesBox.AddFruit(new Orange());

        if (!orangesBox.compare(applesBox) && !applesBox.compare(orangesBox)) {
            System.out.println("Test passed! 3 * 1 != 3 * 1.5");
        } else {
            System.out.println("Test failed! Weight for boxes should be different");
        }

        Box<Orange> newOrangesBox = new Box<>();
        orangesBox.MoveFruitsToOtherBox(newOrangesBox);

        if (Math.abs(newOrangesBox.getWeight() - 4.5) < 1e-3 && orangesBox.isEmpty()) {
            System.out.println("Test passed! New orange box is filled with oranges from old box and old box is empty!");
        } else {
            System.out.println("Test failed! Oranges were not moved!");
        }

        // applesBox.MoveFruitsToOtherBox(orangesBox); doesn't compile.

        // Box<Fruit> fruitBox = new Box<>();
        // fruitBox.MoveFruitsToOtherBox(applesBox); - doesn't compile as well.
    }

    public static void main(String[] args) {
        TestSwapper();
        TestFruits();
    }
}
