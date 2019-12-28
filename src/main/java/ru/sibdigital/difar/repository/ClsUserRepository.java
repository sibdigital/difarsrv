package ru.sibdigital.difar.repository;

import org.springframework.data.repository.CrudRepository;
import ru.sibdigital.difar.domain.ClsUserEntity;

public interface ClsUserRepository extends CrudRepository<ClsUserEntity, Long> {
//    void deleteById(long id);
}
