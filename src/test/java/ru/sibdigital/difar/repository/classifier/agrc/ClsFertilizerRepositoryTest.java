package ru.sibdigital.difar.repository.classifier.agrc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.sibdigital.difar.domain.classifier.accs.ClsUserEntity;
import ru.sibdigital.difar.domain.classifier.agrc.ClsFertilizerEntity;
import ru.sibdigital.difar.domain.classifier.dict.ClsUnitEntity;
import ru.sibdigital.difar.repository.classifier.base.ClsBaseRepositoryTest;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClsFertilizerRepositoryTest extends ClsBaseRepositoryTest {

    @Autowired
    private ClsFertilizerRepository repository;

    private ClsFertilizerEntity getEntityForSave() {
        String code = "А-00001";
        String number = "00001";
        String name = "Удобрение";
        ClsUnitEntity unitEntity = unitRepository.findById(DEFAULT_ID).get();

        ClsUserEntity user = userRepository.findById(DEFAULT_ID).get();
        ClsFertilizerEntity entity = new ClsFertilizerEntity();
        entity.setCode(code)
                .setName(name)
                .setNumber(number)
                .setIdUserCreator(user.getId())
                .setClsUnitByIdUnit(unitEntity);

        return entity;
    }

    @Test
    public void findDefaultEntryTest() {
        ClsFertilizerEntity entity = repository.findById(DEFAULT_ID).get();
        assertNotNull(entity);
    }

    @Test
    public void CRUDTest() throws Exception {
        // сохранение
        ClsFertilizerEntity entity = getEntityForSave();
        ClsFertilizerEntity saved = repository.save(entity);
        assertNotNull(saved);
        assertNotEquals(saved.getId(), 0L);

        // обновление
        ClsFertilizerEntity forUpdate = repository.findByName(entity.getName());
        String duplicateName = entity.getName() + entity.getName();
        forUpdate.setName(duplicateName);
        repository.save(forUpdate);
        ClsFertilizerEntity updated = repository.findByName(duplicateName);
        assertEquals(updated.getName(), duplicateName);
        assertNotEquals(updated.getName(), entity.getName());//????

        // чтение
        ClsFertilizerEntity byNumber = repository.findByNumber(entity.getNumber());
        assertNotNull(byNumber);
        assertEquals(updated, byNumber);

        // удаление
        repository.delete(entity);
        Optional<ClsFertilizerEntity> optional = repository.findById(entity.getId());
        assertFalse(optional.isPresent());
    }
}