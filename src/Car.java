public abstract class Car extends Vehicle
{
    private int mass;

    public Car(int durability, int acceleration, int mass) {
        super(durability, acceleration);
        this.mass = mass;
    }

    public int getMass(){
        return mass;
    }

    public void vehicleName(int i){
        setName("Stock Car #"+i);
    }
}

