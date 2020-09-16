package com.example.book.controller;

import com.example.book.BookRepository;
import com.example.book.model.Book;
import com.example.book.model.Books;
import com.example.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {
    @Autowired
    BookService bookService;

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/books")
    public @ResponseBody Iterable<Book> getAll(){
        return bookRepository.findAll();
    }

    @RequestMapping(value = "/book/{idBuku}", method = RequestMethod.GET)
    public Book getBook(@PathVariable(name = "idBuku") String idBuku){
        return bookService.getBook(idBuku);
    }

    @GetMapping("/books/")
    @ResponseBody
    public Book getById(@RequestParam String idBuku){
        return bookService.getById(idBuku);
    }

    @PostMapping(value="/books")
    public @ResponseBody String addNewBook(@RequestParam String judulBuku,
                                           String penerbit, String tahunTerbit){
        Book book = new Book();
        book.setJudulBuku(judulBuku);
        book.setPenerbit(penerbit);
        book.setTahunTerbit(tahunTerbit);
        bookRepository.save(book);
        return "Saved";
    }

    @RequestMapping(value="/book", method = RequestMethod.GET)
    public String convert(Books buku){
        return bookService.convert(buku);
    }
}
