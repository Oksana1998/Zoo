/**
 * Created by Ксюша on 22.11.2017.
 */
public class Zoo {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    private String name;


    public Zoo(String name) {

        this.name = name;
    }

    private int zooSize;

    public Zoo(String name, int zooSize) {
        this.name = name;
        this.zooSize = zooSize;
    }

}
