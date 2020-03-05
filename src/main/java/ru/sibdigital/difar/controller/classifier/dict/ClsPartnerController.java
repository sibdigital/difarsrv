package ru.sibdigital.difar.controller.classifier.dict;

import org.springframework.web.bind.annotation.*;
import ru.sibdigital.difar.domain.classifier.dict.ClsPartnerEntity;
import ru.sibdigital.difar.repository.classifier.dict.ClsPartnerRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/partner")
public class ClsPartnerController {

    private ClsPartnerRepository repository;

    public ClsPartnerController(ClsPartnerRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/create")
    public ClsPartnerEntity create(@RequestBody ClsPartnerEntity entity) {
        return repository.save(entity);
    }

    @GetMapping("/{id}")
    public ClsPartnerEntity read(@PathVariable long id) {
        Optional<ClsPartnerEntity> optional = repository.findById(id);
        return optional.orElse(null);
    }

    @PutMapping("/update")
    public ClsPartnerEntity update(@RequestBody ClsPartnerEntity entityToUpdate) {
        return repository.save(entityToUpdate);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable long id) {
        Optional<ClsPartnerEntity> optional = repository.findById(id);
        optional.ifPresent(entity -> {
            entity.setDeleted(true);
            repository.save(entity);
        });
        return optional.isPresent();
    }

    @GetMapping
    public Iterable<ClsPartnerEntity> findAll() {
        List<ClsPartnerEntity> target = new ArrayList<>();
        repository.findAll().forEach(target::add);
        return target.stream().filter(element -> element.getDeleted() == null || !element.getDeleted()).collect(Collectors.toList());
    }

}
