package com.example.projectness.services;

import com.example.projectness.model.LibraryBooks;
import com.example.projectness.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryService {

    @Autowired
    private LibraryRepository repository;



    //Add a book service
    public LibraryBooks saveBook(LibraryBooks book) {
        return repository.save(book);
    }

    //Get books service
    public List<LibraryBooks> getBooks() {
        return repository.getBooksByAuthorAndName();
    }


    //Delte book service
    public String deleteBook(String bookName){
        repository.delete(bookName);
        return "book removed" + bookName;
    }


    //Find a book service
    public LibraryBooks getBookByTitle(String bookName) {
        return repository.findByTitle(bookName);

    }

    //Update author service
    public LibraryBooks updateBook(LibraryBooks book) {
        return repository.update(book);
    }


}
