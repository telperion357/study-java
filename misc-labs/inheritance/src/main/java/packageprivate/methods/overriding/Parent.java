package packageprivate.methods.overriding;

class Parent {
    void hiddenMethod() {
        System.out.println("Hello from hiddenMethod in Parent class");
    }

//  The output is:
//  Hello from hiddenMethod in Child class
//  Hello from hiddenMethod in Child class
//  It shows that the package-private method is overridden
//  in the subclass from the same package.

    public static void main(String[] args) {
        Parent parent = new Child();
        Child child = new Child();
        parent.hiddenMethod();
        child.hiddenMethod();
    }
}

class Child extends Parent {

    @Override
    public void hiddenMethod() {
        System.out.println("Hello from hiddenMethod in Child class");
    }
}
