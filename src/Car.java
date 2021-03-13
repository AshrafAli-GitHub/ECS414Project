public abstract class Car extends Vehicle
{
    private int mass;

    public Car(int durability, int braking, int acceleration, int mass) {
        super(durability, braking, acceleration);
        this.mass = mass;
    }

    public int getMass(){
        return mass;
    }

    public void steering(){

    }
}

