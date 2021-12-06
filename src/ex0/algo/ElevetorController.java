package ex0.algo;

import ex0.CallForElevator;
import ex0.Elevator;

import java.nio.channels.CancelledKeyException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class ElevetorController extends Utils {
    private PriorityQueue<Integer> currentPlaceOfEveUP;    //min heap
    private PriorityQueue<Integer> currentPlaceOfEveDOWN;   // max heap
    private int stopsForEachFloor[];
    private int direction;

    
    public ElevetorController(){
        currentPlaceOfEveDOWN = new PriorityQueue<>(Collections.reverseOrder());
        currentPlaceOfEveUP = new PriorityQueue<>();
        direction = Elevator.LEVEL;
    }
    public double calculateTravel(Elevator elevetor, CallForElevator c) {
        double cost = 0;
        cost += Utils.calculateFloorPassCost(elevetor, elevetor.getPos(), c.getSrc());
        cost += costOfStops(elevetor, c);
        return cost;
    }
    private double costOfStops(Elevator elevetor, CallForElevator c) {
        double stops = currentPlaceOfEveUP.size() + currentPlaceOfEveDOWN.size();
      if (currentPlaceOfEveDOWN.contains(c.getSrc())) stops--;
       if (currentPlaceOfEveUP.contains(c.getSrc())) stops--;
        return stops * (elevetor.getTimeForClose() + elevetor.getTimeForOpen() + elevetor.getStopTime() + elevetor.getStartTime());
    }
    public void pushAnOrder(CallForElevator c) {
        if (c.getDest() >= c.getSrc()) {
            currentPlaceOfEveUP.add(c.getSrc());
            currentPlaceOfEveUP.add(c.getDest());
        } else {
            currentPlaceOfEveDOWN.add(c.getSrc());
            currentPlaceOfEveDOWN.add(c.getDest());
           
        }

    }

    public void navigateElevator(Elevator curr){
        if (curr.getState() == Elevator.LEVEL) {
            if (direction == Elevator.UP) {
                if (!currentPlaceOfEveUP.isEmpty()) {
                    curr.goTo(currentPlaceOfEveUP.peek());
                    if (curr.getPos() == currentPlaceOfEveUP.peek()) currentPlaceOfEveUP.remove();
                } else {
                    direction = !currentPlaceOfEveDOWN.isEmpty() ? Elevator.DOWN : Elevator.UP;
                }
            } else if (direction == Elevator.DOWN) {
                if (!currentPlaceOfEveDOWN.isEmpty()) {
                    curr.goTo(currentPlaceOfEveDOWN.peek());
                    if (curr.getPos() == currentPlaceOfEveDOWN.peek()) currentPlaceOfEveDOWN.remove();
                } else {
                    direction = !currentPlaceOfEveUP.isEmpty() ? Elevator.UP : Elevator.DOWN;
                }
            } else {
                if (!currentPlaceOfEveUP.isEmpty()) {
                    curr.goTo(currentPlaceOfEveUP.peek());
                    direction = Elevator.UP;
                }
                if (!currentPlaceOfEveDOWN.isEmpty()) {
                    curr.goTo(currentPlaceOfEveDOWN.peek());
                    direction = Elevator.DOWN;
                }
            }

        }
    }
}
