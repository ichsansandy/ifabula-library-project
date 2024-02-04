package com.ifabula.library.services;

import com.ifabula.library.model.Book;
import com.ifabula.library.model.Rent;
import com.ifabula.library.model.Role;
import com.ifabula.library.model.User;
import com.ifabula.library.repository.BookRepository;
import com.ifabula.library.repository.RentRepository;
import com.ifabula.library.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class HomeService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    RentRepository rentRepository;

    public void prepareDataModelForIndexPage(String email, Model model){

        User user = userRepository.findByEmail(email);
        List<Book> books = bookRepository.findAll();

        Book currentlyRentedBook = null;
        if (user != null && user.getCurrentRent() != null) {
            currentlyRentedBook = user.getCurrentRent().getBook();
        }

        List<Rent> rents = rentRepository.findAll();

        model.addAttribute("currentlyRentedBook", currentlyRentedBook);
        model.addAttribute("user", user);
        model.addAttribute("books", books);
        model.addAttribute("rents", rents);
    }
}
