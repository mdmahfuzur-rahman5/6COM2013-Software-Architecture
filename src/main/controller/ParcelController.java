package controller;

import model.*;
import view.MainWindow;

import javax.swing.*;
import java.util.Queue;

public class ParcelController {
    private final CustomerQueue customerQueue;
    private final ParcelStorage parcelStorage;
    private final Worker worker;
    private final Log log;
    private final MainWindow view;

    public ParcelController(MainWindow view, CustomerQueue customerQueue, ParcelStorage parcelStorage, Worker worker, Log log) {
        this.view = view;
        this.customerQueue = customerQueue;
        this.parcelStorage = parcelStorage;
        this.worker = worker;
        this.log = log;

        setupListeners();
        updateView();
    }

    private void setupListeners() {
        view.getButtonPanel().getProcessButton().addActionListener(e -> processNextCustomer());
        view.getButtonPanel().getAddButton().addActionListener(e -> addNewCustomer());
        view.getButtonPanel().getExitButton().addActionListener(e -> System.exit(0));
    }

    private void updateView() {
        view.getCustomerPanel().updateCustomers(customerQueue.getAllCustomers());
        view.getParcelPanel().updateParcels(parcelStorage.getAvailableParcels());
    }

    private void processNextCustomer() {
        Queue<Customer> queue = customerQueue.getQueue();

        if (queue.isEmpty()) {
            JOptionPane.showMessageDialog(view, "No more customers in the queue!");
            return;
        }

        model.Customer customer = queue.poll();
        Parcel parcel = parcelStorage.getParcelById(customer.getParcelId());

        if (parcel == null) {
            JOptionPane.showMessageDialog(view, "No parcel found for Customer: " + customer.getName() + " with Parcel ID: " + customer.getParcelId());
            log.addEntry("No parcel found for " + customer.getName() + " - Parcel ID: " + customer.getParcelId());
            return;
        }

        String result = worker.processParcel(customer, parcel);
        JOptionPane.showMessageDialog(view, result);
        log.addEntry(result);
        updateView();
    }

    private void addNewCustomer() {
        String name = JOptionPane.showInputDialog(view, "Enter Customer Name:");
        if (name == null || name.trim().isEmpty()) {
            JOptionPane.showMessageDialog(view, "Invalid name. Please try again.");
            return;
        }

        String parcelId = JOptionPane.showInputDialog(view, "Enter Parcel ID:");
        if (parcelId == null || !parcelStorage.containsParcel(parcelId)) {
            JOptionPane.showMessageDialog(view, "Invalid Parcel ID. Please check and try again.");
            return;
        }

        Customer customer = new Customer(name, parcelId);
        customerQueue.addCustomer(customer);
        log.addEntry("Added new customer: " + name + " - Parcel ID: " + parcelId);
        updateView();
        JOptionPane.showMessageDialog(view, "Customer " + name + " added successfully!");
    }
}
