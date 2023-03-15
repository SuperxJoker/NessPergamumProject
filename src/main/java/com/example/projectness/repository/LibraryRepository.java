package com.example.projectness.repository;

import com.example.projectness.model.LibraryBooks;
import org.springframework.stereotype.Repository;

import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class LibraryRepository {




    private List<LibraryBooks> list = new ArrayList<LibraryBooks>();

    //Add some books to the list
    public LibraryRepository() {


        list.add(new LibraryBooks("Amintiri din copilarie", "Ion Creanga"));
        list.add(new LibraryBooks("Ion", "Liviu Rebreanu"));
        list.add(new LibraryBooks("Moara cu noroc", "Ioan Slavici"));

   }


   //Add the specified book in the list
    public LibraryBooks save(LibraryBooks b) {
        LibraryBooks books = new LibraryBooks();
        books.setBookName(b.getBookName());
        books.setBookAuthor(b.getBookAuthor());
        list.add(books);
        return books;
    }


    //Get the books
    public List<LibraryBooks> getBooksByAuthorAndName() {

        //Sort by author name
        Collections.sort(list, new Comparator<LibraryBooks>() {
            public int compare(LibraryBooks book1, LibraryBooks book2) {
                return book1.getBookAuthor().compareTo(book2.getBookAuthor());
            }
        });

        // Sort the books with the same author by title
        Collections.sort(list, new Comparator<LibraryBooks>() {
            public int compare(LibraryBooks book1, LibraryBooks book2) {
                // If the authors are the same, sort by title
                if (book1.getBookAuthor().equals(book2.getBookAuthor())) {
                    return book1.getBookName().compareTo(book2.getBookName());
                } else {
                    return 0;
                }
            }
        });

        return list;
    }



    //Delete a specified book
    public String delete(String bookName){
        list.removeIf(x -> Objects.equals(x.getBookName(), bookName)); //remove elements(books) that match
        return null;
    }


    //Find a specified book
    public LibraryBooks findByTitle(String bookName){
        for (int i = 0; i < list.size(); i++) { //Search for the book
            if (Objects.equals(list.get(i).getBookName(), bookName)) {
                return list.get(i);
            }

        }
        return null;
    }



    public LibraryBooks update(LibraryBooks book) {
        int idx = -1;

        for (int i = 0; i < list.size(); i++) {
            if (Objects.equals(list.get(i).getBookName(), book.getBookName())) { //iterate through book list and check if equal to the book passed as argument
                idx = i;
                break;
            }
        }
        if (idx >= 0) { //Book was found

            //Create new book with updated author
            LibraryBooks updatedBook = new LibraryBooks();
            updatedBook.setBookName(book.getBookName());
            updatedBook.setBookAuthor(book.getBookAuthor());


            list.set(idx, updatedBook);
            return updatedBook; //return updated book
        } else { //Book was not found

            return null;
        }
    }
}
        



