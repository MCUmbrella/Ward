package org.bsoftware.ward.controllers;

import org.bsoftware.ward.dto.SetupDto;
import org.bsoftware.ward.services.SetupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * SetupController displays responses from rest API
 * @author Rudolf Barbu
 * @version 1.0.1
 */
@RestController
@RequestMapping(value = "/api/setup")
public class SetupController
{
    /**
     * Autowired SetupService object
     * Used for posting settings information in ini file
     */
    @Autowired
    private SetupService setupService;

    /**
     * Posting setup info in database
     * @param setupDto dto with data
     * @return ResponseEntity to servlet
     */
    @PostMapping
    public ResponseEntity<?> postSetup(@RequestBody @Validated SetupDto setupDto) throws Exception
    {
        return new ResponseEntity<>(setupService.postSetup(setupDto), HttpStatus.OK);
    }
}