import java.util.UUID;

public class Main {
    public static void main(String[] args) {

        while (BooksMenu.exitTheProgramm == false){
            BooksMenu.mainMenu();
            BooksMenu.router(FileManager.filePath);
        }

    }
}
