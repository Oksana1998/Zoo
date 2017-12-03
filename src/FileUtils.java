import java.io.*;

/**
 * Created by Ксюша on 23.11.2017.
 */
public class FileUtils {


    public static String newRead (String fileName) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader(fileName));

        StringBuilder stringBuilder = new StringBuilder();

        String line = null;

        while ((line = reader.readLine()) != null) {

            stringBuilder.append(line);

            stringBuilder.append(" ");

        }

        stringBuilder.deleteCharAt(stringBuilder.length() - 1);

        reader.close();

        return stringBuilder.toString();

    }

    public static String read(String fileName) throws FileNotFoundException {

        //Этот спец. объект для построения строки

        StringBuilder sb = new StringBuilder();



        exists(fileName);



        try {

            //Объект для чтения файла в буфер

//            BufferedReader in = new BufferedReader(new FileReader( new File(fileName).getAbsoluteFile()));

            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream( new File(fileName)), "windows-1251"));

            try {

                //В цикле построчно считываем файл

                String s;

                while ((s = in.readLine()) != null) {

                    sb.append(s);

                    sb.append("\n");

                }

            } finally {

                //Также не забываем закрыть файл

                in.close();

            }

        } catch(IOException e) {

            throw new RuntimeException(e);

        }



        //Возвращаем полученный текст с файла

        return sb.toString();

    }



    public static void update(String nameFile, String newText) throws FileNotFoundException {

        exists(nameFile);

        StringBuilder sb = new StringBuilder();

        String oldFile = read(nameFile);

        sb.append(oldFile);

        sb.append(newText);

        write(nameFile, sb.toString());

    }



    private static void exists(String fileName) throws FileNotFoundException {

        File file = new File(fileName);

        if (!file.exists()){

            throw new FileNotFoundException(file.getName());

        }

    }



    public static void write(String fileName, String text) {

        //Определяем файл

        File file = new File(fileName);



        try {

            //проверяем, что если файл не существует то создаем его

            if(!file.exists()){

                file.createNewFile();

            }



            //PrintWriter обеспечит возможности записи в файл

            PrintWriter out = new PrintWriter(file.getAbsoluteFile());



            try {

                //Записываем текст у файл

                out.print(text);

            } finally {

                //После чего мы должны закрыть файл

                //Иначе файл не запишется

                out.close();

            }

        } catch(IOException e) {

            throw new RuntimeException(e);

        }

    }

}
