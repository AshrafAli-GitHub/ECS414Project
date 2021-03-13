import java.util.Random;

public class Stock extends Car{
    public Stock(int durability, int braking, int acceleration) {
        super(durability, braking, acceleration, 1450);
    }

    @Override
    public void setMaxSpeed(int newMaxSpeed){
        int random_maxSpeed = new Random().nextInt(200) + 100;
        super.setMaxSpeed(random_maxSpeed);
    }
}
