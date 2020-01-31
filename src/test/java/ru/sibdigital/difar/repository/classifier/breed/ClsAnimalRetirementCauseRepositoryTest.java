package ru.sibdigital.difar.repository.classifier.breed;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.sibdigital.difar.domain.classifier.accs.ClsUserEntity;
import ru.sibdigital.difar.domain.classifier.breed.ClsAnimalRetirementCauseEntity;
import ru.sibdigital.difar.repository.classifier.base.ClsBaseRepositoryTest;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClsAnimalRetirementCauseRepositoryTest extends ClsBaseRepositoryTest {

    @Autowired
    private ClsAnimalRetirementCauseRepository repository;

    private ClsAnimalRetirementCauseEntity getEntityForSave() {
        String number = "00001";
        String name = "Причина";
        String code = "А-00001";

        ClsUserEntity user = userRepository.findById(DEFAULT_ID).get();
        ClsAnimalRetirementCauseEntity entity = new ClsAnimalRetirementCauseEntity();
        entity.setName(name)
                .setNumber(number)
                .setCode(code)
                .setIdUserCreator(user.getId());

        return entity;
    }

    @Test
    public void findDefaultEntryTest() {
        ClsAnimalRetirementCauseEntity entity = repository.findById(DEFAULT_ID).get();
        assertNotNull(entity);
    }

    @Test
    public void CRUDTest() throws Exception {
        // сохранение
        ClsAnimalRetirementCauseEntity entity = getEntityForSave();
        ClsAnimalRetirementCauseEntity saved = repository.save(entity);
        assertNotNull(saved);
        assertNotEquals(saved.getId(), 0L);

        // обновление
        ClsAnimalRetirementCauseEntity forUpdate = repository.findByName(entity.getName());
        String duplicateName = entity.getName() + entity.getName();
        forUpdate.setName(duplicateName);
        repository.save(forUpdate);
        ClsAnimalRetirementCauseEntity updated = repository.findByName(duplicateName);
        assertEquals(updated.getName(), duplicateName);
        assertNotEquals(updated.getName(), entity.getName());//????

        // чтение
        ClsAnimalRetirementCauseEntity byNumber = repository.findByNumber(entity.getNumber());
        assertNotNull(byNumber);
        assertEquals(updated, byNumber);

        // удаление
        repository.delete(entity);
        Optional<ClsAnimalRetirementCauseEntity> optional = repository.findById(entity.getId());
        assertFalse(optional.isPresent());
    }

}