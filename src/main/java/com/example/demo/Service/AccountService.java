package com.example.demo.Service;

import com.example.demo.Entity.Account;
import com.example.demo.Repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;


    //creating an account
    public Account createAccount(Account account) throws Exception{
        if(account == null){
            throw new Exception("Account is Empty");
        }

        Account accountByEmail = getByEmail(account.getEmail());
        if(accountByEmail != null){
            throw new Exception("Email is already registerd");
        }

        return accountRepository.save(account);
    }
    //get by email
    public Account getByEmail(String email){
        return accountRepository.findByEmail(email);
    }

    //finding account by Id
    public Account getById(Long id){
        return accountRepository.findById(id).get();
    }

    //Update User Details
    public Account updateAccount(Account account, Long id) throws Exception {
        Account account1 = getById(id);
        if(account1 == null){
            throw new Exception("Account not found!");
        }
         account1.setFirstName(account.getFirstName());
        account1.setLastName(account.getLastName());
        account1.setEmail(account.getEmail());
        account1.setPassword(account.getPassword());

        return accountRepository.save(account1);
    }

    //delete an Account
    public Account deleteAccount(Long id) throws Exception {
        Account account = getById(id);
        if(account == null){
            throw new Exception("Account doesn't exist");
        }
        accountRepository.delete(account);
        return  account;
    }

    //getAllAccounts
    public List<Account> getAllAccounts(){
        return accountRepository.findAll();
    }



}
