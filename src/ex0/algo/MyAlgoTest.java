package ex0.algo;

import ex0.Building;
import ex0.CallForElevator;
import ex0.Elevator;
import ex0.simulator.Call_A;
import ex0.simulator.Simulator_A;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ex0.Building;
import static org.junit.jupiter.api.Assertions.*;
import ex0.algo.ElevetorController;
class MyAlgoTest {

    Building b1;
    MyAlgo myAlgo;


    @Test
    void getBuilding() {
        Simulator_A.initData(1,null);
        b1 = Simulator_A.getBuilding();
        myAlgo = new MyAlgo(b1);
        Assertions.assertEquals(b1, myAlgo.getBuilding());
    }

    @Test
    void algoName() {
        Simulator_A.initData(0,null);
        b1 = Simulator_A.getBuilding();
        myAlgo = new MyAlgo(b1);
        Assertions.assertEquals("Ex0_OOP_SMART_ELEVATOR_YAKOV_AND_NIR",  myAlgo.algoName() );
    }

    @Test
    void allocateAnElevator() {
        Simulator_A.initData(0, null);
        b1 = Simulator_A.getBuilding();
        myAlgo = new MyAlgo(b1);
        CallForElevator c = new Call_A(1, 0, 1);

        Assertions.assertEquals(0, myAlgo.allocateAnElevator(c));

    }


    @Test
    void cmdElevator() {// this also check for "navigateElevator"
        Simulator_A.initData(0, null);
        b1 = Simulator_A.getBuilding();
        myAlgo = new MyAlgo(b1);
        Assertions.assertEquals(0, myAlgo.getBuilding().getElevetor(0).getState());
        Assertions.assertEquals(0, myAlgo.getBuilding().getElevetor(0).getPos());

    }

    @Test
    void indexOfSmallest() {
        Simulator_A.initData(0, null);
        b1 = Simulator_A.getBuilding();
        myAlgo = new MyAlgo(b1);
        double arr[] = {4, 3, 2, 7, 1};
        Assertions.assertEquals(4, Utils.indexOfSmallest(arr));

    }
}