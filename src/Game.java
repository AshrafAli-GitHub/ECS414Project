import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Game {
    public static void main(String[] args) {
        Track track = createTrack();
        ArrayList<Vehicle> grid = createVehicles();
        race(grid, track);
    }

    /**
     * Asks the user for input for track details and then calls the appropriate class constructor.
     */
    public static Track createTrack(){
        Track t;

        System.out.println("Choose Circuit type: ");
        System.out.println("1. Street");
        System.out.println("2. Oval");
        System.out.println("3. Race Track");
        int circuit = readInt();

        System.out.println("How many laps? ");
        int laps = readInt();

        System.out.println("How many corners? ");
        int corners = readInt();

        if(circuit==1)
            t = createStreet(laps, corners);
        else if (circuit==2)
            t = createOval(laps);
        else
            t = createRaceTrack(laps, corners);

        return t;
    }

    /**
     * Creates vehicle objects based on user input.
     */
    public static ArrayList createVehicles(){
        System.out.println("Choose the vehicles: ");
        System.out.println("1. F1");
        System.out.println("2. Stock Car");
        System.out.println("3. Motorcycle");
        System.out.println("4. Random");
        int vehicleType = readInt();

        System.out.println("How many vehicles? ");
        int noOfVehcs = readInt();

        ArrayList<Vehicle> startGrid = createGrid(vehicleType, noOfVehcs);

        System.out.println();
        System.out.println("-----START GRID-----");
        System.out.println();
        for(Vehicle v:startGrid){
            System.out.println(v.getName());
        }
        System.out.println();

        return startGrid;
    }

    public static Track createStreet(int laps, int corners){
        Street t = new Street(laps, corners);

        for(int i = 0; i < t.getCorners(); i++){
            t.setLength(t.lapLength());
            t.createLap(t.getLength());
        }

        t.setRoadWidth();

        ArrayList oneLap = (ArrayList) t.getLap().clone();
        for(int lap = 1; lap < t.getNoOfLaps(); lap++ ){
            t.getLap().addAll(oneLap);
        }

        return t;
    }

    public static Track createOval(int laps){
        Oval t = new Oval(laps);
        t.setHeat(randInt(1,8));
        t.setLength(t.lapLength());
        t.heatModifier();
        t.setHeat(0);

        for(int lap = 1; lap<=t.getNoOfLaps(); lap++){
            t.createLap(t.getLength());
        }

        return t;
    }

    public static Track createRaceTrack(int laps, int corners){
        Track t = new RaceTrack(laps, corners,0);

        int pitStop = ((RaceTrack) t).pitStopLap();
        ((RaceTrack) t).setPitStop(pitStop);

        for(int i = 0; i < t.getCorners(); i++){
            t.setLength(t.lapLength());
            t.createLap(t.getLength());
        }

        ArrayList oneLap = (ArrayList) t.getLap().clone();
        for(int lap = 1; lap < t.getNoOfLaps(); lap++ ){
            t.getLap().addAll(oneLap);
        }

        return t;
    }

    // Puts all the vehicles into an ArrayList.
    public static ArrayList createGrid(int type, int numberOfVehs){
        ArrayList<Vehicle> grid = new ArrayList<Vehicle>();
        for(int i=1; i<=numberOfVehs; i++){
            if(type==1){
                Vehicle v = new F1(randInt(3,5), randInt(8,10), 3);
                ((F1)v).rand_maxSpeed();
                grid.add(v);
                v.vehicleName(i);
            }
            else if(type==2){
                Vehicle v = new Stock(randInt(8,10), 1);
                ((Car) v).rand_maxSpeed();
                ((Stock)v).ProtectionModifier();
                if(((Stock) v).isProtection()){
                    v.setDurability(v.getDurability()+2);
                }
                grid.add(v);
                v.vehicleName(i);
            }
            else if(type==3){
                Vehicle v = new Motorbike(randInt(1,3), 2);
                ((Motorbike) v).rand_maxSpeed();
                grid.add(v);
                v.vehicleName(i);

            }
            else {
                int prob = randInt(1,9);
                if(prob<3){
                    Vehicle v = new F1(randInt(3,5), randInt(8,10), 3);
                    ((F1) v).rand_maxSpeed();
                    grid.add(v);
                    v.vehicleName(i);
                }
                else if(prob<6){
                    Vehicle v = new Stock(randInt(8,10), 1);
                    ((Stock) v).rand_maxSpeed();
                    grid.add(v);
                    v.vehicleName(i);
                }
                else{
                    Vehicle v = new Motorbike(randInt(1,3), 2);
                    ((Motorbike) v).rand_maxSpeed();
                    grid.add(v);
                    v.vehicleName(i);
                }
            }
        }
        return grid;
    }

    // The method which simulates the race.
    public static void race(ArrayList<Vehicle> grid, Track t){
        ArrayList<Vehicle> dnf = new ArrayList<Vehicle>();
        ArrayList<Integer> straight = t.getLap();

        int width = 10;

        for(int i=0; i < straight.size(); i++){
            int currentStraight = straight.get(i);

            for(int vehicle = 0; vehicle<grid.size(); vehicle++){
                Vehicle v = grid.get(vehicle);

                v.velocity(v.getAcceleration(),currentStraight);

                if(t instanceof Street){
                    width = ((Street) t).getRoadWidth();
                }

                if(t instanceof RaceTrack && ((RaceTrack) t).getPitStop() == i){
                    v.setDamage(0);
                }

                if (v.getVelocity() < v.getMaxSpeed()){
                    if(v instanceof F1 && vehicle > grid.size()/3  && ((F1) v).getERS()==1) {
                        ((F1) v).useERS();
                        System.out.println(v.getName() +" used ERS.");
                        ((F1) v).setERS(0);
                    }
                    if(v instanceof Motorbike) {
                        int rand_fall = randInt(1,5);
                        if (v.getVelocity() > (v.getMaxSpeed()-(0.1*v.getMaxSpeed())) && rand_fall==1)
                        if (rand_fall > v.getMaxSpeed() - 10)
                            ((Motorbike) v).setHasFallen(true);
                        if (((Motorbike) v).getHasFallen()) {
                            System.out.println(v.getName() + " has fallen and is out of the race!");
                            dnf.add(v);
                            grid.remove(v);
                        }
                    }

                    // Call collision method as long as the vehicle is not in first place.
                    if(grid.indexOf(v)>0 && randInt(width,100)<15){
                        if(v.getVelocity()>(v.getMaxSpeed()-100)){
                            v.collision(grid.get(vehicle-1));
                            System.out.println("There has been a collision between " + v.getName() + " and " + grid.get((vehicle-1)).getName() + "!");
                        }
                    }

                    if(v.getDamage() >= v.getDurability()) {
                        dnf.add(v);
                        grid.remove(v);
                    }

                    // Call overtake method as long as the vehicle is not in first place.
                    if(grid.indexOf(v) >0){
                        if(v.getVelocity() > grid.get(vehicle-1).getVelocity() && randInt(1,10)==1)
                            v.overtake(grid, vehicle-1, vehicle);
                    }
                }
                else
                    v.setVelocity(v.getVelocity()-v.getMaxSpeed());
            }
        }

        System.out.println();
        System.out.println();
        System.out.println("-----FINAL GRID-----");
        int pos =1;
        for(Vehicle v:grid){
            System.out.println(pos+": "+v.getName());
            pos = pos+1;
        }
        System.out.println();
        System.out.println();
        System.out.println(" ---DNFs--- ");
        for(Vehicle v: dnf){
            System.out.println("DNF: " + v.getName());
        }
    }


    public static int readInt(){
     Scanner scanner = new Scanner(System.in);
     return scanner.nextInt();
    }

    public static int randInt(int lb, int ub){
        Random random = new Random();
        int r = (random.nextInt(ub-lb+1)+lb);
        return r;
    }
}