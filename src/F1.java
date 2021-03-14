import java.util.Random;

public class F1 extends Car{
    private int ERS;

    public F1(int durability, int braking, int acceleration) {
        super(durability, acceleration, 740);
        ERS = 1;

    }

    public void vehicleName(int i){
        setName("F1 #"+i);
    }


    public void rand_maxSpeed(){
        int random_maxSpeed = new Random().nextInt(250) + 180;
        super.setMaxSpeed(random_maxSpeed);
    }

    public int getERS(){
        return ERS;
    }

    public void useERS(){
            velocityModifier(10*getVelocity());
        }

    public void setERS(int ERS) {
        this.ERS = ERS;
    }
}
