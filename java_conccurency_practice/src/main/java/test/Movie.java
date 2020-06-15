package test;

import java.sql.Time;

public abstract class Movie {
    //Must declare first six fields
    private int id;
    private String name;
    private Time startTime;
    private int runtime;
    private double price;
    protected int ticketsLeft;
    private int type;
    private String typeName;


    public Movie(String name,Time startTime,int runtime,double price,int ticketsLeft,int id){
        this.id = id;
        this.name = name;
        this.startTime = startTime;
        this.runtime = runtime;
        this.price = price;
        this.ticketsLeft = ticketsLeft;
    }



    //You can add other fields that you think are necessary.

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public abstract double purchase(int arg);

    public void setTicketsLeft(int ticketsLeft) {
        this.ticketsLeft = ticketsLeft;
    }

    public int getTicketsLeft() {
        return ticketsLeft;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return
                "id=" + id + ", name='" + name +
                        "', startTime:" + startTime +
                        ", runtime=" + runtime +
                        ", price=" + price +
                        ", ticketsLeft=" + ticketsLeft;
    }
}
