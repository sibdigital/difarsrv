package ru.sibdigital.difar.repository.classifier.org;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.sibdigital.difar.domain.classifier.accs.ClsUserEntity;
import ru.sibdigital.difar.domain.classifier.dict.ClsLegalEntityEntity;
import ru.sibdigital.difar.domain.classifier.dict.ClsOrganizationEntity;
import ru.sibdigital.difar.domain.classifier.org.ClsDepartEntity;
import ru.sibdigital.difar.repository.classifier.base.ClsBaseTest;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClsDepartRepositoryTest extends ClsBaseTest {

    @Autowired
    private ClsDepartRepository repository;

    private ClsDepartEntity getEntityForSave() {
        String number = "00001";
        String name = "Подразделение";

        ClsUserEntity user = userRepository.findById(DEFAULT_ID).get();
        ClsLegalEntityEntity legalEntity = legalEntityRepository.findById(DEFAULT_ID).get();
        ClsOrganizationEntity organizationEntity = organizationRepository.findById(DEFAULT_ID).get();
        ClsDepartEntity entity = new ClsDepartEntity();
        entity.setName(name)
                .setNumber(number)
                .setIdUserCreator(user.getId())
                .setClsLegalEntityByIdLegalEntity(legalEntity)
                .setClsOrganizationByIdOrganization(organizationEntity);

        return entity;
    }

    @Test
    public void findDefaultEntryTest() {
        ClsDepartEntity entity = repository.findById(DEFAULT_ID).get();
        assertNotNull(entity);
    }

    @Test
    public void CRUDTest() throws Exception {
        // сохранение
        ClsDepartEntity entity = getEntityForSave();
        ClsDepartEntity saved = repository.save(entity);
        assertNotNull(saved);
        assertNotEquals(saved.getId(), 0L);

        // обновление
        ClsDepartEntity forUpdate = repository.findByName(entity.getName());
        String duplicateName = entity.getName() + entity.getName();
        forUpdate.setName(duplicateName);
        repository.save(forUpdate);
        ClsDepartEntity updated = repository.findByName(duplicateName);
        assertEquals(updated.getName(), duplicateName);
        assertNotEquals(updated.getName(), entity.getName());//????

        // чтение
        ClsDepartEntity byNumber = repository.findByNumber(entity.getNumber());
        assertNotNull(byNumber);
        assertEquals(updated, byNumber);

        // удаление
        repository.delete(entity);
        Optional<ClsDepartEntity> optional = repository.findById(entity.getId());
        assertFalse(optional.isPresent());
    }
}