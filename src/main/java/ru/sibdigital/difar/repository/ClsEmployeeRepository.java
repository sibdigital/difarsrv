package ru.sibdigital.difar.repository;

import org.springframework.data.repository.CrudRepository;
import ru.sibdigital.difar.domain.ClsEmployeeEntity;

public interface ClsEmployeeRepository extends CrudRepository<ClsEmployeeEntity, Long> {
}
