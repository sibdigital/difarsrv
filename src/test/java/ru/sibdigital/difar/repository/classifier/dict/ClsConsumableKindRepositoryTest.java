package ru.sibdigital.difar.repository.classifier.dict;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.sibdigital.difar.domain.classifier.accs.ClsUserEntity;
import ru.sibdigital.difar.domain.classifier.dict.ClsConsumableKindEntity;
import ru.sibdigital.difar.repository.classifier.base.ClsBaseTest;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClsConsumableKindRepositoryTest extends ClsBaseTest {

    @Autowired
    private ClsConsumableKindRepository repository;

    private ClsConsumableKindEntity getEntityForSave() {
        String number = "00001";
        String name = "Тип расходного материала";
        String code = "А-00001";

        ClsUserEntity user = userRepository.findById(DEFAULT_ID).get();
        ClsConsumableKindEntity entity = new ClsConsumableKindEntity();
        entity.setName(name)
                .setNumber(number)
                .setIdUserCreator(user.getId())
                .setCode(code);

        return entity;
    }

    @Test
    public void findDefaultEntryTest() {
        ClsConsumableKindEntity clsAgeSexGroupEntity = repository.findById(DEFAULT_ID).get();
        assertNotNull(clsAgeSexGroupEntity);
    }

    @Test
    public void CRUDTest() throws Exception {
        // сохранение
        ClsConsumableKindEntity entity = getEntityForSave();
        ClsConsumableKindEntity saved = repository.save(entity);
        assertNotNull(saved);
        assertNotEquals(saved.getId(), 0L);

        // обновление
        ClsConsumableKindEntity forUpdate = repository.findByName(entity.getName());
        String duplicateName = entity.getName() + entity.getName();
        forUpdate.setName(duplicateName);
        repository.save(forUpdate);
        ClsConsumableKindEntity updated = repository.findByName(duplicateName);
        assertEquals(updated.getName(), duplicateName);
        assertNotEquals(updated.getName(), entity.getName());//????

        // чтение
        ClsConsumableKindEntity byNumber = repository.findByNumber(entity.getNumber());
        assertNotNull(byNumber);
        assertEquals(updated, byNumber);

        // удаление
        repository.delete(entity);
        Optional<ClsConsumableKindEntity> optional = repository.findById(entity.getId());
        assertFalse(optional.isPresent());
    }

}