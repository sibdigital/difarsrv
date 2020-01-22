package ru.sibdigital.difar.repository.classifier.breed;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.sibdigital.difar.domain.classifier.accs.ClsUserEntity;
import ru.sibdigital.difar.domain.classifier.breed.ClsTypeAnimalEventEntity;
import ru.sibdigital.difar.repository.classifier.base.ClsBaseTest;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClsTypeAnimalEventRepositoryTest extends ClsBaseTest {

    @Autowired
    private ClsTypeAnimalEventRepository repository;

    private ClsTypeAnimalEventEntity getEntityForSave() {
        String number = "00001";
        String name = "Тип";

        ClsUserEntity user = userRepository.findById(DEFAULT_ID).get();
        ClsTypeAnimalEventEntity entity = new ClsTypeAnimalEventEntity();
        entity.setName(name)
                .setNumber(number)
                .setIdUserCreator(user.getId());

        return entity;
    }

    @Test
    public void findDefaultEntryTest() {
        ClsTypeAnimalEventEntity entity = repository.findById(DEFAULT_ID).get();
        assertNotNull(entity);
    }

    @Test
    public void CRUDTest() throws Exception {
        // сохранение
        ClsTypeAnimalEventEntity entity = getEntityForSave();
        ClsTypeAnimalEventEntity saved = repository.save(entity);
        assertNotNull(saved);
        assertNotEquals(saved.getId(), 0L);

        // обновление
        ClsTypeAnimalEventEntity forUpdate = repository.findByName(entity.getName());
        String duplicateName = entity.getName() + entity.getName();
        forUpdate.setName(duplicateName);
        repository.save(forUpdate);
        ClsTypeAnimalEventEntity updated = repository.findByName(duplicateName);
        assertEquals(updated.getName(), duplicateName);
        assertNotEquals(updated.getName(), entity.getName());//????

        // чтение
        ClsTypeAnimalEventEntity byNumber = repository.findByNumber(entity.getNumber());
        assertNotNull(byNumber);
        assertEquals(updated, byNumber);

        // удаление
        repository.delete(entity);
        Optional<ClsTypeAnimalEventEntity> optional = repository.findById(entity.getId());
        assertFalse(optional.isPresent());
    }

}