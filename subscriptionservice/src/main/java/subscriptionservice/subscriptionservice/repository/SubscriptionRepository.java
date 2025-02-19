package subscriptionservice.subscriptionservice.repository;
import subscriptionservice.subscriptionservice.model.Subscription;
import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription,Long>{
    List<Subscription> findByUserId(Long userId);
}
