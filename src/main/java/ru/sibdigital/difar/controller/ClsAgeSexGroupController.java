package ru.sibdigital.difar.controller;

import org.springframework.web.bind.annotation.*;
import ru.sibdigital.difar.domain.catalog.ClsAgeSexGroupEntity;
import ru.sibdigital.difar.repository.catalog.ClsAgeSexGroupRepository;

import java.util.Optional;

@RestController
@RequestMapping("/age-sex-group")
public class ClsAgeSexGroupController {

    private ClsAgeSexGroupRepository clsAgeSexGroupRepository;

    public ClsAgeSexGroupController(ClsAgeSexGroupRepository clsAgeSexGroupRepository) {
        this.clsAgeSexGroupRepository = clsAgeSexGroupRepository;
    }

    @PostMapping("/create")
    public void create(@RequestBody ClsAgeSexGroupEntity ageSexGroup) {
        clsAgeSexGroupRepository.save(ageSexGroup);
    }

    @GetMapping("/{id}")
    public ClsAgeSexGroupEntity read(@PathVariable long id) {
        Optional<ClsAgeSexGroupEntity> ageSexGroupOptional = clsAgeSexGroupRepository.findById(id);

        return ageSexGroupOptional.orElse(null);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        Optional<ClsAgeSexGroupEntity> ageSexGroupOptional = clsAgeSexGroupRepository.findById(id);
        ageSexGroupOptional.ifPresent(clsAgeSexGroupEntity -> clsAgeSexGroupRepository.delete(clsAgeSexGroupEntity));
    }

}
