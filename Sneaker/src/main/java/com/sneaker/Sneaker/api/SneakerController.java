package com.sneaker.Sneaker.api;

import com.sneaker.Sneaker.model.Sneaker;
import com.sneaker.Sneaker.service.SneakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("api/v1/sneaker")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class SneakerController {

    private final SneakerService sneakerService;

    @Autowired
    public SneakerController(SneakerService sneakerService) {
        this.sneakerService = sneakerService;
    }

    @PostMapping
    public void addSneaker(@Valid @NotNull @RequestBody Sneaker sneaker) {
        sneakerService.addSneaker(sneaker);
    }

    @GetMapping
    public List<Sneaker> getAllSneaker() {
        return sneakerService.getAllSneaker();
    }

    @GetMapping(path = "/{id}")
    public Sneaker getSneakerById(@PathVariable("id") UUID id) {
        return sneakerService.getSneakerById(id)
                .orElse(null);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteSneakerById(@PathVariable("id") UUID id) {
        sneakerService.deleteSneaker(id);
    }

    @PutMapping(path = "/{id}")
    public void updateSneaker(@PathVariable("id") UUID id, @Valid @NotNull @RequestBody Sneaker sneakerToUpdate) {
        sneakerService.updateSneaker(id, sneakerToUpdate);
    }
}
