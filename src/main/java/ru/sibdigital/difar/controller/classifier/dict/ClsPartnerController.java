package ru.sibdigital.difar.controller.classifier.dict;

import org.springframework.web.bind.annotation.*;
import ru.sibdigital.difar.domain.classifier.dict.ClsPartnerEntity;
import ru.sibdigital.difar.repository.classifier.dict.ClsPartnerRepository;

import java.util.Optional;

@RestController
@RequestMapping("/partner")
public class ClsPartnerController {

    private ClsPartnerRepository repository;

    public ClsPartnerController(ClsPartnerRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/create")
    public ClsPartnerEntity create(@RequestBody ClsPartnerEntity entity) {
        ClsPartnerEntity saved = repository.save(entity);
        return saved;
    }

    @GetMapping("/{id}")
    public ClsPartnerEntity read(@PathVariable long id) {
        Optional<ClsPartnerEntity> optional = repository.findById(id);
        return optional.orElse(null);
    }

    @PutMapping("/update")
    public ClsPartnerEntity update(@RequestBody ClsPartnerEntity entityToUpdate) {
        ClsPartnerEntity updated = repository.save(entityToUpdate);
        return updated;
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable long id) {
        Optional<ClsPartnerEntity> optional = repository.findById(id);
        optional.ifPresent(entity -> repository.delete(entity));
        return optional.isPresent();
    }

}
