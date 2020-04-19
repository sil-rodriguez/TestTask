package com.accounting.booknote.resource;

import com.accounting.booknote.exception.InvalidFormatException;
import com.accounting.booknote.model.Transaction;
import com.accounting.booknote.service.TransactionService;
import com.accounting.booknote.validation.IDValidation;
import com.accounting.booknote.validation.TransactionValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Resource to handle the transaction requests
 */
@RestController
public class TransactionResource {

    @Autowired
    private TransactionService service;

    private TransactionValidation transactionValidator = new TransactionValidation();
    private IDValidation idValidator = new IDValidation();

    @GetMapping("/transactions")
    @CrossOrigin(origins = "http://localhost:3000")
    public List<Transaction> find() {
        return service.find();
    }

    @GetMapping("/transactions/{id}")
    public Transaction findById(@PathVariable String id) {
        List<String> errors = idValidator.validate(id);
        if(errors.isEmpty()){
            return service.findById(id);
        }
        throw new InvalidFormatException(String.join(";",errors));
    }

    @PostMapping("/transactions")
    public Transaction commit(@RequestBody Transaction transaction) {
        List<String> errors = transactionValidator.validate(transaction);
        if(errors.isEmpty()){
            return service.commit(transaction);
        }
        throw new InvalidFormatException(String.join(";",errors));
    }

    public void setService(TransactionService service) {
        this.service = service;
    }
}
