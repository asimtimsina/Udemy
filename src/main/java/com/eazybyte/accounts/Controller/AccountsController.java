package com.eazybyte.accounts.Controller;

import com.eazybyte.accounts.Constants.AccountConstants;
import com.eazybyte.accounts.DTO.CustomerDTO;
import com.eazybyte.accounts.DTO.AllDetailsDTO;
import com.eazybyte.accounts.DTO.ResponseDTO;
import com.eazybyte.accounts.Service.AccountsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
public class AccountsController {

    @Autowired
    AccountsService accountsService;

    @PostMapping("/create")
public ResponseEntity<ResponseDTO> createAccount(@RequestBody CustomerDTO customerDTO){
        accountsService.createAccount(customerDTO);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDTO(AccountConstants.STATUS_201,AccountConstants.MESSAGE_201));
    }

    @GetMapping("/fetch")
    public ResponseEntity<AllDetailsDTO> fetchAccountDetails(@RequestParam String mobileNumber){
            AllDetailsDTO fetchAllDTO= accountsService.fetchByMobileNumber(mobileNumber);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(fetchAllDTO);
    }

//    @PutMapping("/update")
//    public ResponseEntity<ResponseDTO> updateDetails(){
//
//    }
}