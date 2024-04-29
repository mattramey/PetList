public class Bird extends Pet implements WalkMyPet{// open Bird class
// define instances of Bird object
    private String speciesType;
    private boolean talks;
    private int maxAltitude;

 /* set the constructor of the Bird object
     * name, age, gender, bodyColor are inherited from the Pet class 
     * user super() to call the parent class Pet
     * subclass wants to invoke the parent class’s implementation of the method in addition to its own.
     */
    public Bird(String name, int age, String gender, String bodyColor, String speciesType, boolean talks, int maxAltitude) {// open Bird constructor
        super(name, age, gender, bodyColor);
        this.speciesType = speciesType;
        this.talks = talks;
        this.maxAltitude = maxAltitude;
    }// close Bird constructor

// override method
public void walk(){
    System.out.println("The bird named " + super.name + " is going on a flight.");
}


//  setter methods

public String setSpeciesType(){
    return speciesType;
}

public boolean setTalks(){
    return talks;
}

public int setMaxAltitude(){
    return maxAltitude;
}


}// close Bird class
