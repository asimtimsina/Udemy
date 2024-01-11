package com.eazybyte.accounts.Controller;

import com.eazybyte.accounts.Constants.AccountConstants;
import com.eazybyte.accounts.DTO.CustomerDTO;
import com.eazybyte.accounts.DTO.AllDetailsDTO;
import com.eazybyte.accounts.DTO.ResponseDTO;
import com.eazybyte.accounts.Service.AccountsService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@OpenAPIDefinition(
        info = @Info(
                title="EazyBank Account Opening API Platform",
                description = "This is the simplest project for bank account opening",
                summary = "This is created by Nischal Timsina",
                contact = @Contact(name="Nischal Timsina", email = "Nischal@gmail.com", url="nischal.com"),
                version = "1.2"

        ),
        servers = {
                @Server(description="main", url = "http://localhost:8000/api/"),
                @Server(description="feature", url = "http://localhost:9000/api/"),

        }

)
@RestController
@RequestMapping(value = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@Validated
public class AccountsController {

    @Autowired
    AccountsService accountsService;

    @Operation(
            //tags="Create a Eazy-Bank account",
            description = "create a bank account using name, email and mobile number ",
            responses = {
                    @ApiResponse(description = "Account Created Successfully", responseCode = "201"),
                    @ApiResponse(description = "Customer already registered with given Mobile Number", responseCode = "400")
            }
    )
    @PostMapping("/create")
public ResponseEntity<ResponseDTO> createAccount(@Valid @RequestBody CustomerDTO customerDTO){
        accountsService.createAccount(customerDTO);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDTO(AccountConstants.STATUS_201,AccountConstants.MESSAGE_201));
    }

    @Operation(
           // tags="Fetch account details using Mobile Number",
            description = "Fetch a existing Eazy-Bank account details using Mobile Number ",
            responses = {
                    @ApiResponse(description = "Account Details", responseCode = "200"),
                    @ApiResponse(description = "Resource Not Found Exception", responseCode = "404")
            }
    )
    @GetMapping("/fetch")
    public ResponseEntity<AllDetailsDTO> fetchAccountDetails(@RequestParam
                                                                 @Pattern(regexp="(^$|[0-9]{10}])",
                                                                         message = "Mobile Number must be 10 Digits")
                                                                 String mobileNumber){
            AllDetailsDTO fetchAllDTO= accountsService.fetchByMobileNumber(mobileNumber);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(fetchAllDTO);
    }

    @Operation(
           // tags="Update account details using Account Number",
            description = "Updating a existing Eazy-Bank account details using Account Number ",
            responses = {
                    @ApiResponse(description = "Request Processed Successfully", responseCode = "200"),
                    @ApiResponse(description = "An error occurred. Please try later or contact IT Department",
                            responseCode = "500"),
                    @ApiResponse(description = "Resource Not Found Exception", responseCode = "404")
            }
    )
    @PutMapping("/update")
    public ResponseEntity<ResponseDTO> updateDetails(@Valid @RequestBody AllDetailsDTO allDetailsDTO){
              boolean isUpdated =  accountsService.updateAccount(allDetailsDTO);

              if(isUpdated) return  ResponseEntity.status(HttpStatus.OK)
                      .body(new ResponseDTO(AccountConstants.STATUS_200,AccountConstants.MESSAGE_200));

              return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                      .body(new ResponseDTO(AccountConstants.STATUS_500,AccountConstants.MESSAGE_500));
    }

    @Operation(
            //tags="Delete account details using Account Number and Mobile Number",
            description = "Delete a existing Eazy-Bank account details using Account Number and Mobile Number ",
            responses = {
                    @ApiResponse(description = "Account Deleted Successfully", responseCode = "202"),
                    @ApiResponse(description = "Internal Server Error,An error occurred. Please try later or contact IT Department",
                            responseCode = "500"),
                    @ApiResponse(description = "Resource Not Found Exception", responseCode = "404"),
                    @ApiResponse(description = "Account Number and Mobile Number does not match", responseCode = "400")
            }
    )
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