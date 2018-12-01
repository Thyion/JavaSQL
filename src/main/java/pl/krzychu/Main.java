package pl.krzychu;

import java.util.ArrayList;

public class Main {


    public static void main(String[] args) throws Exception {
        MySQLAccess dao = new MySQLAccess();
        dao.Connection();

        //dao.insertBook("Harry Potter", "J. K . Rowling", 2000);

        //dao.changeAuthor("W pustyni i w puszczy", "H. Sienkiewicz");
        ArrayList<Ksiazka> bookList = dao.getBooksToArray();
        System.out.println(bookList);

        ArrayList<Ksiazka> bookList2 = dao.getBook(2);
        System.out.println(bookList2);

        dao.Transakcje();

        dao.closeConnection();
    }

}