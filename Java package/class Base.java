package com.access.one;

public class Base {

    public void publicMethod() {
        System.out.println("Public Method: Accessible everywhere");
    }

    protected void protectedMethod() {
        System.out.println("Protected Method: Accessible in subclass (even in different package)");
    }

    void defaultMethod() {
        System.out.println("Default Method: Accessible only within same package");
    }

    private void privateMethod() {
        System.out.println("Private Method: Accessible only within this class");
    }

    public void accessPrivateInsideClass() {
        privateMethod();
        System.out.println("Private method accessed inside Base class");
    }
}
