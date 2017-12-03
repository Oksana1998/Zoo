/**
 * Created by Ксюша on 22.11.2017.
 */
public class Cat extends AbstructAnimal {


    public Cat(String name, int age) {
        super(name, age);
    }
    public  Cat(){

    }

    @Override
    public void say() {
        System.out.println("Мяу-мяу");
    }

    @Override
    public int getMaxAge() {
        return 17;
    }

    @Override
    public String getAnimalClass() {
        return "Кот";
    }
}
