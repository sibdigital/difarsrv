package ru.sibdigital.difar.controller.classifier.agrc;

import org.springframework.web.bind.annotation.*;
import ru.sibdigital.difar.domain.classifier.agrc.ClsWeatherStationEntity;
import ru.sibdigital.difar.repository.classifier.agrc.ClsWeatherStationRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("weather-station")
public class ClsWeatherStationController {

    private ClsWeatherStationRepository repository;

    public ClsWeatherStationController(ClsWeatherStationRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/create")
    public ClsWeatherStationEntity create(@RequestBody ClsWeatherStationEntity entity) {
        return repository.save(entity);
    }

    @GetMapping("/{id}")
    public ClsWeatherStationEntity read(@PathVariable long id) {
        Optional<ClsWeatherStationEntity> optional = repository.findById(id);
        return optional.orElse(null);
    }

    @PutMapping("/update")
    public ClsWeatherStationEntity update(@RequestBody ClsWeatherStationEntity entityToUpdate) {
        return repository.save(entityToUpdate);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable long id) {
        Optional<ClsWeatherStationEntity> optional = repository.findById(id);
        optional.ifPresent(entity -> {
            entity.setDeleted(true);
            repository.save(entity);
        });
        return optional.isPresent();
    }

    @GetMapping
    public Iterable<ClsWeatherStationEntity> findAll() {
        List<ClsWeatherStationEntity> target = new ArrayList<>();
        repository.findAll().forEach(target::add);
        return target.stream().filter(element -> element.getDeleted() == null || !element.getDeleted()).collect(Collectors.toList());
    }
}
