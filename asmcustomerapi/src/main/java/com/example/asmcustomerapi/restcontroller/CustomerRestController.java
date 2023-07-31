package com.example.asmcustomerapi.restcontroller;

import com.example.asmcustomerapi.dao.CustomerRepository;
import com.example.asmcustomerapi.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CustomerRestController {
    private CustomerRepository repository;

    @Autowired
    public CustomerRestController(CustomerRepository theCustomerRepository){
         repository=theCustomerRepository;
    }
    //get list customer
    @GetMapping("/customer")
    public List<Customer> all(){return repository.findAll();}

    //create new Customer
    @PostMapping("/customer")
    public Customer newCustomer(@RequestBody Customer newCustomer){
        return repository.save(newCustomer);
    }
    //get one Customer
    @GetMapping("/customer/{id}")
    public Customer one(@PathVariable Integer id){
        return repository.findById(id).orElseThrow(()->new CustomerNotFoundException(id));
    }
    //update

    @PutMapping("/customer/{id}")

    public Customer updateCustomer(@PathVariable Integer id,@RequestBody Customer updateCustomer){
        Optional<Customer> customer = repository.findById(id);

        if (customer.isPresent()){
            Customer newCustomer = customer.get();
            newCustomer.setFirstName(updateCustomer.getFirstName());
            newCustomer.setLastName(updateCustomer.getLastName());
            newCustomer.setPhoneNumber(updateCustomer.getPhoneNumber());
            newCustomer.setAddress(updateCustomer.getAddress());
            newCustomer.setEmail(updateCustomer.getEmail());
            return repository.save(newCustomer);
        }else throw new CustomerNotFoundException(id);
    }

    //delete one customer
    @DeleteMapping("/customer/{id}")
    void deleteCustomer(@PathVariable Integer id){
        repository.deleteById(id);
    }
}
