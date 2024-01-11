package com.eazybyte.accounts.Controller;

import com.eazybyte.accounts.Constants.AccountConstants;
import com.eazybyte.accounts.DTO.CustomerDTO;
import com.eazybyte.accounts.DTO.AllDetailsDTO;
import com.eazybyte.accounts.DTO.ResponseDTO;
import com.eazybyte.accounts.Service.AccountsService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@Validated
public class AccountsController {

    @Autowired
    AccountsService accountsService;

    @PostMapping("/create")
public ResponseEntity<ResponseDTO> createAccount(@Valid @RequestBody CustomerDTO customerDTO){
        accountsService.createAccount(customerDTO);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDTO(AccountConstants.STATUS_201,AccountConstants.MESSAGE_201));
    }

    @GetMapping("/fetch")
    public ResponseEntity<AllDetailsDTO> fetchAccountDetails(@RequestParam
                                                                 @Pattern(regexp="(^$|[0-9]{10}])", message = "Mobile Number must be 10 Digits")
                                                                 String mobileNumber){
            AllDetailsDTO fetchAllDTO= accountsService.fetchByMobileNumber(mobileNumber);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(fetchAllDTO);
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDTO> updateDetails(@Valid @RequestBody AllDetailsDTO allDetailsDTO){
              boolean isUpdated =  accountsService.updateAccount(allDetailsDTO);

              if(isUpdated) return  ResponseEntity.status(HttpStatus.OK)
                      .body(new ResponseDTO(AccountConstants.STATUS_200,AccountConstants.MESSAGE_200));

              return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                      .body(new ResponseDTO(AccountConstants.STATUS_500,AccountConstants.MESSAGE_500));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDTO> deleteByAccountNumber(@Valid @RequestParam
                                                                 @Pattern(regexp="(^$|[0-9]{10}])", message = "Account Number must be 10 Digits")
                                                                 Long accountNumber,
                                                             @Pattern(regexp="(^$|[0-9]{10}])", message = "Mobile Number must be 10 Digits")
                                                             @RequestParam String mobileNumber){
       boolean bol=  accountsService.DeleteByAccountNumber(accountNumber,mobileNumber);
        if(bol) return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseDTO(AccountConstants.STATUS_202,AccountConstants.MESSAGE_202));
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ResponseDTO(AccountConstants.STATUS_500,AccountConstants.MESSAGE_500));
    }
}