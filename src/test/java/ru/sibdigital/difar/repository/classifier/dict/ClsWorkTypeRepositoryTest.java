package ru.sibdigital.difar.repository.classifier.dict;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.sibdigital.difar.domain.classifier.accs.ClsUserEntity;
import ru.sibdigital.difar.domain.classifier.dict.ClsWorkTypeEntity;
import ru.sibdigital.difar.repository.classifier.base.ClsBaseTest;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClsWorkTypeRepositoryTest extends ClsBaseTest {

    @Autowired
    private ClsWorkTypeRepository repository;

    private ClsWorkTypeEntity getEntityForSave() {
        String number = "00001";
        String name = "Вид работы";

        ClsUserEntity user = userRepository.findById(DEFAULT_ID).get();
        ClsWorkTypeEntity entity = new ClsWorkTypeEntity();
        entity.setName(name)
                .setNumber(number)
                .setIdUserCreator(user.getId());

        return entity;
    }

    @Test
    public void findDefaultEntryTest() {
        ClsWorkTypeEntity entity = repository.findById(DEFAULT_ID).get();
        assertNotNull(entity);
    }

    @Test
    public void CRUDTest() throws Exception {
        // сохранение
        ClsWorkTypeEntity entity = getEntityForSave();
        ClsWorkTypeEntity saved = repository.save(entity);
        assertNotNull(saved);
        assertNotEquals(saved.getId(), 0L);

        // обновление
        ClsWorkTypeEntity forUpdate = repository.findByName(entity.getName());
        String duplicateName = entity.getName() + entity.getName();
        forUpdate.setName(duplicateName);
        repository.save(forUpdate);
        ClsWorkTypeEntity updated = repository.findByName(duplicateName);
        assertEquals(updated.getName(), duplicateName);
        assertNotEquals(updated.getName(), entity.getName());//????

        // чтение
        ClsWorkTypeEntity byNumber = repository.findByNumber(entity.getNumber());
        assertNotNull(byNumber);
        assertEquals(updated, byNumber);

        // удаление
        repository.delete(entity);
        Optional<ClsWorkTypeEntity> optional = repository.findById(entity.getId());
        assertFalse(optional.isPresent());
    }

}