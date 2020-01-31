package ru.sibdigital.difar.repository.classifier.agrc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.sibdigital.difar.domain.classifier.accs.ClsUserEntity;
import ru.sibdigital.difar.domain.classifier.agrc.ClsPlantOrganEntity;
import ru.sibdigital.difar.repository.classifier.base.ClsBaseRepositoryTest;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClsPlantOrganRepositoryTest extends ClsBaseRepositoryTest {

    @Autowired
    private ClsPlantOrganRepository repository;

    private ClsPlantOrganEntity getEntityForSave() {
        String number = "00001";
        String name = "Орган";
        String code = "А-00001";

        ClsUserEntity user = userRepository.findById(DEFAULT_ID).get();
        ClsPlantOrganEntity entity = new ClsPlantOrganEntity();
        entity.setName(name)
                .setNumber(number)
                .setIdUserCreator(user.getId())
                .setCode(code);

        return entity;
    }

    @Test
    public void findDefaultEntryTest() {
        ClsPlantOrganEntity entity = repository.findById(DEFAULT_ID).get();
        assertNotNull(entity);
    }

    @Test
    public void CRUDTest() throws Exception {
        // сохранение
        ClsPlantOrganEntity entity = getEntityForSave();
        ClsPlantOrganEntity saved = repository.save(entity);
        assertNotNull(saved);
        assertNotEquals(saved.getId(), 0L);

        // обновление
        ClsPlantOrganEntity forUpdate = repository.findByName(entity.getName());
        String duplicateName = entity.getName() + entity.getName();
        forUpdate.setName(duplicateName);
        repository.save(forUpdate);
        ClsPlantOrganEntity updated = repository.findByName(duplicateName);
        assertEquals(updated.getName(), duplicateName);
        assertNotEquals(updated.getName(), entity.getName());//????

        // чтение
        ClsPlantOrganEntity byNumber = repository.findByNumber(entity.getNumber());
        assertNotNull(byNumber);
        assertEquals(updated, byNumber);

        // удаление
        repository.delete(entity);
        Optional<ClsPlantOrganEntity> optional = repository.findById(entity.getId());
        assertFalse(optional.isPresent());
    }
}