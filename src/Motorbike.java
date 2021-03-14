import java.util.Random;

public class Motorbike extends Vehicle{
    private boolean hasFallen;

    public Motorbike(int durability, int acceleration){
        super(durability, acceleration);
        this.hasFallen = false;
    }

    @Override
    public void rand_maxSpeed(){
        int random_maxSpeed = new Random().nextInt(300) + 100;
        super.setMaxSpeed(random_maxSpeed);
    }

    public void vehicleName(int i){
        setName("Motorbike #"+i);
    }

    public boolean getHasFallen(){
        return hasFallen;
    }

    public void setHasFallen(boolean hasFallen) {
        this.hasFallen = hasFallen;
    }
}
