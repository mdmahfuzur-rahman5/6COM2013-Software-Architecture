package model;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import model.Customer;
import java.util.stream.Collectors;

public class CustomerQueue {
    private Queue<Customer> queue; // Use Customer directly

    // Constructor initializes the queue
    public CustomerQueue() {
        queue = new LinkedList<>();
    }

    // Adds a customer to the queue
    public void addCustomer(Customer customer) {
        queue.add(customer);
    }

    // Returns the entire queue
    public Queue<Customer> getQueue() {
        return queue;
    }

    // Returns a list of customer names
    public List<String> getAllCustomers() {
        return queue.stream()
                .map(Customer::getName) // Correctly references the Customer class
                .collect(Collectors.toList());
    }
}