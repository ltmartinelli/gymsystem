package com.ltmartinelli.gymsystem.entities;

public enum PaymentStatus {
    PENDING,
    PAID,
    CANCELLED,
    EXPIRED,
}

//PENDING: Hasn't been paid yet
//PAID: Payment has been confirmed
//CANCELLED: Contract has been cancelled by user.
//EXPIRED: User hasn't paid before expiration.
