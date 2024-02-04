package com.ifabula.library.initilize;

import com.ifabula.library.model.Book;
import com.ifabula.library.model.Role;
import com.ifabula.library.model.User;
import com.ifabula.library.repository.BookRepository;
import com.ifabula.library.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DataInitialize implements ApplicationRunner {

    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    @Autowired
    public DataInitialize(UserRepository userRepository, BookRepository bookRepository) {
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (userRepository.findByEmail("admin@mail.com") == null) {

            String adminPassword = new BCryptPasswordEncoder().encode("admin");

            User adminUser = new User("Ifabula","admin", "admin@mail.com", adminPassword, Arrays.asList(new Role("ROLE_ADMIN")));

            userRepository.save(adminUser);
        }

        if (bookRepository.count() == 0) {
            List<Book> books = Arrays.asList(
                    new Book("The Lord of the Rings", "https://m.media-amazon.com/images/I/71jLBXtWJWL._AC_UF1000,1000_QL80_.jpg",true),
                    new Book("The Hitchhiker's Guide to the Galaxy", "https://m.media-amazon.com/images/I/51vfuNNWMTS.jpg",true),
                    new Book("Harry Potter and the Sorcerer's Stone", "https://m.media-amazon.com/images/I/51Ppi-8kISL.jpg",true),
                    new Book("To Kill a Mockingbird", "https://m.media-amazon.com/images/I/71FxgtFKcQL._AC_UF1000,1000_QL80_.jpg",true),
                    new Book("Pride and Prejudice", "https://m.media-amazon.com/images/I/71Q1tPupKjL._AC_UF1000,1000_QL80_.jpg",true)
            );
            bookRepository.saveAll(books);
        }
    }
}
