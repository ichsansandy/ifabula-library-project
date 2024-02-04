package com.ifabula.library.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "t_book")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    private String imageUrl;

    @OneToOne(cascade = CascadeType.ALL)
    private User rentedBy;

    @Column(nullable = false, columnDefinition = "boolean default true")
    private boolean available;

    public Book(String title, String imageUrl, boolean available) {
        this.title = title;
        this.imageUrl = imageUrl;
        this.available = available;
    }
}
