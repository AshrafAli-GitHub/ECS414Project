import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Game {
    public static void main(String[] args) {
        createTrack();
        createVehicles();
    }

    public static void createTrack(){
        System.out.println("Choose Circuit type: ");
        System.out.println("1. Street");
        System.out.println("2. Oval");
        System.out.println("3. Race Track");
        int circuit = readInt();

        System.out.println("How many laps? ");
        int laps = readInt();

        System.out.println("How many corners? ");
        int corners = readInt();

        System.out.println("What is the quality of the material. (-5 to 5)? ");
        int material = readInt();

        if(circuit==1)
            createStreet(laps, corners, material);
        else if (circuit==2)
            createOval(laps, material);
        else
            createRaceTrack(laps, corners, material);
    }

    public static void createVehicles(){
        System.out.println("Choose the vehicles: ");
        System.out.println("1. F1");
        System.out.println("2. Stock Car");
        System.out.println("3. Motorcycle");
        System.out.println("4. Random");
        int vehicleType = readInt();

        System.out.println("How many vehicles? ");
        int noOfVehcs = readInt();

        ArrayList<Vehicle> startGrid = createGrid(vehicleType, noOfVehcs);
        for(Vehicle v:startGrid){
            System.out.println(v.getName());
        }
    }

    public static void createStreet(int laps, int corners, int material){
        Street t = new Street(laps, corners, material);
        t.setLength(t.lapLength());

        for(int lap = 1; lap<=t.getNoOfLaps(); lap++){
            t.createLap(t.getLength());
        }
        /**
         * Change loop for corners. Create the same amount of arraylists as laps. Combine them.
         */

        System.out.println(t.getLap());
    }

    public static void createOval(int laps, int material){
        Oval t = new Oval(laps, material);
        t.setLength(t.lapLength());

        for(int lap = 1; lap<=t.getNoOfLaps(); lap++){
            t.createLap(t.getLength());
        }
        System.out.println(t.getLap());
    }

    public static void createRaceTrack(int laps, int corners, int material){
        Track t = new RaceTrack(laps, corners, material);
    }

    public static ArrayList createGrid(int type, int numberOfVehs){
        ArrayList<Vehicle> grid = new ArrayList<Vehicle>();
        for(int i=1; i<=numberOfVehs; i++){
            if(type==1){
                Vehicle v = new F1(randInt(3,5), randInt(8,10), 3);
                grid.add(v);
                v.setName(type + " #" + i);
            }
            else if(type==2){
                Vehicle v = new Stock(randInt(8,10), randInt(5,7), 2);
                grid.add(v);
                v.setName(type + " #" + i);
            }
            else if(type==3){
                Vehicle v = new Motorbike(randInt(8,10), randInt(5,7), 2);
                grid.add(v);
                v.setName(type + " #" + i);

            }
            else {
                int prob = randInt(1,9);
                if(prob<3){
                    Vehicle v = new F1(randInt(3,5), randInt(8,10), 3);
                    grid.add(v);
                    vehicleName(v, i);
                }
                else if(prob<6){
                    Vehicle v = new Stock(randInt(8,10), randInt(5,7), 2);
                    grid.add(v);
                    vehicleName(v, i);
                }
                else{
                    Vehicle v = new Motorbike(randInt(8,10), randInt(5,7), 2);
                    grid.add(v);
                    vehicleName(v, i);
                }
            }
        }
        return grid;
    }

    public static void vehicleName(Vehicle v, int i){
        if (v instanceof F1)
            v.setName("F1 #"+i);
        else if (v instanceof Stock)
            v.setName("Stock #"+i);
        else if (v instanceof Motorbike)
            v.setName("Motorbike #"+i);
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