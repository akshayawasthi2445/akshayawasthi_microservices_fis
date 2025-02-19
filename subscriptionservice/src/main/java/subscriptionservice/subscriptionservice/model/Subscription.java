package subscriptionservice.subscriptionservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Date;

@Entity
public class Subscription {
        
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long subscription_id;
    
        @Column(name = "user_id", nullable = false)
        private Long user_id;
    
        @Column(name = "book_id", nullable = false)
        private Long book_id;
    
        @Column(name = "subscription_date", nullable = false)
        private Date subscription_date;
    
        @Column(name = "return_date", nullable = false)
        private Date return_date;
    
        @Override
        public String toString() {
            return "Subscription [book_id=" + book_id + ", return_date=" + return_date + ", subscription_date=" + subscription_date + ", subscription_id=" + subscription_id + ", user_id=" + user_id;
        }
}
