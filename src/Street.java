import java.util.Random;

public class Street extends Track{
    private int roadWidth; // Shorter width --> Increases chance of collisions

    public Street(int laps, int corners){
        super(laps, corners);
        setRoadWidth();
    }

    public int getRoadWidth(){
        return roadWidth;
    }

    public void setRoadWidth() {
        Random random = new Random();
        int rW = random.nextInt(14)+12;
        this.roadWidth = rW;
    }

    public int lapLength() {
        Random random = new Random();
        int length = random.nextInt(801) + 200; //Creates a straight between 200-1000m.
        return length;
    }

}
