package ru.sibdigital.difar.controller;

import org.springframework.web.bind.annotation.*;
import ru.sibdigital.difar.domain.catalog.ClsKindAnimalEntity;
import ru.sibdigital.difar.repository.catalog.ClsKindAnimalRepository;

import java.util.Optional;

@RestController
@RequestMapping("/kind-animal")
public class ClsKindAnimalController {

    private ClsKindAnimalRepository clsKindAnimalRepository;

    public ClsKindAnimalController(ClsKindAnimalRepository clsKindAnimalRepository) {
        this.clsKindAnimalRepository = clsKindAnimalRepository;
    }

    @PostMapping("/create")
    public void create(@RequestBody ClsKindAnimalEntity kindAnimal) {
        clsKindAnimalRepository.save(kindAnimal);
    }

    @GetMapping("/{id}")
    public ClsKindAnimalEntity read(@PathVariable long id) {
        Optional<ClsKindAnimalEntity> kindAnimalOptional = clsKindAnimalRepository.findById(id);

        return kindAnimalOptional.orElse(null);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        Optional<ClsKindAnimalEntity> kindAnimalOptional = clsKindAnimalRepository.findById(id);
        kindAnimalOptional.ifPresent(clsBreedEntity -> clsKindAnimalRepository.delete(clsBreedEntity));
    }

}
