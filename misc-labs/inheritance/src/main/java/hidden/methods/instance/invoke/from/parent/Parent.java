package hidden.methods.instance.invoke.from.parent;

class Parent {
    private void hiddenMethod() {
        System.out.println("Hello from hiddenMethod in Parent class");
    }

//  The output is:
//  Hello from hiddenMethod in Parent class
//  Hello from hiddenMethod in Child class
//  It shows that the invoked method depends on the type of the reference,
//  not on the type of the actual object.

    public static void main(String[] args) {
        Parent parent = new Child();
        Child child = new Child();
        parent.hiddenMethod();
        child.hiddenMethod();
    }
}

class Child extends Parent{
    public void hiddenMethod() {
        System.out.println("Hello from hiddenMethod in Child class");
    }
}
