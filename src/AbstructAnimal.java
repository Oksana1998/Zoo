/**
 * Created by Ксюша on 22.11.2017.
 */
public class AbstructAnimal implements Animal{

    public AbstructAnimal(){

    }

    public AbstructAnimal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public void say() {

    }

    @Override
    public String getAnimalClass() {
        return null;
    }

    @Override
    public void animalPicture() {

    }

    @Override
    public void animalInfo() {
        System.out.println("Символьная картинка ");
        animalPicture();
        System.out.println("как животное ходит в туалет " + goToToilet());
    }

    public String goToToilet() {
        return "=^-^= срунь срунь";
    }

    public String name;
    public int age;
    public static final int MIN_AGE = 0;


    @Override
    public void setName(String name) {

    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void setAge(int age) {

    }

    @Override
    public int getAge() {
        return 0;
    }


    public int getMaxAge() {
        return 0;
    }




    @Override
    public String toString() {
        return "имя животного = " + name  +
                "   возраст животного  = " + age +' ' + "  В туалете " + goToToilet() + "      Класс животного - " + getAnimalClass();
    }
}
