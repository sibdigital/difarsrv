package ru.sibdigital.difar.controller.classifier.dict;

import org.springframework.web.bind.annotation.*;
import ru.sibdigital.difar.domain.classifier.dict.ClsDistrictEntity;
import ru.sibdigital.difar.repository.classifier.dict.ClsDistrictRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/district")
public class ClsDistrictController {

    private ClsDistrictRepository repository;

    public ClsDistrictController(ClsDistrictRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/create")
    public ClsDistrictEntity create(@RequestBody ClsDistrictEntity entity) {
        return repository.save(entity);
    }

    @GetMapping("/{id}")
    public ClsDistrictEntity read(@PathVariable long id) {
        Optional<ClsDistrictEntity> optional = repository.findById(id);
        return optional.orElse(null);
    }

    @PutMapping("/update")
    public ClsDistrictEntity update(@RequestBody ClsDistrictEntity entityToUpdate) {
        return repository.save(entityToUpdate);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable long id) {
        Optional<ClsDistrictEntity> optional = repository.findById(id);
        optional.ifPresent(entity -> {
            entity.setDeleted(true);
            repository.save(entity);
        });
        return optional.isPresent();
    }

    @GetMapping
    public Iterable<ClsDistrictEntity> findAll() {
        List<ClsDistrictEntity> target = new ArrayList<>();
        repository.findAll().forEach(target::add);
        return target.stream().filter(element -> element.getDeleted() == null || !element.getDeleted()).collect(Collectors.toList());
    }

}
