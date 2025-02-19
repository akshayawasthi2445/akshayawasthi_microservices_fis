package subscriptionservice.subscriptionservice.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;
import org.springframework.cloud.client.discovery.DiscoveryClient;

import subscriptionservice.subscriptionservice.model.Subscription;
import subscriptionservice.subscriptionservice.service.SubscriptionService;


@RestController
@RequestMapping("/subscriptions")
public class SubscriptionController {
    @Autowired
    private SubscriptionService subscriptionService;

    private final DiscoveryClient discoveryClient;
	private final RestClient restClient;

    public SubscriptionController(DiscoveryClient discoveryClient, RestClient restClient) {
        this.discoveryClient = discoveryClient;
        this.restClient = restClient;
    }

    @PostMapping("/add")
    public void addSubscription(@RequestBody Subscription subscription) {
        // checking for whether the book is availableeee or not
        String response = restClient.get().uri(serviceInstance.getUri()+"/books/api/available/"+subscription.getBook_id()).retrieve().body(String.class);
        if (response.equals("false")) {
            throw new RuntimeException("Book is not available");
        }
        subscriptionService.addSubscription(subscription);
    }

    @PostMapping("/delete")
    public void deleteSubscription(@RequestBody Long subscriptionId) {
        subscriptionService.deleteSubscription(subscriptionId);
    }

    @PostMapping("/get")
    public List<Subscription> getSubscriptionsByUserId(@RequestBody Long userId) {
        return subscriptionService.getSubscriptionsByUserId(userId);
    }
}
