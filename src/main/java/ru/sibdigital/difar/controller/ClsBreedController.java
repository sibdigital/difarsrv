package ru.sibdigital.difar.controller;

import org.springframework.web.bind.annotation.*;
import ru.sibdigital.difar.domain.catalog.breed.ClsBreedEntity;
import ru.sibdigital.difar.repository.catalog.ClsBreedRepository;

import java.util.Optional;

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

    @GetMapping("/{id}")
    public ClsBreedEntity read(@PathVariable long id) {
        Optional<ClsBreedEntity> breedOptional = clsBreedRepository.findById(id);

        return breedOptional.orElse(null);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        Optional<ClsBreedEntity> breedOptional = clsBreedRepository.findById(id);
        breedOptional.ifPresent(clsBreedEntity -> clsBreedRepository.delete(clsBreedEntity));
    }

}
