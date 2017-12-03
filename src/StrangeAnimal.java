import java.util.Random;

/**
 * Created by Ксюша on 22.11.2017.
 */

public class StrangeAnimal extends AbstructAnimal {

    Random rnd = new Random();



    private String[] possibleToilet= {"LLLLLLL", "КККХХХРРРФФФ",

            "ОООООООООО", "ЩЗЩЗЩЗЩЗЩЗЩЗ", "РГРГРГРГРГРГРГР"};



    public StrangeAnimal(String name, int age) {
        super(name, age);

    }


    @Override

    public String getAnimalClass() {

        return "Чупокабра";

    }


    @Override

    public String goToToilet() {

        return possibleToilet[rnd.nextInt(possibleToilet.length)];

    }


}
