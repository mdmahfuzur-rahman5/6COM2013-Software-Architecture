package model;

public class Parcel {
    private String id;
    private double weight;
    private boolean processed;

    public Parcel(String id, double weight) {
        this.id = id;
        this.weight = weight;
        this.processed = false;
    }

    public String getId() {
        return id;
    }

    public double getWeight() {
        return weight;
    }

    public boolean isProcessed() {
        return processed;
    }

    public void markProcessed() {
        processed = true;
    }

    @Override
    public String toString() {
        return id + " - " + weight + " kg";
    }
}
