package pl.krzychu;

public class Main {

    private static Ksiazka book1;
    public static void main(String[] args) throws Exception {
        MySQLAccess dao = new MySQLAccess();
        dao.Connection();

        dao.insertBook("Harry Potter", "J. K . Rowling", 2000);

        dao.changeAuthor("W pustyni i w puszczy", "H. Sienkiewicz");
        dao.getBooks();

        book1 = dao.getBook( 1);

        dao.closeConnection();
        System.out.println(book1);

    }

}