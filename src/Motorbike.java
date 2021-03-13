import java.util.Random;

public class Motorbike extends Vehicle{
    private boolean hasFallen;

    public Motorbike(int durability, int braking, int acceleration){
        super(durability, braking, acceleration);
        this.hasFallen = false;
    }

    @Override
    public void setMaxSpeed(int newMaxSpeed){
        int random_maxSpeed = new Random().nextInt(300) + 100;
        super.setMaxSpeed(random_maxSpeed);
    }

    public boolean getHasFallen(){
        return hasFallen;
    }

}
