package bookservice.bookservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "books")
public class Book {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long book_id;

    @Column(name = "author", nullable = false)
    private String author;

    @Column(name = "copies_available")
    private int copies_available;

    @Override
    public String toString() {
        return "Book [author=" + author + ", book_id=" + book_id + ", copies_available=" + copies_available;
    }
}
