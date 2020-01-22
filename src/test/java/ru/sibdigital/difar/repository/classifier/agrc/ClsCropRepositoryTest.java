package ru.sibdigital.difar.repository.classifier.agrc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.sibdigital.difar.domain.classifier.accs.ClsUserEntity;
import ru.sibdigital.difar.domain.classifier.agrc.ClsCropEntity;
import ru.sibdigital.difar.repository.classifier.base.ClsBaseTest;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClsCropRepositoryTest extends ClsBaseTest {

    @Autowired
    private ClsCropRepository repository;

    private ClsCropEntity getEntityForSave() {
        String code = "А-00001";
        String number = "00001";
        String name = "Культура";

        ClsUserEntity user = userRepository.findById(DEFAULT_ID).get();
        ClsCropEntity entity = new ClsCropEntity();
        entity.setCode(code)
                .setName(name)
                .setNumber(number)
                .setIdUserCreator(user.getId());

        return entity;
    }

    @Test
    public void findDefaultEntryTest() {
        ClsCropEntity entity = repository.findById(DEFAULT_ID).get();
        assertNotNull(entity);
    }

    @Test
    public void CRUDTest() throws Exception {
        // сохранение
        ClsCropEntity entity = getEntityForSave();
        ClsCropEntity saved = repository.save(entity);
        assertNotNull(saved);
        assertNotEquals(saved.getId(), 0L);

        // обновление
        ClsCropEntity forUpdate = repository.findByName(entity.getName());
        String duplicateName = entity.getName() + entity.getName();
        forUpdate.setName(duplicateName);
        repository.save(forUpdate);
        ClsCropEntity updated = repository.findByName(duplicateName);
        assertEquals(updated.getName(), duplicateName);
        assertNotEquals(updated.getName(), entity.getName());//????

        // чтение
        ClsCropEntity byNumber = repository.findByNumber(entity.getNumber());
        assertNotNull(byNumber);
        assertEquals(updated, byNumber);

        // удаление
        repository.delete(entity);
        Optional<ClsCropEntity> optional = repository.findById(entity.getId());
        assertFalse(optional.isPresent());
    }

}