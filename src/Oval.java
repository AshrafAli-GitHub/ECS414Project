import java.util.Random;

public class Oval extends Track{
    private int heat;


    public Oval(int laps, int material) {
        super(laps, 0, material);
        heat = 0;
    }

    public int getHeat(){
        return heat;
    }

    public void setHeat(int heat){
        this.heat = heat;
    }



}
