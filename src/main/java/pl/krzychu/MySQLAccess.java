package pl.krzychu;

import java.sql.*;


// http://edu.pjwstk.edu.pl/wyklady/mpr/scb/W7/W7.htm /// cos o bazach danych

public class MySQLAccess {
    private Connection conn = null;
    private Statement st = null;
    private DatabaseMetaData md;// Uzyskiwanie metainformacji o bazie danych
    private ResultSet rs = null;


    private String myDriver = "com.mysql.jdbc.Driver";
    private String myUrl = "jdbc:mysql://localhost/java";

    public void Connection() throws Exception {

//      Sterowniki spełniające specyfikację JDBC 4.0 (jeśli odpowiednie JARy spełniają protokól Service Provider) mogą być odnajdywane bez jawnego załadowania klasy.
//                Np. jeśli nasza aplikacja ma dostęp do pliku derby.jar (jest na ścieżce dostępu klas), to uzyskać połaczenie możemy  prościej:
//
//            Connection con = DriverManager.getConnection("jdbc:derby:ksidb");

//        String driverName = "org.apache.derby.jdbc.ClientDriver";
//        String url = "jdbc:derby://localhost/ksidb";
//
//
//        Class.forName(driverName).newInstance();
//        Connection con = DriverManager.getConnection(url);


        try
        {

            Class.forName(myDriver);

            conn = DriverManager.getConnection(myUrl, "root", "");
            md = conn.getMetaData(); // Uzyskiwanie metainformacji o bazie danych
            System.out.println(md.getUserName());// Uzyskiwanie metainformacji o bazie danych
        }
        catch (Exception e)
        {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }

    }

    public void insertBook(String name, String author, int anno) {

        String query = "INSERT INTO `Ksiazki`(`Nazwa`, `Autor`, `Rok`) VALUES ('"+name+"','"+author+"','"+anno+"')";

        try {

            // create the java statement
            st = conn.createStatement();

            // execute the query, and get a java resultset

            st.executeUpdate(query);


        }catch (SQLException ex){
            System.err.println("Got an exception! ");
            System.err.println(ex.getMessage());
        }
    }

    public void closeConnection() {
        try{
            conn.close();
        }catch (SQLException ex){
            ex.getMessage();
        }

    }

    public void getBooks() {
        // our SQL SELECT query.
        // if you only need a few columns, specify them by name instead of using "*"
        String query = "SELECT * FROM Ksiazki";
        try {
            // create the java statement
            st = conn.createStatement();

            // execute the query, and get a java resultset
            rs = st.executeQuery(query);

            // iterate through the java resultset
            while (rs.next()) {
                int id = rs.getInt("Id");
                String name = rs.getString("Nazwa");
                String author = rs.getString("Autor");
                Integer anno = rs.getInt("Rok");

                // print the results
                System.out.format("%s, %s, %s, %s\n", id, name, author, anno);

            }
        } catch (SQLException ex){
            ex.getMessage();
        }

    }


    public Ksiazka getBook(int id){
        String query = "SELECT Nazwa, Autor, Rok FROM Ksiazki WHERE Id="+id;
        Ksiazka book = new Ksiazka();


        try {
            // create the java statement
            st = conn.createStatement();

            // execute the query, and get a java resultset
            rs = st.executeQuery(query);
                String name, author;
                int anno;
                name = (rs.getString("Nazwa"));
                author = (rs.getString("Autor"));
                anno = (rs.getInt("Rok"));
                book.setAuthor(author);
                book.setTitle(name);
                book.setAnno(anno);
        } catch (SQLException ex){
            ex.getMessage();
        }
        return book;
    }






    public void changeAuthor(String name, String author){
        String query = "UPDATE `Ksiazki` SET Autor='"+author+"' WHERE Nazwa='"+name+"'";
        try {
            // create the java statement
            st = conn.createStatement();
            // execute the query, and get a java resultset
            st.executeUpdate(query);

        } catch (SQLException ex){
            ex.getMessage();
        }
    }

    public void Transakcje() {



    }



}