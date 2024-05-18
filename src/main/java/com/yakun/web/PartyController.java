package com.yakun.web;

import com.yakun.service.impl.PartyServiceImpl;

import com.yakun.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/parties")
public class PartyController {

    @Autowired
    private PartyServiceImpl partyService;

    @Autowired
    private Result result;

    @GetMapping("{partyId}")
    public Result getPartyById(@PathVariable String partyId){
        result.setData(partyService.getById(partyId));
        result.setFlag(true);
        return result;
    }

    @CrossOrigin
    @GetMapping
    public Result getAll(){
        result.setData(partyService.getAllParty());
        result.setFlag(true);
        return result;
    }
}
