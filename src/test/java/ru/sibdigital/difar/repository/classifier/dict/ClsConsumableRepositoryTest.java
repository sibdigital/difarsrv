package ru.sibdigital.difar.repository.classifier.dict;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.sibdigital.difar.domain.classifier.accs.ClsUserEntity;
import ru.sibdigital.difar.domain.classifier.dict.ClsConsumableEntity;
import ru.sibdigital.difar.domain.classifier.dict.ClsConsumableKindEntity;
import ru.sibdigital.difar.domain.classifier.dict.ClsUnitEntity;
import ru.sibdigital.difar.repository.classifier.base.ClsBaseRepositoryTest;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClsConsumableRepositoryTest extends ClsBaseRepositoryTest {

    @Autowired
    private ClsConsumableRepository repository;

    private ClsConsumableEntity getEntityForSave() {
        String number = "00001";
        String name = "Расходный материал";

        ClsUserEntity user = userRepository.findById(DEFAULT_ID).get();
        ClsConsumableKindEntity consumableKindEntity = consumableKindRepository.findById(DEFAULT_ID).get();
        ClsUnitEntity unitEntity = unitRepository.findById(DEFAULT_ID).get();
        ClsConsumableEntity entity = new ClsConsumableEntity();
        entity.setName(name)
                .setNumber(number)
                .setIdUserCreator(user.getId())
                .setClsConsumableKindByIdConsumableKind(consumableKindEntity)
                .setClsUnitByIdUnit(unitEntity);

        return entity;
    }

    @Test
    public void findDefaultEntryTest() {
        ClsConsumableEntity entity = repository.findById(DEFAULT_ID).get();
        assertNotNull(entity);
    }

    @Test
    public void CRUDTest() throws Exception {
        // сохранение
        ClsConsumableEntity entity = getEntityForSave();
        ClsConsumableEntity saved = repository.save(entity);
        assertNotNull(saved);
        assertNotEquals(saved.getId(), 0L);

        // обновление
        ClsConsumableEntity forUpdate = repository.findByName(entity.getName());
        String duplicateName = entity.getName() + entity.getName();
        forUpdate.setName(duplicateName);
        repository.save(forUpdate);
        ClsConsumableEntity updated = repository.findByName(duplicateName);
        assertEquals(updated.getName(), duplicateName);
        assertNotEquals(updated.getName(), entity.getName());//????

        // чтение
        ClsConsumableEntity byNumber = repository.findByNumber(entity.getNumber());
        assertNotNull(byNumber);
        assertEquals(updated, byNumber);

        // удаление
        repository.delete(entity);
        Optional<ClsConsumableEntity> optional = repository.findById(entity.getId());
        assertFalse(optional.isPresent());
    }

}