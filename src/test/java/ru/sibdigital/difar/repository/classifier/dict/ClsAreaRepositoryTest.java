package ru.sibdigital.difar.repository.classifier.dict;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.sibdigital.difar.domain.classifier.accs.ClsUserEntity;
import ru.sibdigital.difar.domain.classifier.dict.ClsAreaEntity;
import ru.sibdigital.difar.domain.classifier.dict.ClsDistrictEntity;
import ru.sibdigital.difar.repository.classifier.base.ClsBaseTest;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClsAreaRepositoryTest extends ClsBaseTest {

    @Autowired
    private ClsAreaRepository repository;

    private ClsAreaEntity getEntityForSave() {
        String number = "00001";
        String name = "Местность";

        ClsDistrictEntity districtEntity = districtRepository.findById(DEFAULT_ID).get();
        ClsUserEntity user = userRepository.findById(DEFAULT_ID).get();
        ClsAreaEntity entity = new ClsAreaEntity();
        entity.setName(name)
                .setNumber(number)
                .setIdUserCreator(user.getId())
                .setClsDistrictByIdDistrict(districtEntity);

        return entity;
    }

    @Test
    public void findDefaultEntryTest() {
        ClsAreaEntity entity = repository.findById(DEFAULT_ID).get();
        assertNotNull(entity);
    }

    @Test
    public void CRUDTest() throws Exception {
        // сохранение
        ClsAreaEntity entity = getEntityForSave();
        ClsAreaEntity saved = repository.save(entity);
        assertNotNull(saved);
        assertNotEquals(saved.getId(), 0L);

        // обновление
        ClsAreaEntity forUpdate = repository.findByName(entity.getName());
        String duplicateName = entity.getName() + entity.getName();
        forUpdate.setName(duplicateName);
        repository.save(forUpdate);
        ClsAreaEntity updated = repository.findByName(duplicateName);
        assertEquals(updated.getName(), duplicateName);
        assertNotEquals(updated.getName(), entity.getName());//????

        // чтение
        ClsAreaEntity byNumber = repository.findByNumber(entity.getNumber());
        assertNotNull(byNumber);
        assertEquals(updated, byNumber);

        // удаление
        repository.delete(entity);
        Optional<ClsAreaEntity> optional = repository.findById(entity.getId());
        assertFalse(optional.isPresent());
    }
}