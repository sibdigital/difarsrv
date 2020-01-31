package ru.sibdigital.difar.controller.classifier.agrc;

import org.springframework.web.bind.annotation.*;
import ru.sibdigital.difar.domain.classifier.agrc.ClsWeatherStationEntity;
import ru.sibdigital.difar.repository.classifier.agrc.ClsWeatherStationRepository;

import java.util.Optional;

@RestController
@RequestMapping("weather-station")
public class ClsWeatherStationController {

    private ClsWeatherStationRepository repository;

    public ClsWeatherStationController(ClsWeatherStationRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/create")
    public ClsWeatherStationEntity create(@RequestBody ClsWeatherStationEntity entity) {
        ClsWeatherStationEntity saved = repository.save(entity);
        return saved;
    }

    @GetMapping("/{id}")
    public ClsWeatherStationEntity read(@PathVariable long id) {
        Optional<ClsWeatherStationEntity> optional = repository.findById(id);
        return optional.orElse(null);
    }

    @PutMapping("/update")
    public ClsWeatherStationEntity update(@RequestBody ClsWeatherStationEntity entityToUpdate) {
        ClsWeatherStationEntity updated = repository.save(entityToUpdate);
        return updated;
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable long id) {
        Optional<ClsWeatherStationEntity> optional = repository.findById(id);
        optional.ifPresent(entity -> repository.delete(entity));
        return optional.isPresent();
    }

}
