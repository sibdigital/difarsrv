package ru.sibdigital.difar.repository.classifier.dict;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.sibdigital.difar.domain.classifier.accs.ClsUserEntity;
import ru.sibdigital.difar.domain.classifier.dict.ClsDistrictEntity;
import ru.sibdigital.difar.domain.classifier.dict.ClsRegionEntity;
import ru.sibdigital.difar.repository.classifier.base.ClsBaseRepositoryTest;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClsDistrictRepositoryTest extends ClsBaseRepositoryTest {

    @Autowired
    private ClsDistrictRepository repository;

    private ClsDistrictEntity getEntityForSave() {
        String number = "00001";
        String name = "Район";

        ClsUserEntity user = userRepository.findById(DEFAULT_ID).get();
        ClsRegionEntity regionEntity = regionRepository.findById(DEFAULT_ID).get();
        ClsDistrictEntity entity = new ClsDistrictEntity();
        entity.setName(name)
                .setNumber(number)
                .setIdUserCreator(user.getId())
                .setClsRegionByIdRegion(regionEntity);

        return entity;
    }

    @Test
    public void findDefaultEntryTest() {
        ClsDistrictEntity entity = repository.findById(DEFAULT_ID).get();
        assertNotNull(entity);
    }

    @Test
    public void CRUDTest() throws Exception {
        // сохранение
        ClsDistrictEntity entity = getEntityForSave();
        ClsDistrictEntity saved = repository.save(entity);
        assertNotNull(saved);
        assertNotEquals(saved.getId(), 0L);

        // обновление
        ClsDistrictEntity forUpdate = repository.findByName(entity.getName());
        String duplicateName = entity.getName() + entity.getName();
        forUpdate.setName(duplicateName);
        repository.save(forUpdate);
        ClsDistrictEntity updated = repository.findByName(duplicateName);
        assertEquals(updated.getName(), duplicateName);
        assertNotEquals(updated.getName(), entity.getName());//????

        // чтение
        ClsDistrictEntity byNumber = repository.findByNumber(entity.getNumber());
        assertNotNull(byNumber);
        assertEquals(updated, byNumber);

        // удаление
        repository.delete(entity);
        Optional<ClsDistrictEntity> optional = repository.findById(entity.getId());
        assertFalse(optional.isPresent());
    }

}