package com.example.book.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Books {
    public List<Book> buku = new ArrayList<>(Arrays.asList(
            new Book("1", "Buku A", "Erlangga", "2015"),
            new Book("2", "Buku B", "Gramedia", "2016"),
            new Book("3", "Buku C", "Erlangga", "2017")
    ));
}
