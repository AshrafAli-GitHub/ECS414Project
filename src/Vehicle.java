import java.lang.module.ModuleReader;

/**
 Write a description of class Vehicle here.
 @Mohamed Ashraf Ali
 */

public abstract class Vehicle
{
    private String name;
    private int velocity;
    private int maxSpeed; //Top speed of vehicle
    private int acceleration;
    private int durability; // Wear rate
    private int braking; //Ability to slow down
    private int damage;

    /**
     * Create 2 array lists: Finished, DNFs
     */
    public Vehicle(){
        maxSpeed = 0;
        durability = 0;
        braking = 0;
        acceleration = 0;
        damage = 0;
        velocity = 0;
    }
    public Vehicle(int durability, int braking, int acceleration)
    {
        this.name = "";
        this.durability = durability;
        this.braking = braking;
        this.acceleration = acceleration;
        this.damage = 0;
        this.velocity = 0;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getMaxSpeed(){
        return maxSpeed;
    }

    public int getDurability(){
        return durability;
    }

    public int getBraking(){
        return braking;
    }

    public int getAcceleration() {
        return acceleration;
    }

    public int getDamage(){
        return damage;
    }

    public int getVelocity(){
        return velocity;
    }

    public void setMaxSpeed(int newMaxSpeed){
        maxSpeed = newMaxSpeed;
    }

    public void velocity(){
        //v2 = u2 - 2as
        // velocity = (velocity*velocity) + 2*acceleration*T.
    }

    public void velocityModifier(int change){
        velocity = velocity + change;
    }

    public void collision(Vehicle v){
        int momentumDiff = 0;
        if (v instanceof Car && this instanceof Car)
            momentumDiff = (this.velocity*((Car) this).getMass()) - (v.velocity*(((Car) v).getMass()));

        if(momentumDiff >0)
            v.damage += 10;
        else
            this.damage +=10;

    }

}
