package bookservice.bookservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import bookservice.bookservice.repository.BookRepository;
import bookservice.bookservice.model.Book;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public List<Book> getAvailableBooks() {
        return bookRepository.findByCopiesAvailableGreaterThan(0);
    }

    public boolean isAvailable(Long bookId) {
        return bookRepository.existsByBookId(bookId);
    }

    public void addBook(Book book) {
        bookRepository.save(book);
    }
}
