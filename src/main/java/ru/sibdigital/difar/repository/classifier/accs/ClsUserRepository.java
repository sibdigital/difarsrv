package ru.sibdigital.difar.repository.classifier.accs;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sibdigital.difar.domain.classifier.accs.ClsUserEntity;

public interface ClsUserRepository extends JpaRepository<ClsUserEntity, Long> {
    ClsUserEntity findByName(String name);
}
