package com.ifabula.library.services;

import com.ifabula.library.model.Book;
import com.ifabula.library.model.Rent;
import com.ifabula.library.model.User;
import com.ifabula.library.repository.BookRepository;
import com.ifabula.library.repository.RentRepository;
import com.ifabula.library.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
public class RentService {
    @Autowired
    BookRepository bookRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RentRepository rentRepository;

    @Transactional
    public void rentBook(int bookId, String email) throws Error  {

        User user = userRepository.findByEmail(email);

        // Find the book by ID
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new Error("Book with ID " + bookId + " not found"));

        // Check if the book is already rented
        if (book.getRentedBy() != null) {
            throw new Error("Book with ID " + bookId + " is already rented");
        }

        // Check if the user already has a rented book
        if (user.getCurrentRent() != null) {
            throw new Error("You already has a rented book");
        }

        // Create and save a new rent record
        Rent rent = new Rent();
        rent.setBook(book);
        rent.setUser(user);
        rent.setRentedAt(LocalDate.now());
        rent.setExpirationDate(LocalDate.now().plusDays(2));

        book.setRentedBy(user); // Update rentedBy field in the Book object
        book.setAvailable(false);
        user.setCurrentRent(rent); // Update currentRent field in the User object

        bookRepository.save(book);
        userRepository.save(user);
    }

    @Transactional
    public void returnBook(int bookId, String email) throws Error {

        User user = userRepository.findByEmail(email);
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new Error("Book with ID " + bookId + " not found"));

        // Check if the book is currently rented by the user
        if (!user.equals(book.getRentedBy())) {
            throw new Error("You are not the current renter of this book");
        }

        // Check if the book is already returned
        if (user.getCurrentRent() == null || user.getCurrentRent().getBook().getId() != bookId) {
            throw new Error("The book is not currently rented by you");
        }

        Rent rent = user.getCurrentRent();

        // Update book and user fields
        book.setRentedBy(null);
        book.setAvailable(true);
        user.setCurrentRent(null);


        // Save updates
        bookRepository.save(book);
        userRepository.save(user);

        rentRepository.delete(rent);
    }

}
