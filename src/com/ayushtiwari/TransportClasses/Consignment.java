package com.ayushtiwari.TransportClasses;

import java.time.LocalDateTime;

public class Consignment {
    private int consignmentId;
    private int waitingTime;
    private int volume;
    private Customer sender;
    private Customer receiver;
    private boolean isDelivered;
    private LocalDateTime arrivalTime;
    private LocalDateTime departureTime;
    private Truck truck;
    private Office sendingOffice;
    private Office receivingOffice;

    public Consignment(int consignmentId, int volume, Customer sender, Customer receiver, Office sendingOffice, Office receivingOffice) {
        this.consignmentId = consignmentId;
        this.volume = volume;
        this.sender = sender;
        this.receiver = receiver;
        this.isDelivered = false;
        this.sendingOffice = sendingOffice;
        this.receivingOffice = receivingOffice;
        this.arrivalTime = LocalDateTime.now();
    }

    public Office getSendingOffice() {
        return sendingOffice;
    }

    public void setSendingOffice(Office sendingOffice) {
        this.sendingOffice = sendingOffice;
    }

    public Office getReceivingOffice() {
        return receivingOffice;
    }

    public void setReceivingOffice(Office receivingOffice) {
        this.receivingOffice = receivingOffice;
    }

    public int getConsignmentId() {
        return consignmentId;
    }

    public void setConsignmentId(int consignmentId) {
        this.consignmentId = consignmentId;
    }

    public int getWaitingTime() {
        return waitingTime;
    }

    public void setWaitingTime(int waitingTime) {
        this.waitingTime = waitingTime;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public Customer getSender() {
        return sender;
    }

    public void setSender(Customer sender) {
        this.sender = sender;
    }

    public Customer getReceiver() {
        return receiver;
    }

    public void setReceiver(Customer receiver) {
        this.receiver = receiver;
    }

    public boolean isDelivered() {
        return isDelivered;
    }

    public void setDelivered(boolean delivered) {
        isDelivered = delivered;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public Truck getTruck() {
        return truck;
    }

    public void setTruck(Truck truck) {
        this.truck = truck;
    }
}