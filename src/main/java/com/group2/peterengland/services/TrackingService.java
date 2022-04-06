package com.group2.peterengland.services;

import com.group2.peterengland.models.Reviews;
import com.group2.peterengland.models.Tracking;
import com.group2.peterengland.repositories.TrackingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TrackingService {

    @Autowired
    TrackingRepository trackingRepository;

    @Autowired
    ReviewService reviewService;

    public List<Tracking> getAllTracking() {
        List<Tracking> trackings = new ArrayList<>();
        trackingRepository.findAll().forEach(trackings::add);
        return trackings;
    }

    public Tracking getTracking(Integer tracking_id) {
        Optional<Tracking> tracking = trackingRepository.findById(tracking_id);
        if(tracking.isPresent()) {
            return  tracking.get();
        }
        return null;
    }

    public void addTracking(Tracking tracking) {
        System.out.println("service tracking: " + tracking.toString());
        trackingRepository.save(tracking);
    }

    public void udpateTrackingStatus(Integer tracking_id, Tracking status) {
        Optional<Tracking> trackingOpt = trackingRepository.findById(tracking_id);
        if(trackingOpt.isPresent()) {
            Tracking tracking = trackingOpt.get();
            tracking.setStatus(status.getStatus());
            trackingRepository.save(tracking);

            if(status.getStatus().equals("DELIVERED")) {
                Reviews reviews = new Reviews();
                reviews.setId(trackingOpt.get().getBill_no());
                reviewService.addReview(reviews);
                System.out.println("DELIVERED");
            }
        }
    }

    public void deleteTracking(Integer tracking_id) {
        trackingRepository.deleteById(tracking_id);
    }

}
