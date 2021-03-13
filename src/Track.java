import java.util.ArrayList;
import java.util.Random;

public class Track
{
    // instance variables - replace the example below with your own
    private int noOfLaps;
    private int corners;
    private int material;
    private ArrayList lap;
    private double length;


    public Track(int laps, int corners, int material)
    {
        // initialise instance variables
        this.noOfLaps = laps;
        this.corners = corners;
        this.material = material;
        this.lap = new ArrayList();
    }

    public int getNoOfLaps(){
        return noOfLaps;
    }

    public ArrayList getLap(){
        return lap;
    }

    public double getLength(){
        return length;
    }

    public void setLength(double nLength){
        length = nLength;
    }

    public int getCorners(){
        return corners;
    }

    public int getMaterial(){
        return material;
    }



    public void VehicleEffect(Vehicle v){
        int speedModifier = getMaterial()/10;
        v.setMaxSpeed(v.getMaxSpeed() + v.getMaxSpeed()*speedModifier);
    }

    public double lapLength(){
        Random random = new Random();
        double straightLength = (random.nextInt(31)+1)/10.0;
        System.out.println("Random: " + length);
        return length;
    }

    public void createLap(double length){
        getLap().add(length);
    }

}

