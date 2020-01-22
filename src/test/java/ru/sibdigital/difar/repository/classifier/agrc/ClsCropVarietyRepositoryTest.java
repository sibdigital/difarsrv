package ru.sibdigital.difar.repository.classifier.agrc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.sibdigital.difar.domain.classifier.accs.ClsUserEntity;
import ru.sibdigital.difar.domain.classifier.agrc.ClsCropEntity;
import ru.sibdigital.difar.domain.classifier.agrc.ClsCropVarietyEntity;
import ru.sibdigital.difar.repository.classifier.base.ClsBaseTest;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClsCropVarietyRepositoryTest extends ClsBaseTest {

    @Autowired
    private ClsCropVarietyRepository repository;

    private ClsCropVarietyEntity getEntityForSave() {
        String number = "00001";
        String name = "Разновидность культуры";
        ClsCropEntity cropEntity = cropRepository.findById(DEFAULT_ID).get();

        ClsUserEntity user = userRepository.findById(DEFAULT_ID).get();
        ClsCropVarietyEntity entity = new ClsCropVarietyEntity();
        entity.setName(name)
                .setNumber(number)
                .setIdUserCreator(user.getId())
                .setClsCropByIdCrop(cropEntity);

        return entity;
    }

    @Test
    public void findDefaultEntryTest() {
        ClsCropVarietyEntity clsAgeSexGroupEntity = repository.findById(DEFAULT_ID).get();
        assertNotNull(clsAgeSexGroupEntity);
    }

    @Test
    public void CRUDTest() throws Exception {
        // сохранение
        ClsCropVarietyEntity entity = getEntityForSave();
        ClsCropVarietyEntity saved = repository.save(entity);
        assertNotNull(saved);
        assertNotEquals(saved.getId(), 0L);

        // обновление
        ClsCropVarietyEntity forUpdate = repository.findByName(entity.getName());
        String duplicateName = entity.getName() + entity.getName();
        forUpdate.setName(duplicateName);
        repository.save(forUpdate);
        ClsCropVarietyEntity updated = repository.findByName(duplicateName);
        assertEquals(updated.getName(), duplicateName);
        assertNotEquals(updated.getName(), entity.getName());//????

        // чтение
        ClsCropVarietyEntity byNumber = repository.findByNumber(entity.getNumber());
        assertNotNull(byNumber);
        assertEquals(updated, byNumber);

        // удаление
        repository.delete(entity);
        Optional<ClsCropVarietyEntity> optional = repository.findById(entity.getId());
        assertFalse(optional.isPresent());
    }

}