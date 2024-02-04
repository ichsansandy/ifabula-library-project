package com.ifabula.library.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "t_rent")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Rent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    private Book book;

    @OneToOne
    private User user;

    @Column( columnDefinition = "DATE")
    private LocalDate rentedAt; // Date when the book was rented
    @Column( columnDefinition = "DATE")
    private LocalDate returnedAt;
    @Column( columnDefinition = "DATE")
    private LocalDate expirationDate;

    public boolean isRentExpired() {
        return LocalDate.now().isAfter(this.expirationDate);
    }
}
