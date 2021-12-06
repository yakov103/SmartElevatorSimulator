package ex0.algo;

import ex0.Elevator;

public class Utils {
    public static double calculateFloorPassCost(Elevator elev, int startFloor, int finishFloor) {
        return Math.abs(finishFloor - startFloor)+ Math.abs(finishFloor - startFloor)/elev.getSpeed();
    }
    public static int indexOfSmallest(double[] arr) {

        if (arr.length == 0)
            return -1;

        int index = 0;
        double min = arr[index];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] <= min) {
                min = arr[i];
                index = i;
            }
        }
        return index;
    }
}
