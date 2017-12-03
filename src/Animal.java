/**
 * Created by Ксюша on 22.11.2017.
 */
public interface Animal {
    public void say();
    public String getAnimalClass();

    public void animalPicture();
    public void animalInfo();
    void setName(String name);

    String getName();

    void setAge(int age);

    int getAge();


    int getMaxAge();
}
