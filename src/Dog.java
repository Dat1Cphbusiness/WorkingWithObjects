public class Dog {
    
    private String name;
    private String breed;
    private int energy;
    
    public Dog(String name, String breed) {
        this.name = name;
        this.breed = breed;
        this.energy = 100;
    }
    
    public void bark() {
        System.out.println(name + " says: Woof woof!");
    }
    
    public void play() {
        energy -= 20;
        System.out.println(name + " is playing! Energy: " + energy);
    }
    
    public void sleep() {
        energy = 100;
        System.out.println(name + " is sleeping... Zzz... Energy restored to " + energy);
    }
    
    public void eat() {
        energy += 10;
        if (energy > 100) {
            energy = 100;
        }
        System.out.println(name + " is eating. Energy: " + energy);
    }
    
    public void showStatus() {
        System.out.println(name + " the " + breed + " - Energy: " + energy);
    }
}
