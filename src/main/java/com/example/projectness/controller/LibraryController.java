package com.example.projectness.controller;

import com.example.projectness.model.LibraryBooks;
import com.example.projectness.services.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/library")

public class LibraryController {

    @Autowired
    private LibraryService service;


    //add a new book
    @PostMapping("/add-book")
    public ResponseEntity<LibraryBooks> addBook(@RequestBody LibraryBooks book) {

        return new ResponseEntity<>(service.saveBook(book), HttpStatus.OK);
    }


    //Get all books by author and name
    @GetMapping("/get-all")
    public List<LibraryBooks> getBooksByAuthorAndName(){

        return service.getBooks();
    }



    //delete a book
    @DeleteMapping("/delete/{bookName}")
    public String deleteBook(@PathVariable String bookName) {
        return service.deleteBook(bookName);
    }


    //get a book by title
    @GetMapping("/search/{bookName}")
    public LibraryBooks findBookByTitle(@PathVariable String bookName) {
        return service.getBookByTitle(bookName);
    }


    //update author for a book
    @PutMapping("/update")
    public LibraryBooks updateBook(@RequestBody LibraryBooks book) {
        return service.updateBook(book);
    }




}
