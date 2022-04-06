package com.group2.peterengland.controllers;

import com.group2.peterengland.models.Tracking;
import com.group2.peterengland.services.TrackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TrackingController {

    @Autowired
    private TrackingService trackingService;

    @RequestMapping("/tracking")
    public List<Tracking> getAllTrackings() {
        return trackingService.getAllTracking();
    }

    @RequestMapping("/tracking/{id}")
    public Tracking getTracking(@PathVariable Integer id) {
        return trackingService.getTracking(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/tracking")
    public void addTracking(@RequestBody Tracking tracking) {
        System.out.println("controller tracking: " + tracking.toString());
        trackingService.addTracking(tracking);
    }

    @RequestMapping(method = RequestMethod.PUT, value="/tracking/{id}")
    public void updateTrackingStatus(@RequestBody Tracking status, @PathVariable Integer id) {
       System.out.println("controller status update: " + status);
        trackingService.udpateTrackingStatus(id, status);
    }

    @RequestMapping(method = RequestMethod.DELETE, value="/tracking")
    public void deleteTracking(@RequestParam Integer id) {
        trackingService.deleteTracking(id);
    }
}
