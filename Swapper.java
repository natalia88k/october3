package October3;

public class Swapper<T> {
    private boolean checkBoundaries(int length, int index) {
        return 0 <= index && index < length;
    }

    public void swapElements(T[] array, int i, int j) {
        if (i == j) {
            return;
        }

        if (!checkBoundaries(array.length, i) || !checkBoundaries(array.length, j)) {
            throw new RuntimeException("Incorrect indexes for swapping!");
        }

        T tempValue = array[i];
        array[i] = array[j];
        array[j] = tempValue;
    }
}
