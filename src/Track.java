import java.util.ArrayList;
import java.util.Random;

public class Track
{
    private int noOfLaps;
    private int corners;
    private ArrayList lap;
    private int length;


    public Track(int laps, int corners)
    {
        this.noOfLaps = laps;
        this.corners = corners;
        this.lap = new ArrayList();
    }

    public int getNoOfLaps(){
        return noOfLaps;
    }

    public ArrayList getLap(){
        return lap;
    }

    public int getLength(){
        return length;
    }

    public void setLength(int nLength){
        length = nLength;
    }

    public int getCorners(){
        return corners;
    }

    public int lapLength(){
        Random random = new Random();
        int straightLength = (random.nextInt(101)+300); //Track length is between 300-400m.
        return straightLength;
    }

    public void createLap(int length){
        getLap().add(length);
    }


}

