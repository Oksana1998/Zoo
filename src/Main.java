import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Ксюша on 22.11.2017.
 */
public class Main {
    static ArrayList<Animal> animals = new ArrayList<Animal>();

    public static void main(String[] args) throws IOException, IllegalAccessException, InstantiationException {


        for (int i = 0; i < 4; i++) {
            System.out.println("Меню");
            System.out.println("1 - Увеличить зоопарк ");
            System.out.println("2 -  Смотреть животных ");
            System.out.println("3 - Добавить свой зоопарк");
            System.out.println("4 -  Прочитать файл");
            System.out.println("5 - Получить зоопарк  из файла");


            Scanner scan = new Scanner(System.in);
            int choose = scan.nextInt();

            switch (choose) {
                case 1:
                    AddAnimal();
                    break;
                case 2:
                    for (int j = 0; j < animals.size(); j++) {
                        System.out.println(animals.get(j));
                    }

                    break;

                case 3:
                    //OwnZoo();

                    System.out.println("Введите имя нового зоопарка");

                    Scanner scann = new Scanner(System.in);
                    String nameOfNewZoo = scann.nextLine();

                    Zoo ownZoo = new Zoo(nameOfNewZoo);
                    System.out.println("Имя нового зоопарка - " + nameOfNewZoo);

                    System.out.println("Введите размер зоопарка");
                    int sizeOfNewZoo = scann.nextInt();

                    NewZoo(nameOfNewZoo, sizeOfNewZoo);
                    break;
                case 4:
                    String fileName = "src/zooText";
                    String textFromFile = FileUtils.read(fileName);
                    System.out.println(textFromFile);

                    break;
                case 5:
                    createZooFromFile();
                    break;
                default:
                    System.out.println("Неверная оценка");
            }
        }
    }


    public static void AddAnimal() {

        System.out.println("Какое животное вы хотите добавить ");
        System.out.println("1 - КОТ");
        System.out.println("2 - СОБАКА");
        Scanner scanner = new Scanner(System.in);
        int animalNumber = scanner.nextInt();


        switch (animalNumber) {
            case 1:

                System.out.println("Введите имя кота");
                Scanner scan = new Scanner(System.in);
                String catName = scan.nextLine();
                System.out.println("Введите возраст кота");
                boolean flag = true;
                while (flag) {
                    int catAge = scan.nextInt();

                    if (catAge < AbstructAnimal.MIN_AGE) {

                        System.out.println("Извините, возраст указан неправильно, повторите попытку ");

                        flag = true;
                    } else {

                        animals.add(new Cat(catName, catAge));

                        flag = false;
                    }

                    break;
                }
                break;

            case 2:
                System.out.println("Введите имя собаки");
                Scanner scanner1 = new Scanner(System.in);
                String dogName = scanner1.nextLine();
                System.out.println("Введите возраст собаки");

                boolean flag2 = true;
                while (flag2) {

                    int dogAge = scanner1.nextInt();

                    if (dogAge < AbstructAnimal.MIN_AGE || dogAge > 20) {
                        System.out.println("Извините, возраст указан неправильно, повторите попытку ");
                       flag2 = true;

                    } else {


                        animals.add(new Dog(dogName, dogAge));
                        flag2 = false;
                    }
                    break;
                }

break;
        }
    }

    public static Animal genetate() {

        Random rnd = new Random();
        String[] names = {"Кузя", "Котопес", "Свинка", "Зебра", "Алька", "Шарик", "Пушистик", "Степа", "Кузька"};
        int[] rndAGe = {1, 7, 8, 4, 2, 4, 4, 14, 15, 16, 20, 2, 3, 7, 9, 10, 11};

        int itemAge = (int) (Math.random() * rndAGe.length);
        int itemName = (int) (Math.random() * names.length);


        Animal[] instance = {
                new Cat(names[itemName], rndAGe[itemAge]), new Dog(names[itemName], rndAGe[itemAge])
        };
        int itemRand = (int) (Math.random() * instance.length);
        Animal randomAnimal = instance[itemRand];
        return randomAnimal;


    }

    public static void NewZoo(String name, int zooSize) {


        ArrayList<Animal> NewAnimals = new ArrayList<Animal>(zooSize);

        for (int i = 0; i < zooSize; i++) {
            if (i / 10 == 1) {

                String[] possibleNames = {"Чупа", "Алеша", "Кузька", "Оно", "Неопознанное"};
                int[] possibleAges = {1, 6, 7, 8, 9, 4, 5, 10, 56, 100, 23};
                int pAge = (int) (Math.random() * possibleAges.length);
                int psName = (int) (Math.random() * possibleNames.length);

                NewAnimals.add(new StrangeAnimal(possibleNames[psName], possibleAges[pAge]));
            } else {
                NewAnimals.add(genetate());


            }
            System.out.println(NewAnimals.get(i));
        }
    }

    public static void createZooFromFile() throws IOException, InstantiationException, IllegalAccessException {
        ArrayList<Animal> animalFromFile = new ArrayList<Animal>();
        String fileName = "src/zooText";

        String s = FileUtils.newRead(fileName);

        Zoo zoo = new Zoo(s.split(" ")[0]);

        System.out.println("Имя зоопарка " + s.split("  ")[0]);

        // String a = s.split("  ")[1];
        // String[] test = a.split(" ");
        String b = s.split("  ")[2];
        String[] test2 = b.split(" ");
        for (int i = 1; i < 3; i++) {

            String[] test = new String[0];
            String a = s.split("  ")[i];
            test = a.split(" ");

            if (test[0].equals("Кот")) {
                animalFromFile.add(new Cat(test[1], Integer.parseInt(test[2])));
            } else if (test[0].equals("Собака")) {
                animalFromFile.add(new Dog(test[1], Integer.parseInt(test[2])));

            }

            for (int k = 0; k < animalFromFile.size(); k++) {
                System.out.println(animalFromFile.get(k));

            }
        }
    }
}
