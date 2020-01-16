package ru.sibdigital.difar.repository.catalog;

import org.springframework.data.repository.CrudRepository;
import ru.sibdigital.difar.domain.catalog.accs.ClsResourceEntity;

public interface ClsResourceRepository extends CrudRepository<ClsResourceEntity, Long> {
}
