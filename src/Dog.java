// Display abstraction by extending pet class 


public class Dog extends Pet implements WalkMyPet {
    //set instance fields of a dog object
    private String breed;
    private boolean slobbers;
    private boolean playsCatch;
    private boolean wagsTail;
    

    /* set the constructor of the dog object
     * name, age, gender, bodyColor are inherited from the Pet class 
     * user super() to call the parent class Pet
     * subclass wants to invoke the parent class’s implementation of the method in addition to its own.
     */
    public Dog(String name, int age, String gender, String bodyColor, String breed, boolean slobbers, boolean playsCatch, boolean wagsTail ) {
        super(name, age, gender, bodyColor);
       
        this.breed = breed;
        this.slobbers = slobbers;
        this.playsCatch = playsCatch;
        this.wagsTail = wagsTail;
    }// open dog class



    //setter methods
    public String setBreed(){
        return breed;
    }

    public Boolean setSlobbers(){
        return slobbers;
    }

    public boolean setPlaysCatch(){
        return playsCatch;
    }

    public boolean setWagsTail(){
        return wagsTail;
    }



// override the walk method here later
@Override
public void walk(){// open walk()

    System.out.println("Walk the dog named " + super.name);

}// close walk()

//getters and setters added later



}// close dog class
