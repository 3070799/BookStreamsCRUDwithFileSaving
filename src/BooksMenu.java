import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class BooksMenu {
    static SimpleDateFormat format = new SimpleDateFormat("yyyy");

    public static void mainMenu (){
        System.out.println("ГЛАВНОЕ МЕНЮ \n" +
                "1 - добавить книгу \n" +
                "2 - найти книгу \n" +
                "3 - обновить информацию о книге \n" +
                "4 - удалить книгу \n" +
                "5 - посмотреть все книги \n" +
                "6 - закрыть приложение");
    }

    public static void router (String filePath){
        String command = readConsoleValuve();
        if (command.equalsIgnoreCase("1")){
            createMenu(filePath);
        }else if(command.equalsIgnoreCase("2")){
            for (Book book : readMenu(filePath)) {
                System.out.println(book.toString());
            }
        }else if(command.equalsIgnoreCase("3")){
            updateMenu(filePath);
        }else if(command.equalsIgnoreCase("4")) {
            System.out.println("Введите id книги которую хотите удалить: ");
            BookDAO.deliteById(filePath, Integer.parseInt(readConsoleValuve()));
        }else if(command.equalsIgnoreCase("5")){
            for (Book book : FileManager.readFromFile(filePath)) {
                System.out.println(book.toString());
            }
        }else if(command.equalsIgnoreCase("6")){
            System.exit(0);
        }else {
            System.out.println("Вы ввели непрвельную команду, повторите ввод");
            mainMenu();
        }
    }

    private static void createMenu(String filePath){
        String nameBook;
        String autor;
        int yearPublication;
        System.out.println("Заполните данные о книге \n" +
                "Автор книги: ");
        autor = readConsoleValuve();
        System.out.println("Название книги: ");
        nameBook = readConsoleValuve();
        System.out.println("Год публикации книги: ");
        try {
            BookDAO.create(filePath,nameBook,autor,format.parse(readConsoleValuve()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private static ArrayList<Book> readMenu(String filePath){
        System.out.println("По какому критерию вы хотите искать книги? \n" +
                "1 - поиск по названию книги \n" +
                "2 - поиск по автору \n" +
                "3 - поиск по году издания");
        String command = readConsoleValuve();
        if(command.equalsIgnoreCase("1")){
            System.out.println("Введите название книги: ");
            return BookDAO.readByNameBook(filePath, readConsoleValuve());
        }else if(command.equalsIgnoreCase("2")){
            System.out.println("Введите автора: ");
            return BookDAO.readByAutor(filePath,readConsoleValuve());
        }else if(command.equalsIgnoreCase("3")){
            System.out.println("Введите год издания: ");

            try {
                return BookDAO.readByYearPublication(filePath,format.parse(readConsoleValuve()));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("Вы не правильно ввели значение, повторите еще раз");
            readMenu(filePath);
        }
        return null;
    }
    private static void updateMenu(String filePath){
        long id;
        String nameBook;
        String autor;
        int yearPublication;
        System.out.println("Введите id книги по которой хотите обновить информацию: ");
        id = Integer.parseInt(readConsoleValuve());
        System.out.println("Введите нового автор книги: ");
        autor = readConsoleValuve();
        System.out.println("Введите новое название книги: ");
        nameBook = readConsoleValuve();
        System.out.println("Введите новый год издания книги: ");
        try {
            BookDAO.updateById(id,filePath,nameBook,autor,format.parse(readConsoleValuve()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    public static String readConsoleValuve(){
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
}
