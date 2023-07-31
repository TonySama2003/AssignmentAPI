package com.example.asmcustomerapi.restcontroller;

public class CustomerNotFoundException extends RuntimeException{
    private Integer customerId;

    public CustomerNotFoundException(Integer customerId){
        super("Customer not found with Id : " + customerId);
                this.customerId = customerId;
    }
}
