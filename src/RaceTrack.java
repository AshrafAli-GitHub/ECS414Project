import java.util.Random;

public class RaceTrack extends Track{
    private int pitStop;

    public RaceTrack(int laps, int corners, int pitStop){
        super(laps, corners);
        this.pitStop = pitStop;
    }

    public int lapLength() {
        Random random = new Random();
        int length = random.nextInt(501) + 500; //Creates a straight between 500-1000m.
        return length;
    }

    public int getPitStop() {
        return pitStop;
    }

    public void setPitStop(int pitStop) {
        this.pitStop = pitStop;
    }

    //After random number of laps, all vehicles are repaired.
    public int pitStopLap() {
        Random random = new Random();
        int r = (random.nextInt(getNoOfLaps())+1);
        return r;
    }
}
