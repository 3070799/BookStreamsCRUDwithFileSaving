import java.io.*;
import java.util.ArrayList;

public class FileManager {
    static String filePath = "books.txt";
    public static ArrayList<Book> readFromFile(String filePath){
        ArrayList<Book> tempBooks = new ArrayList<>();

        try {
            FileInputStream fis = new FileInputStream(filePath);
            ObjectInputStream in = new ObjectInputStream(fis);
            tempBooks = (ArrayList<Book>) in.readObject();
            in.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        return tempBooks;
    }

    public static void writeToFile (ArrayList<Book> books, String filePath) {

        try {
            FileOutputStream fos = new FileOutputStream(filePath);
            ObjectOutputStream out = new ObjectOutputStream(fos);
            out.writeObject(books);
            fos.flush();
            out.flush();
            out.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
