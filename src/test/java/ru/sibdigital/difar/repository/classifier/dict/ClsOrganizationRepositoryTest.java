package ru.sibdigital.difar.repository.classifier.dict;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.sibdigital.difar.domain.classifier.accs.ClsUserEntity;
import ru.sibdigital.difar.domain.classifier.dict.ClsLegalEntityEntity;
import ru.sibdigital.difar.domain.classifier.dict.ClsOrganizationEntity;
import ru.sibdigital.difar.repository.classifier.base.ClsBaseTest;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClsOrganizationRepositoryTest extends ClsBaseTest {

    @Autowired
    private ClsOrganizationRepository repository;

    private ClsOrganizationEntity getEntityForSave() {
        String number = "00001";
        String name = "Организация";

        ClsUserEntity user = userRepository.findById(DEFAULT_ID).get();
        ClsLegalEntityEntity legalEntity = legalEntityRepository.findById(DEFAULT_ID).get();
        ClsOrganizationEntity entity = new ClsOrganizationEntity();
        entity.setName(name)
                .setNumber(number)
                .setIdUserCreator(user.getId())
                .setClsLegalEntityByIdLegalEntity(legalEntity);

        return entity;
    }

    @Test
    public void findDefaultEntryTest() {
        ClsOrganizationEntity entity = repository.findById(DEFAULT_ID).get();
        assertNotNull(entity);
    }

    @Test
    public void CRUDTest() throws Exception {
        // сохранение
        ClsOrganizationEntity entity = getEntityForSave();
        ClsOrganizationEntity saved = repository.save(entity);
        assertNotNull(saved);
        assertNotEquals(saved.getId(), 0L);

        // обновление
        ClsOrganizationEntity forUpdate = repository.findByName(entity.getName());
        String duplicateName = entity.getName() + entity.getName();
        forUpdate.setName(duplicateName);
        repository.save(forUpdate);
        ClsOrganizationEntity updated = repository.findByName(duplicateName);
        assertEquals(updated.getName(), duplicateName);
        assertNotEquals(updated.getName(), entity.getName());//????

        // чтение
        ClsOrganizationEntity byNumber = repository.findByNumber(entity.getNumber());
        assertNotNull(byNumber);
        assertEquals(updated, byNumber);

        // удаление
        repository.delete(entity);
        Optional<ClsOrganizationEntity> optional = repository.findById(entity.getId());
        assertFalse(optional.isPresent());
    }
}