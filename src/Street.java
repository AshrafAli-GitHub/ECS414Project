import java.util.Random;

public class Street extends Track{
    private int roadWidth; // Shorter width --> Increases chance of collisions

    public Street(int laps, int corners, int material){
        super(laps, corners, material);
        this.roadWidth = 10;
    }
    public int getRoadWidth(){
        return roadWidth;
    }

    public double lapLength() {
        Random random = new Random();
        double length = (random.nextInt(700) + 500) / 10.0;
        System.out.println("Random: " + length);
        return length;
    }


    public void collisionModifier(){

    }

}
