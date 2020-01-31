package ru.sibdigital.difar.repository.classifier.agrc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.sibdigital.difar.domain.classifier.accs.ClsUserEntity;
import ru.sibdigital.difar.domain.classifier.agrc.ClsVegetPeriodEntity;
import ru.sibdigital.difar.repository.classifier.base.ClsBaseRepositoryTest;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClsVegetPeriodRepositoryTest extends ClsBaseRepositoryTest {

    @Autowired
    private ClsVegetPeriodRepository repository;

    private ClsVegetPeriodEntity getEntityForSave() {
        String number = "00001";
        String name = "Период";
        String code = "А-00001";

        ClsUserEntity user = userRepository.findById(DEFAULT_ID).get();
        ClsVegetPeriodEntity entity = new ClsVegetPeriodEntity();
        entity.setName(name)
                .setNumber(number)
                .setIdUserCreator(user.getId())
                .setCode(code);

        return entity;
    }

    @Test
    public void findDefaultEntryTest() {
        ClsVegetPeriodEntity entity = repository.findById(DEFAULT_ID).get();
        assertNotNull(entity);
    }

    @Test
    public void CRUDTest() throws Exception {
        // сохранение
        ClsVegetPeriodEntity entity = getEntityForSave();
        ClsVegetPeriodEntity saved = repository.save(entity);
        assertNotNull(saved);
        assertNotEquals(saved.getId(), 0L);

        // обновление
        ClsVegetPeriodEntity forUpdate = repository.findByName(entity.getName());
        String duplicateName = entity.getName() + entity.getName();
        forUpdate.setName(duplicateName);
        repository.save(forUpdate);
        ClsVegetPeriodEntity updated = repository.findByName(duplicateName);
        assertEquals(updated.getName(), duplicateName);
        assertNotEquals(updated.getName(), entity.getName());//????

        // чтение
        ClsVegetPeriodEntity byNumber = repository.findByNumber(entity.getNumber());
        assertNotNull(byNumber);
        assertEquals(updated, byNumber);

        // удаление
        repository.delete(entity);
        Optional<ClsVegetPeriodEntity> optional = repository.findById(entity.getId());
        assertFalse(optional.isPresent());
    }

}