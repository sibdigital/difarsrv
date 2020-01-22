package ru.sibdigital.difar.repository.classifier.dict;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.sibdigital.difar.domain.classifier.accs.ClsUserEntity;
import ru.sibdigital.difar.domain.classifier.dict.ClsUnitEntity;
import ru.sibdigital.difar.domain.classifier.dict.ClsUnitRatioEntity;
import ru.sibdigital.difar.repository.classifier.base.ClsBaseTest;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClsUnitRatioRepositoryTest extends ClsBaseTest {

    @Autowired
    private ClsUnitRatioRepository repository;

    private ClsUnitRatioEntity getEntityForSave() {
        String number = "00001";
        String name = "Соотношение";

        ClsUserEntity user = userRepository.findById(DEFAULT_ID).get();
        ClsUnitEntity unitFrom = unitRepository.findById(DEFAULT_ID).get();
        ClsUnitEntity unitTo = unitRepository.findById(DEFAULT_ID).get();
        ClsUnitRatioEntity entity = new ClsUnitRatioEntity();
        entity.setName(name)
                .setNumber(number)
                .setIdUserCreator(user.getId())
                .setClsUnitByIdUnitFrom(unitFrom)
                .setClsUnitByIdUnitTo(unitTo);

        return entity;
    }

    @Test
    public void findDefaultEntryTest() {
        ClsUnitRatioEntity entity = repository.findById(DEFAULT_ID).get();
        assertNotNull(entity);
    }

    @Test
    public void CRUDTest() throws Exception {
        // сохранение
        ClsUnitRatioEntity entity = getEntityForSave();
        ClsUnitRatioEntity saved = repository.save(entity);
        assertNotNull(saved);
        assertNotEquals(saved.getId(), 0L);

        // обновление
        ClsUnitRatioEntity forUpdate = repository.findByName(entity.getName());
        String duplicateName = entity.getName() + entity.getName();
        forUpdate.setName(duplicateName);
        repository.save(forUpdate);
        ClsUnitRatioEntity updated = repository.findByName(duplicateName);
        assertEquals(updated.getName(), duplicateName);
        assertNotEquals(updated.getName(), entity.getName());//????

        // чтение
        ClsUnitRatioEntity byNumber = repository.findByNumber(entity.getNumber());
        assertNotNull(byNumber);
        assertEquals(updated, byNumber);

        // удаление
        repository.delete(entity);
        Optional<ClsUnitRatioEntity> optional = repository.findById(entity.getId());
        assertFalse(optional.isPresent());
    }
}