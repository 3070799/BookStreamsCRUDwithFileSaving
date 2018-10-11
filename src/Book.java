import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

public class Book implements Serializable {

    private long id = lastBookId() + 1;
    private String nameBook;
    private String autor;
    private int yearPublication;

    public Book(String nameBook, String autor, int yearPublication) {
        this.nameBook = nameBook;
        this.autor = autor;
        this.yearPublication = yearPublication;
    }

    public Book() {
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setYearPublication(int yearPublication) {
        this.yearPublication = yearPublication;
    }

    public long getId() {
        return id;
    }

    public String getNameBook() {
        return nameBook;
    }

    public String getAutor() {
        return autor;
    }

    public int getYearPublication() {
        return yearPublication;
    }

    @Override
    public String toString() {
        return  "id книги - " + id + "\n" +
                "Название книги - " + nameBook + "\n" +
                "Автор книги - " + autor + "\n" +
                "Год публикации - " + yearPublication + "\n" +
                "----------------------------------------------------- \n";
    }
    private long lastBookId(){
        ArrayList<Book> books = FileManager.readFromFile(FileManager.filePath);
        long max = 0;
        for (Book book : books) {
            if(book.getId()>max){
                max = book.getId();
            }
        }
        return max;
    }
}
