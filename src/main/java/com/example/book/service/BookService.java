package com.example.book.service;

import com.example.book.model.Book;
import com.example.book.model.Books;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class BookService {

    private List<Book> books = new ArrayList<>(Arrays.asList(
            new Book("1", "Buku A", "Erlangga", "2015"),
            new Book("2", "Buku B", "Gramedia", "2016"),
            new Book("3", "Buku C", "Erlangga", "2017")
    ));

    public List<Book> getAllBooks(){
        return books;
    }

    //find element by ID (path variable)
    public Book getBook(String idBuku){
        return books.stream().filter(book -> book.getIdBuku().equals(idBuku)).findFirst().get();
    }

    public void addBook(Book book){
        books.add(book);
    }
    //find element by ID juga tp buat query param
    public Book getById(String idBuku){
        return books.stream().filter(book -> book.getIdBuku().equals(idBuku)).findAny().orElse(null);
    }

    public String convert(Books buku) {
        //convert to JSON
        Gson gson = new Gson();
        String jsonBook = gson.toJson(buku);

        return jsonBook;
    }

public String getAll() {
    String sqlSelectAllBooks = "SELECT * FROM Book";
    String connectionUrl = "jdbc:mysql://localhost:3306/coba";

    try (
            Connection conn = DriverManager.getConnection(connectionUrl, "username", "password");
            PreparedStatement ps = conn.prepareStatement(sqlSelectAllBooks);
            ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {
            String idBuku = rs.getString("ID_BUKU");
            String judulBuku = rs.getString("JUDUL_BUKU");
            String penerbit = rs.getString("PENERBIT");
            String tahunTerbit = rs.getString("TAHUN_TERBIT");

            // do something with the extracted data...
        }
    } catch (SQLException e) {
        e.getMessage();
    }
    return "rs";
}
//        Gson gsonBuilder = new GsonBuilder().setFieldNamingPolicy(LOWER_CASE_WITH_UNDERSCORES).create();
//        Books convertBooks = gsonBuilder.fromJson(jsonBook, Books.class);
//----------------------------------------------------------------------------------------------------------------
//    public static String camelToSnake(String str)
//    {

//        // Empty String
//        String result = "";
//
//        // Append first character(in lower case)
//        // to result string
//        char c = str.charAt(0);
//        result = result + Character.toLowerCase(c);
//
//        // Tarverse the string from
//        // 1st index to last index
//        for (int i = 1; i < str.length(); i++) {
//
//            char ch = str.charAt(i);
//
//            // Check if the character is upper case
//            // then append '_' and such character
//            // (in lower case) to result string
//            if (Character.isUpperCase(ch)) {
//                result = result + '_';
//                result
//                        = result
//                        + Character.toLowerCase(ch);
//            }
//
//            // If the character is lower case then
//            // add such character into result string
//            else {
//                result = result + ch;
//            }
//        }
//
//        // return the result
//        return result;
//    }

}
