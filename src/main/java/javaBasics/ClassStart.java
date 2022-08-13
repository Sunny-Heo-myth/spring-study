package javaBasics;

public class ClassStart {

    InterfaceStart goodProcedure;

    public ClassStart(InterfaceStart goodProcedure) {
        this.goodProcedure = goodProcedure;
    }

    public void someMethod(InterfaceStart interfaceStart) {
        interfaceStart.starterProcedure(1000000000);
    }
}
