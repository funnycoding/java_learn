package test;

import java.sql.Time;

public class OrdinaryMovie extends Movie{

    public OrdinaryMovie(String name, Time startTime, int runtime, double price, int ticketsLeft,int id) {
        super(name, startTime, runtime, price, ticketsLeft,id);
    }

    @Override
    public double purchase(int arg) {
        double number = 0;
        if (arg < ticketsLeft){
            number = arg * getPrice();
        }
        else {
            number = ticketsLeft * getPrice();
        }
        return number;
    }

    @Override
    public String toString(){
        return super.toString() + " OrdinaryMovie";
    }
}
