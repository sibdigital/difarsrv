package ru.sibdigital.difar.repository.classifier.agrc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.sibdigital.difar.domain.classifier.accs.ClsUserEntity;
import ru.sibdigital.difar.domain.classifier.agrc.ClsPlantDiseaseEntity;
import ru.sibdigital.difar.domain.classifier.dict.ClsUnitEntity;
import ru.sibdigital.difar.repository.classifier.base.ClsBaseRepositoryTest;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClsPlantDiseaseRepositoryTest extends ClsBaseRepositoryTest {

    @Autowired
    private ClsPlantDiseaseRepository repository;

    private ClsPlantDiseaseEntity getEntityForSave() {
        String number = "00001";
        String name = "Заболевание";
        ClsUnitEntity unitEntity = unitRepository.findById(DEFAULT_ID).get();

        ClsUserEntity user = userRepository.findById(DEFAULT_ID).get();
        ClsPlantDiseaseEntity entity = new ClsPlantDiseaseEntity();
        entity.setName(name)
                .setNumber(number)
                .setIdUserCreator(user.getId())
                .setClsUnitByIdUnit(unitEntity);

        return entity;
    }

    @Test
    public void findDefaultEntryTest() {
        ClsPlantDiseaseEntity entity = repository.findById(DEFAULT_ID).get();
        assertNotNull(entity);
    }

    @Test
    public void CRUDTest() throws Exception {
        // сохранение
        ClsPlantDiseaseEntity entity = getEntityForSave();
        ClsPlantDiseaseEntity saved = repository.save(entity);
        assertNotNull(saved);
        assertNotEquals(saved.getId(), 0L);

        // обновление
        ClsPlantDiseaseEntity forUpdate = repository.findByName(entity.getName());
        String duplicateName = entity.getName() + entity.getName();
        forUpdate.setName(duplicateName);
        repository.save(forUpdate);
        ClsPlantDiseaseEntity updated = repository.findByName(duplicateName);
        assertEquals(updated.getName(), duplicateName);
        assertNotEquals(updated.getName(), entity.getName());//????

        // чтение
        ClsPlantDiseaseEntity byNumber = repository.findByNumber(entity.getNumber());
        assertNotNull(byNumber);
        assertEquals(updated, byNumber);

        // удаление
        repository.delete(entity);
        Optional<ClsPlantDiseaseEntity> optional = repository.findById(entity.getId());
        assertFalse(optional.isPresent());
    }

}