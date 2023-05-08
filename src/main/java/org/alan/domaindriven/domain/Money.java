package org.alan.domaindriven.domain;

public class Money {
    private int value;

    public Money(int number) {
        this.value = number;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Money add(Money money) {
        return new Money(this.value + money.getValue());
    }

    public Money multiply(int multiplier) {
        return new Money(this.value * multiplier);
    }
}
