package ru.sibdigital.difar.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sibdigital.difar.domain.ClsBreedEntity;
import ru.sibdigital.difar.repository.ClsBreedRepository;

@RestController
@RequestMapping("/breed")
public class ClsBreedController {

    private ClsBreedRepository clsBreedRepository;

    public ClsBreedController(ClsBreedRepository clsBreedRepository) {
        this.clsBreedRepository = clsBreedRepository;
    }

    @PostMapping("/create")
    public void create(@RequestBody ClsBreedEntity breed) {
        clsBreedRepository.save(breed);
    }
}
