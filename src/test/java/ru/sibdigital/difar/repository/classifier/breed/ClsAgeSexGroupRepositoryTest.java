package ru.sibdigital.difar.repository.classifier.breed;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.sibdigital.difar.domain.classifier.accs.ClsUserEntity;
import ru.sibdigital.difar.domain.classifier.breed.ClsAgeSexGroupEntity;
import ru.sibdigital.difar.repository.classifier.base.ClsBaseRepositoryTest;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClsAgeSexGroupRepositoryTest extends ClsBaseRepositoryTest {

    @Autowired
    private ClsAgeSexGroupRepository repository;

    private ClsAgeSexGroupEntity getEntityForSave() {
        String code = "А-00001";
        String number = "00001";
        String name = "Молодняк";
        Integer beginAgeInDays = 90;
        Integer endAgeInDays = 365;

        ClsUserEntity user = userRepository.findById(DEFAULT_ID).get();
        ClsAgeSexGroupEntity entity = new ClsAgeSexGroupEntity();
        entity.setCode(code)
                .setName(name)
                .setNumber(number)
                .setSex(MALE)
                .setBeginAge(beginAgeInDays)
                .setEndAge(endAgeInDays)
                .setIdUserCreator(user.getId());

        return entity;
    }

    @Test
    public void findDefaultEntryTest() {
        ClsAgeSexGroupEntity entity = repository.findById(DEFAULT_ID).get();
        assertNotNull(entity);
    }

    @Test
    public void CRUDTest() throws Exception {
        // сохранение
        ClsAgeSexGroupEntity entity = getEntityForSave();
        ClsAgeSexGroupEntity saved = repository.save(entity);
        assertNotNull(saved);
        assertNotEquals(saved.getId(), 0L);

        // обновление
        ClsAgeSexGroupEntity forUpdate = repository.findByName(entity.getName());
        String duplicateName = entity.getName() + entity.getName();
        forUpdate.setName(duplicateName);
        repository.save(forUpdate);
        ClsAgeSexGroupEntity updated = repository.findByName(duplicateName);
        assertEquals(updated.getName(), duplicateName);
        assertNotEquals(updated.getName(), entity.getName());//????

        // чтение
        ClsAgeSexGroupEntity byNumber = repository.findByNumber(entity.getNumber());
        assertNotNull(byNumber);
        assertEquals(updated, byNumber);

        // удаление
        repository.delete(entity);
        Optional<ClsAgeSexGroupEntity> optional = repository.findById(entity.getId());
        assertFalse(optional.isPresent());
    }

}