package ru.sibdigital.difar.repository.catalog;

import org.springframework.data.repository.CrudRepository;
import ru.sibdigital.difar.domain.catalog.dict.ClsEquipmentTypeEntity;

public interface ClsEquipmentTypeRepository extends CrudRepository<ClsEquipmentTypeEntity, Long> {
}
