package javaBasics;

public class Main {

    public static void main(String[] args) {

        InterfaceStart interfaceStart1 = new ImplementedClass1();
        ClassStart classStart = new ClassStart(interfaceStart1);

        System.out.println("case 0 : run interface default method.");
        InterfaceStart interfaceStart2 = new InterfaceStart() {
        };
        interfaceStart2.starterProcedure(1);

        System.out.println("case 1 : run interface default method as a field of a class.");
        classStart.someMethod(interfaceStart1);

        System.out.println();
        System.out.println("Before type changed : " + interfaceStart1.getClass());
        System.out.println("Interface : " + interfaceStart2.getClass());
        ImplementedClass1 castingExample1;
        castingExample1 = (ImplementedClass1) interfaceStart1;

        System.out.println("After type changed : " + castingExample1.getClass());
        System.out.println();

        System.out.println("case 2 : run interface method override by a class.");
        classStart.someMethod(interfaceStart1);
    }
}
