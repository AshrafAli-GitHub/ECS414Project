public class Oval extends Track{
    private int heat;


    public Oval(int laps) {
        super(laps, 0);
        heat = 0;
    }

    public void setHeat(int heat){
        this.heat = heat;
    }

    public void heatModifier(){
        if(heat > 5){
            super.getLap().remove(getLap().size()-1);
        }
    }

}
