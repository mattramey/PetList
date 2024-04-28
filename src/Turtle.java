public class Turtle extends Pet implements WalkMyPet {// open Turtle class

// define instances of Turtle object
private String habitat;
private boolean needsWarmth;



 /* set the constructor of the Turtle object
     * name, age, gender, bodyColor are inherited from the Pet class 
     * user super() to call the parent class Pet
     * subclass wants to invoke the parent class’s implementation of the method in addition to its own.
     */
    public Turtle(String name, int age, String gender, String bodyColor, String habitat, boolean needsWarmth) {// open Turtle Constructor
        super(name, age, gender, bodyColor);

        this.habitat = habitat;
        this.needsWarmth = needsWarmth;
        
    }// close Turtle Constructor

//override method
@Override
public void walk(){
    System.out.println("The turtle named" + super.name + "swims.");
}


// setters and getters
public String setHabitat(){
    return habitat;
}

public boolean setNeedsWarmth(){
    return needsWarmth;
}

}// close Turtle class
