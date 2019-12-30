package ru.sibdigital.difar.repository.catalog;

import org.springframework.data.repository.CrudRepository;
import ru.sibdigital.difar.domain.catalog.ClsUserEntity;

public interface ClsUserRepository extends CrudRepository<ClsUserEntity, Long> {
//    void deleteById(long id);
}
