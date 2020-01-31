package ru.sibdigital.difar.repository.classifier.agrc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.sibdigital.difar.domain.classifier.accs.ClsUserEntity;
import ru.sibdigital.difar.domain.classifier.agrc.ClsDiseaseFeatureEntity;
import ru.sibdigital.difar.repository.classifier.base.ClsBaseRepositoryTest;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClsDiseaseFeatureRepositoryTest extends ClsBaseRepositoryTest {

    @Autowired
    private ClsDiseaseFeatureRepository repository;

    private ClsDiseaseFeatureEntity getEntityForSave() {
        String code = "А-00001";
        String number = "00001";
        String name = "Осбенность заболевания";

        ClsUserEntity user = userRepository.findById(DEFAULT_ID).get();
        ClsDiseaseFeatureEntity entity = new ClsDiseaseFeatureEntity();
        entity.setCode(code)
                .setName(name)
                .setNumber(number)
                .setIdUserCreator(user.getId());

        return entity;
    }

    @Test
    public void findDefaultEntryTest() {
        ClsDiseaseFeatureEntity entity = repository.findById(DEFAULT_ID).get();
        assertNotNull(entity);
    }

    @Test
    public void CRUDTest() throws Exception {
        // сохранение
        ClsDiseaseFeatureEntity entity = getEntityForSave();
        ClsDiseaseFeatureEntity saved = repository.save(entity);
        assertNotNull(saved);
        assertNotEquals(saved.getId(), 0L);

        // обновление
        ClsDiseaseFeatureEntity forUpdate = repository.findByName(entity.getName());
        String duplicateName = entity.getName() + entity.getName();
        forUpdate.setName(duplicateName);
        repository.save(forUpdate);
        ClsDiseaseFeatureEntity updated = repository.findByName(duplicateName);
        assertEquals(updated.getName(), duplicateName);
        assertNotEquals(updated.getName(), entity.getName());//????

        // чтение
        ClsDiseaseFeatureEntity byNumber = repository.findByNumber(entity.getNumber());
        assertNotNull(byNumber);
        assertEquals(updated, byNumber);

        // удаление
        repository.delete(entity);
        Optional<ClsDiseaseFeatureEntity> optional = repository.findById(entity.getId());
        assertFalse(optional.isPresent());
    }

}