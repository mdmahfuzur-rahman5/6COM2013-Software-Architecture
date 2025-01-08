package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ParcelStorage {
    private Map<String, Parcel> parcels;

    public ParcelStorage() {
        parcels = new HashMap<>();
    }

    public void addParcel(Parcel parcel) {
        parcels.put(parcel.getId(), parcel);
    }

    public Parcel getParcelById(String id) {
        return parcels.get(id);
    }

    public boolean containsParcel(String id) {
        return parcels.containsKey(id);
    }

    public List<String> getAvailableParcels() {
        return parcels.values().stream()
                .filter(parcel -> !parcel.isProcessed())
                .map(Parcel::toString)
                .collect(Collectors.toList());
    }
}