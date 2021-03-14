import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Superclass for classes Car and Motorbike. This is an abstract class which lays the template.
 * @author Mohamed Ashraf Ali
 */

public abstract class Vehicle
{
    private String name;
    private int velocity;
    private int maxSpeed; //Top speed of vehicle
    private int acceleration;
    private int durability;
    private int damage;

    public Vehicle(int durability, int acceleration)
    {
        this.name = "";
        this.durability = durability;
        this.acceleration = acceleration;
        this.damage = 0;
        this.velocity = 0;
        this.maxSpeed = 0;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }

    public int getMaxSpeed(){
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public void rand_maxSpeed(){
        int random_maxSpeed = new Random().nextInt(200) + 100;
        this.setMaxSpeed(random_maxSpeed);
    }

    public int getDurability(){
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }


    public int getAcceleration() {
        return acceleration;
    }

    public int getDamage(){
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void vehicleName(int i){
        setName("Vehicle"+i);
    }

    public int getVelocity(){
        return velocity;
    }

    public void velocity(int a, int s){
        //v2 = u2 - 2as
        velocity = (int)Math.sqrt((getVelocity()*getVelocity()+2*a*s));
    }

    public void velocityModifier(int change){
        velocity = velocity + change;
    }

    public void collision(Vehicle v){
        int momentumDiff = 0;
        if (v instanceof Car && this instanceof Car)
            momentumDiff = (this.velocity*((Car) this).getMass()) - (v.velocity*(((Car) v).getMass()));

        if(momentumDiff >0)
            v.damage += 1;
        else
            this.damage +=1;
    }


    public void overtake(ArrayList<Vehicle> swap, int i1, int i2){
        System.out.println(swap.get(i1).getName() +" has overtaken "+ swap.get(i2).getName()+ "!");
        Collections.swap(swap, i1, i2);
    }
}
