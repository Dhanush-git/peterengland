package com.group2.peterengland.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tracking {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer tracking_id = 0;
    private Integer bill_no;
    private String status = "NOT_DISPATCHED";

    public Tracking() {
        
    };

    public Tracking(Integer bill_no, String status) {
        this.bill_no = bill_no;
        this.status = status;
    }

    public Tracking(int tracking_id, int bill_no, String status) {
        this.tracking_id = tracking_id;
        this.bill_no = bill_no;
        this.status = status;
    }

    public int getTracking_id() {
        return tracking_id;
    }

    public void setTracking_id(int tracking_id) {
        this.tracking_id = tracking_id;
    }

    public int getBill_no() {
        return bill_no;
    }

    public void setBill_no(int bill_no) {
        this.bill_no = bill_no;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        if(status != null) {
            this.status = status;
        }
    }

    @Override
    public String toString() {
        return "Tracking{" +
                "tracking_id=" + tracking_id +
                ", bill_no=" + bill_no +
                ", status='" + status + '\'' +
                '}';
    }
}
