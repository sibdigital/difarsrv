package ru.sibdigital.difar.repository.classifier.dict;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.sibdigital.difar.domain.classifier.accs.ClsUserEntity;
import ru.sibdigital.difar.domain.classifier.dict.ClsLegalEntityEntity;
import ru.sibdigital.difar.domain.classifier.dict.ClsStandardPeriodEntity;
import ru.sibdigital.difar.repository.classifier.base.ClsBaseRepositoryTest;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClsStandardPeriodRepositoryTest extends ClsBaseRepositoryTest {

    @Autowired
    private ClsStandardPeriodRepository repository;

    private ClsStandardPeriodEntity getEntityForSave() {
        String number = "00001";
        String name = "Организация";

        ClsUserEntity user = userRepository.findById(DEFAULT_ID).get();
        ClsLegalEntityEntity legalEntity = legalEntityRepository.findById(DEFAULT_ID).get();
        ClsStandardPeriodEntity entity = new ClsStandardPeriodEntity();
        entity.setName(name)
                .setNumber(number)
                .setIdUserCreator(user.getId());

        return entity;
    }

    @Test
    public void findDefaultEntryTest() {
        ClsStandardPeriodEntity entity = repository.findById(DEFAULT_ID).get();
        assertNotNull(entity);
    }

    @Test
    public void CRUDTest() throws Exception {
        // сохранение
        ClsStandardPeriodEntity entity = getEntityForSave();
        ClsStandardPeriodEntity saved = repository.save(entity);
        assertNotNull(saved);
        assertNotEquals(saved.getId(), 0L);

        // обновление
        ClsStandardPeriodEntity forUpdate = repository.findByName(entity.getName());
        String duplicateName = entity.getName() + entity.getName();
        forUpdate.setName(duplicateName);
        repository.save(forUpdate);
        ClsStandardPeriodEntity updated = repository.findByName(duplicateName);
        assertEquals(updated.getName(), duplicateName);
        assertNotEquals(updated.getName(), entity.getName());//????

        // чтение
        ClsStandardPeriodEntity byNumber = repository.findByNumber(entity.getNumber());
        assertNotNull(byNumber);
        assertEquals(updated, byNumber);

        // удаление
        repository.delete(entity);
        Optional<ClsStandardPeriodEntity> optional = repository.findById(entity.getId());
        assertFalse(optional.isPresent());
    }

}