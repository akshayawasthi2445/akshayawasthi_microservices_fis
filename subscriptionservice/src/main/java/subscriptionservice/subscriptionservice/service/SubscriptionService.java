package subscriptionservice.subscriptionservice.service;

import subscriptionservice.subscriptionservice.model.Subscription;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import subscriptionservice.subscriptionservice.repository.SubscriptionRepository;

@Service
public class SubscriptionService {
    @Autowired
    private SubscriptionRepository subscriptionRepository;
    
    public void addSubscription(Subscription subscription) {
        subscriptionRepository.save(subscription);
    }

    public void deleteSubscription(Long subscriptionId) {
        subscriptionRepository.deleteById(subscriptionId);
    }

    public List<Subscription> getSubscriptionsByUserId(Long userId) {
        return subscriptionRepository.findByUserId(userId);
    }
}
