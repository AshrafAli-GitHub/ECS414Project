import java.util.Random;

public class F1 extends Car{
    private int ERS;

    public F1(int durability, int braking, int acceleration) {
        super(durability, braking, acceleration, 740);
        ERS = 1;

    }

    @Override
    public void setMaxSpeed(int newMaxSpeed){
        int random_maxSpeed = new Random().nextInt(250) + 180;
        super.setMaxSpeed(random_maxSpeed);
    }

    public int getERS(){
        return ERS;
    }

    public void useERS(){
        if(ERS==1){
            velocityModifier((int)0.1*getVelocity());
        }
    }
}
