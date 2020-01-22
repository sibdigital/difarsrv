package ru.sibdigital.difar.repository.classifier.breed;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.sibdigital.difar.domain.classifier.accs.ClsUserEntity;
import ru.sibdigital.difar.domain.classifier.breed.ClsAnimalParamKindEntity;
import ru.sibdigital.difar.repository.classifier.base.ClsBaseTest;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClsAnimalParamKindRepositoryTest extends ClsBaseTest {

    @Autowired
    private ClsAnimalParamKindRepository repository;

    private ClsAnimalParamKindEntity getEntityForSave() {
        String number = "00001";
        String name = "Параметр";

        ClsUserEntity user = userRepository.findById(DEFAULT_ID).get();
        ClsAnimalParamKindEntity entity = new ClsAnimalParamKindEntity();
        entity.setName(name)
                .setNumber(number)
                .setIdUserCreator(user.getId());

        return entity;
    }

    @Test
    public void findDefaultEntryTest() {
        ClsAnimalParamKindEntity entity = repository.findById(DEFAULT_ID).get();
        assertNotNull(entity);
    }

    @Test
    public void CRUDTest() throws Exception {
        // сохранение
        ClsAnimalParamKindEntity entity = getEntityForSave();
        ClsAnimalParamKindEntity saved = repository.save(entity);
        assertNotNull(saved);
        assertNotEquals(saved.getId(), 0L);

        // обновление
        ClsAnimalParamKindEntity forUpdate = repository.findByName(entity.getName());
        String duplicateName = entity.getName() + entity.getName();
        forUpdate.setName(duplicateName);
        repository.save(forUpdate);
        ClsAnimalParamKindEntity updated = repository.findByName(duplicateName);
        assertEquals(updated.getName(), duplicateName);
        assertNotEquals(updated.getName(), entity.getName());//????

        // чтение
        ClsAnimalParamKindEntity byNumber = repository.findByNumber(entity.getNumber());
        assertNotNull(byNumber);
        assertEquals(updated, byNumber);

        // удаление
        repository.delete(entity);
        Optional<ClsAnimalParamKindEntity> optional = repository.findById(entity.getId());
        assertFalse(optional.isPresent());
    }
}