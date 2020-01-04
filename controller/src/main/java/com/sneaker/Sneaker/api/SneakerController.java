package com.sneaker.Sneaker.api;

import com.sneaker.Sneaker.model.Sneaker;
import com.sneaker.Sneaker.service.SneakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/sneaker")
@RestController
public class SneakerController {

    private final SneakerService sneakerService;

    @Autowired
    public SneakerController(SneakerService sneakerService) {
        this.sneakerService = sneakerService;
    }
    @PostMapping
    public void addSneaker(@RequestBody Sneaker sneaker){
        sneakerService.addSneaker(sneaker);
    }
    @GetMapping
    public List<Sneaker> getAllSneaker(){
        return sneakerService.getAllSneaker();
    }
}
