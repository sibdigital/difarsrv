package ru.sibdigital.difar.repository.catalog;

import org.springframework.data.repository.CrudRepository;
import ru.sibdigital.difar.domain.catalog.breed.ClsKindAnimalEntity;

public interface ClsKindAnimalRepository extends CrudRepository<ClsKindAnimalEntity, Long> {
}
