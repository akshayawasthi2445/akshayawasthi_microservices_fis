package bookservice.bookservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bookservice.bookservice.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

        Book findByBookId(Long bookId);
        
        boolean existsByBookId(Long bookId);

        List<Book> findByCopiesAvailableGreaterThan(int i);

}
