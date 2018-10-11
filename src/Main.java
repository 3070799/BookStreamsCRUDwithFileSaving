import java.util.UUID;

public class Main {
    public static void main(String[] args) {

        while (true){
            BooksMenu.mainMenu();
            BooksMenu.router(FileManager.filePath);
        }

    }
}
