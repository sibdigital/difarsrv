package ru.sibdigital.difar.repository.classifier.agrc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.sibdigital.difar.domain.classifier.accs.ClsUserEntity;
import ru.sibdigital.difar.domain.classifier.agrc.ClsPlantPestEntity;
import ru.sibdigital.difar.domain.classifier.dict.ClsUnitEntity;
import ru.sibdigital.difar.repository.classifier.base.ClsBaseTest;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClsPlantPestRepositoryTest extends ClsBaseTest {

    @Autowired
    private ClsPlantPestRepository repository;

    private ClsPlantPestEntity getEntityForSave() {
        String number = "00001";
        String name = "Вредитель";
        ClsUnitEntity unitEntity = unitRepository.findById(DEFAULT_ID).get();

        ClsUserEntity user = userRepository.findById(DEFAULT_ID).get();
        ClsPlantPestEntity entity = new ClsPlantPestEntity();
        entity.setName(name)
                .setNumber(number)
                .setIdUserCreator(user.getId())
                .setClsUnitByIdUnit(unitEntity);

        return entity;
    }

    @Test
    public void findDefaultEntryTest() {
        ClsPlantPestEntity entity = repository.findById(DEFAULT_ID).get();
        assertNotNull(entity);
    }

    @Test
    public void CRUDTest() throws Exception {
        // сохранение
        ClsPlantPestEntity entity = getEntityForSave();
        ClsPlantPestEntity saved = repository.save(entity);
        assertNotNull(saved);
        assertNotEquals(saved.getId(), 0L);

        // обновление
        ClsPlantPestEntity forUpdate = repository.findByName(entity.getName());
        String duplicateName = entity.getName() + entity.getName();
        forUpdate.setName(duplicateName);
        repository.save(forUpdate);
        ClsPlantPestEntity updated = repository.findByName(duplicateName);
        assertEquals(updated.getName(), duplicateName);
        assertNotEquals(updated.getName(), entity.getName());//????

        // чтение
        ClsPlantPestEntity byNumber = repository.findByNumber(entity.getNumber());
        assertNotNull(byNumber);
        assertEquals(updated, byNumber);

        // удаление
        repository.delete(entity);
        Optional<ClsPlantPestEntity> optional = repository.findById(entity.getId());
        assertFalse(optional.isPresent());
    }
}