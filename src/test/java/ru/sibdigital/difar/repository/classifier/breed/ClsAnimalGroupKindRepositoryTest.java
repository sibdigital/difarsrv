package ru.sibdigital.difar.repository.classifier.breed;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.sibdigital.difar.domain.classifier.accs.ClsUserEntity;
import ru.sibdigital.difar.domain.classifier.breed.ClsAnimalGroupKindEntity;
import ru.sibdigital.difar.repository.classifier.base.ClsBaseTest;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClsAnimalGroupKindRepositoryTest extends ClsBaseTest {

    @Autowired
    private ClsAnimalGroupKindRepository repository;

    private ClsAnimalGroupKindEntity getEntityForSave() {
        String code = "А-00001";
        String number = "00001";
        String name = "Группа";

        ClsUserEntity user = userRepository.findById(DEFAULT_ID).get();
        ClsAnimalGroupKindEntity entity = new ClsAnimalGroupKindEntity();
        entity.setCode(code)
                .setName(name)
                .setNumber(number)
                .setIdUserCreator(user.getId());

        return entity;
    }

    @Test
    public void findDefaultEntryTest() {
        ClsAnimalGroupKindEntity clsAgeSexGroupEntity = repository.findById(DEFAULT_ID).get();
        assertNotNull(clsAgeSexGroupEntity);
    }

    @Test
    public void CRUDTest() throws Exception {
        // сохранение
        ClsAnimalGroupKindEntity entity = getEntityForSave();
        ClsAnimalGroupKindEntity saved = repository.save(entity);
        assertNotNull(saved);
        assertNotEquals(saved.getId(), 0L);

        // обновление
        ClsAnimalGroupKindEntity forUpdate = repository.findByName(entity.getName());
        String duplicateName = entity.getName() + entity.getName();
        forUpdate.setName(duplicateName);
        repository.save(forUpdate);
        ClsAnimalGroupKindEntity updated = repository.findByName(duplicateName);
        assertEquals(updated.getName(), duplicateName);
        assertNotEquals(updated.getName(), entity.getName());//????

        // чтение
        ClsAnimalGroupKindEntity byNumber = repository.findByNumber(entity.getNumber());
        assertNotNull(byNumber);
        assertEquals(updated, byNumber);

        // удаление
        repository.delete(entity);
        Optional<ClsAnimalGroupKindEntity> optional = repository.findById(entity.getId());
        assertFalse(optional.isPresent());
    }
}