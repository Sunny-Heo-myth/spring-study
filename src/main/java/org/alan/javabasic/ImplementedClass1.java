package org.alan.javabasic;

public class ImplementedClass1 implements InterfaceStart{

    int field1 = 0;

    public int getField1() {
        return field1;
    }

    public void setField1(int field1) {
        this.field1 = field1;
    }

    @Override
    public int starterProcedure(int startParameter) {
        System.out.println("Running override method of a implemented class.");
        return startParameter + 1;
    }
}
