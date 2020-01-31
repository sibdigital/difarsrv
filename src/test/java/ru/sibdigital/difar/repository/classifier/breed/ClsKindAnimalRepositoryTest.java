package ru.sibdigital.difar.repository.classifier.breed;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.sibdigital.difar.domain.classifier.accs.ClsUserEntity;
import ru.sibdigital.difar.domain.classifier.breed.ClsKindAnimalEntity;
import ru.sibdigital.difar.repository.classifier.base.ClsBaseRepositoryTest;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClsKindAnimalRepositoryTest extends ClsBaseRepositoryTest {

    @Autowired
    private ClsKindAnimalRepository repository;

    private ClsKindAnimalEntity getEntityForSave() {
        String number = "00001";
        String name = "Вид";
        String code = "А-00001";

        ClsUserEntity user = userRepository.findById(DEFAULT_ID).get();
        ClsKindAnimalEntity entity = new ClsKindAnimalEntity();
        entity.setName(name)
                .setNumber(number)
                .setCode(code)
                .setIdUserCreator(user.getId());

        return entity;
    }

    @Test
    public void findDefaultEntryTest() {
        ClsKindAnimalEntity entity = repository.findById(DEFAULT_ID).get();
        assertNotNull(entity);
    }

    @Test
    public void CRUDTest() throws Exception {
        // сохранение
        ClsKindAnimalEntity entity = getEntityForSave();
        ClsKindAnimalEntity saved = repository.save(entity);
        assertNotNull(saved);
        assertNotEquals(saved.getId(), 0L);

        // обновление
        ClsKindAnimalEntity forUpdate = repository.findByName(entity.getName());
        String duplicateName = entity.getName() + entity.getName();
        forUpdate.setName(duplicateName);
        repository.save(forUpdate);
        ClsKindAnimalEntity updated = repository.findByName(duplicateName);
        assertEquals(updated.getName(), duplicateName);
        assertNotEquals(updated.getName(), entity.getName());//????

        // чтение
        ClsKindAnimalEntity byNumber = repository.findByNumber(entity.getNumber());
        assertNotNull(byNumber);
        assertEquals(updated, byNumber);

        // удаление
        repository.delete(entity);
        Optional<ClsKindAnimalEntity> optional = repository.findById(entity.getId());
        assertFalse(optional.isPresent());
    }

}