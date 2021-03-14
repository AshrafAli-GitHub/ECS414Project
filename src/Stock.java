import java.util.Random;

public class Stock extends Car{
    private boolean protection;

    public Stock(int durability, int acceleration) {
        super(durability, acceleration, 1450);
        protection = false;
    }

    public void ProtectionModifier() {
        Random random = new Random();
        int r = (random.nextInt(2));
        if(r==1){
            protection = true;
        }
    }

    public boolean isProtection() {
        return protection;
    }
}
