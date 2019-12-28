package ru.sibdigital.difar.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sibdigital.difar.domain.ClsKindAnimalEntity;
import ru.sibdigital.difar.repository.ClsKindAnimalRepository;

@RestController
@RequestMapping("/kind")
public class ClsKindAnimalController {

    private ClsKindAnimalRepository clsKindAnimalRepository;

    public ClsKindAnimalController(ClsKindAnimalRepository clsKindAnimalRepository) {
        this.clsKindAnimalRepository = clsKindAnimalRepository;
    }

    @PostMapping("/create")
    public void create(@RequestBody ClsKindAnimalEntity kindAnimal) {
        clsKindAnimalRepository.save(kindAnimal);
    }
}
