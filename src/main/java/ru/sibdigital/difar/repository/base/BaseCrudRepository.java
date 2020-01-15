package ru.sibdigital.difar.repository.base;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseCrudRepository<T> extends CrudRepository<T, Long> {
    T findByName(String name);

    T findByIdUserCreator(Long idUserCreator);

    T findByNumber(String number);
}

