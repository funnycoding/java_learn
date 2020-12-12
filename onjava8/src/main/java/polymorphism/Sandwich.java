package polymorphism;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/9 4:36 下午
 */

class Meal {
    public Meal() {
        System.out.println("Meal()");
    }
}

class Bread {
    public Bread() {
        System.out.println("Bread()");
    }
}

class Cheese {
    public Cheese() {
        System.out.println("Chesses()");
    }
}

class Lettuce {
    public Lettuce() {
        System.out.println("Lettuce()");
    }
}

class Lunch extends Meal {
    public Lunch() {
        System.out.println("Lunch()");
    }
}

class PortableLunch extends Lunch {
    public PortableLunch() {
        System.out.println("PortableLunch");
    }
}


public class Sandwich extends PortableLunch{
    private Bread bread = new Bread();
    private Cheese cheese = new Cheese();
    private Lettuce lettuce = new Lettuce();



    public Sandwich() {
        System.out.println("Sandwich()");
    }

    public static void main(String[] args) {
        Sandwich sandwich = new Sandwich();
    }
}
