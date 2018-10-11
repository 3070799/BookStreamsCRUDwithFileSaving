import java.util.ArrayList;

public class BookDAO {

    public static void create (String filePath, String nameBook, String autor, int yearPublication){
        ArrayList<Book> books = FileManager.readFromFile(filePath);
        Book tempBook = new Book(nameBook,autor,yearPublication);
        books.add(tempBook);
        FileManager.writeToFile(books,filePath);
    }

    public static ArrayList<Book> readByNameBook (String filePath, String nameBook){
        ArrayList<Book> tempBooks = FileManager.readFromFile(filePath);
        ArrayList<Book> readByNameBook = new ArrayList<>();
        for (Book book : tempBooks) {
            if(book.getNameBook().equalsIgnoreCase(nameBook)){
                readByNameBook.add(book);
            }
        }

        return readByNameBook;
    }

    public static ArrayList<Book> readByAutor (String filePath, String autor){
        ArrayList<Book> tempBooks = FileManager.readFromFile(filePath);
        ArrayList<Book> readByNameAutor = new ArrayList<>();
        for (Book book : tempBooks) {
            if(book.getAutor().equalsIgnoreCase(autor)){
                readByNameAutor.add(book);
            }
        }

        return readByNameAutor;
    }

    public static ArrayList<Book> readByNamePublication(String filePath, int yearPublication){
        ArrayList<Book> tempBooks = FileManager.readFromFile(filePath);
        ArrayList<Book> readByNameBook = new ArrayList<>();
        for (Book book : tempBooks) {
            if(book.getYearPublication() == yearPublication){
                readByNameBook.add(book);
            }
        }

        return readByNameBook;
    }

    public static void updateById(long id, String filePath, String nameBook, String autor, int yearPublication ){
        ArrayList<Book> tempBooks = FileManager.readFromFile(filePath);
        for (Book book : tempBooks) {
            if (book.getId() == id){
                book.setAutor(autor);
                book.setNameBook(nameBook);
                book.setYearPublication(yearPublication);
            }
        }
        FileManager.writeToFile(tempBooks,filePath);
    }

    public static void deliteById (String filePath, long id){
        ArrayList<Book> tempBooks = FileManager.readFromFile(filePath);
        for (Book book : tempBooks) {
            if(book.getId() == id){
                tempBooks.remove(book);
                break;
            }
        }
        FileManager.writeToFile(tempBooks,filePath);
    }
}
