package com.onlyjavaboot.roz.controller;

import com.onlyjavaboot.roz.intities.EmailRequest;
import com.onlyjavaboot.roz.services.EmailServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmailController {

    @Autowired
    private EmailServices emailServices;

    @RequestMapping("/welcome")
    public String welcome(){
        return "Hello this is email API";
    }

    @RequestMapping(value ="/sendemail", method = RequestMethod.POST)
    public ResponseEntity<?> sendEmail(@RequestBody EmailRequest emailRequest)
    {
      this.emailServices.sendEmail(emailRequest.getSubject(), emailRequest.getMessage(), emailRequest.getTo());
        System.out.println(""+emailRequest);
        return ResponseEntity.ok("Done.....");
    }


}
