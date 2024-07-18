package com.yakun.api;

import com.yakun.domain.Party;
import com.yakun.service.Impl.PartyServiceImpl;

import com.yakun.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/parties")
public class PartyController {

    @Autowired
    private PartyServiceImpl partyService;

    @CrossOrigin
    @GetMapping("{partyId}")
    public JsonResult<Party> getPartyById(@PathVariable String partyId){
        JsonResult jsonResult = new JsonResult();
        jsonResult.setData(partyService.getById(partyId));
        jsonResult.setCode("200");
        return jsonResult;
    }

    @CrossOrigin
    @GetMapping
    public JsonResult getAll(){
        JsonResult jsonResult = new JsonResult();
        jsonResult.setData(partyService.getAllParty());
        jsonResult.setCode("200");
        return jsonResult;
    }
}
