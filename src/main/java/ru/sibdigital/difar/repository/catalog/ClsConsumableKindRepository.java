package ru.sibdigital.difar.repository.catalog;

import org.springframework.data.repository.CrudRepository;
import ru.sibdigital.difar.domain.catalog.ClsConsumableEntity;

public interface ClsConsumableKindRepository extends CrudRepository<ClsConsumableEntity, Long> {
}
