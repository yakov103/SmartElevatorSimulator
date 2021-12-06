package ex0.algo;

import ex0.Building;
import ex0.CallForElevator;
import ex0.Elevator;


import java.util.Collections;
import java.util.PriorityQueue;

public class MyAlgo extends Utils implements ElevatorAlgo  {

    public Building _building;

    public ElevetorController[] elevatorControllers;

    public MyAlgo(Building b) {// constractor
        _building = b;
        elevatorControllers = new ElevetorController[_building.numberOfElevetors()];
        for (int i = 0; i < b.numberOfElevetors(); i++) {
            elevatorControllers[i] = new ElevetorController();
        }
    }

    @Override
    public Building getBuilding() {
        return _building;
    }

    @Override
    public String algoName() {
        return "Ex0_OOP_SMART_ELEVATOR_YAKOV_AND_NIR";
    }

    @Override
    public int allocateAnElevator(CallForElevator c) {
        double[] results = new double[_building.numberOfElevetors()];
        for (int i = 0; i < _building.numberOfElevetors(); i++) {
            Elevator curr = _building.getElevetor(i);
            results[i] = elevatorControllers[i].calculateTravel(curr, c);
        }
        int min = Utils.indexOfSmallest(results);
        elevatorControllers[min].pushAnOrder(c);
        return min;

    }
    @Override
    public void cmdElevator(int elev) {
        Elevator curr = this._building.getElevetor(elev);
        elevatorControllers[elev].navigateElevator(curr);
    }
}