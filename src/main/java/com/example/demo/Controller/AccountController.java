package com.example.demo.Controller;

import com.example.demo.Entity.Account;
import com.example.demo.Entity.ApiResponse;
import com.example.demo.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping("")
    public ResponseEntity<ApiResponse<Account>> createAccount(@RequestBody Account account) {
        ApiResponse<Account> response = new ApiResponse<>();
        try {
            Account account1 = accountService.createAccount(account);
            response.setMessage("Account created successfully.");
            response.setData(account1);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.setMessage(e.getMessage());
            response.setStatus(500);
            return ResponseEntity.badRequest().body(response);
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Account>> getById(@PathVariable("id") Long id) {
        ApiResponse<Account> response = new ApiResponse<>();
        try {
            Account account = accountService.getById(id);
            response.setMessage("Account fetched successful");
            response.setData(account);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.setMessage(e.getMessage());
            response.setStatus(500);
            return ResponseEntity.badRequest().body(response);
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ApiResponse<Account>> updateAccount(@PathVariable("id") Long id, @RequestBody Account account) {
        ApiResponse<Account> response = new ApiResponse<>();
        try {
            Account account1 = accountService.updateAccount(account,id);
            response.setMessage("Account updated successfully.");
            response.setData(account1);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.setMessage(e.getMessage());
            response.setStatus(500);
            return ResponseEntity.badRequest().body(response);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Account>> deleteAccount(@PathVariable("id") Long id) {
        ApiResponse<Account> response = new ApiResponse<>();
        try {
            Account account1 = accountService.deleteAccount(id);
            response.setMessage("Account deleted successfully.");
            response.setData(account1);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.setMessage(e.getMessage());
            response.setStatus(500);
            return ResponseEntity.badRequest().body(response);
        }
    }

    @GetMapping("")
    public ResponseEntity<ApiResponse<List<Account>>> getAllAccounts() {
        ApiResponse<List<Account>> response = new ApiResponse<>();
        try {
            List<Account> accounts = accountService.getAllAccounts();
            response.setMessage("Account fetched successful");
            response.setData(accounts);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.setMessage(e.getMessage());
            response.setStatus(500);
            return ResponseEntity.badRequest().body(response);
        }
    }
}
