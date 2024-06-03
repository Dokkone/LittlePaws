package com.rijai.users.controller;

import com.rijai.users.model.Adopt;
import com.rijai.users.model.Message;
import com.rijai.users.repository.AdoptRepository;
import com.rijai.users.services.AdoptService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class AdoptController {

    private AdoptService adoptService;
    private AdoptRepository adoptRepository;

    public AdoptController(AdoptService adoptService,AdoptRepository adoptRepository)
    {
        this.adoptService = adoptService;
        this.adoptRepository = adoptRepository;
    }

    @RequestMapping(value="/api/add-adopt-message", method= RequestMethod.POST)
    public Adopt addMessage(@RequestBody Adopt adopt)
    {
        return adoptService.addMessage(adopt);
    }

}
