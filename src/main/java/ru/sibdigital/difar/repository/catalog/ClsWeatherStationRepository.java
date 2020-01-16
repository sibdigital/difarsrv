package ru.sibdigital.difar.repository.catalog;

import org.springframework.data.repository.CrudRepository;
import ru.sibdigital.difar.domain.catalog.agrc.ClsWeatherStationEntity;

public interface ClsWeatherStationRepository extends CrudRepository<ClsWeatherStationEntity, Long> {
}
