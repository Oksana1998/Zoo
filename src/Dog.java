/**
 * Created by Ксюша on 22.11.2017.
 */
public class Dog extends AbstructAnimal {
    public Dog(String name, int age) {
        super(name, age);
    }
public  Dog(){

}
    @Override
    public void say() {
        System.out.println("Гав-гав");
    }

    @Override
    public String getAnimalClass() {
        return "Собака";
    }

    @Override
    public int getMaxAge() {
        return 20;
    }
}
