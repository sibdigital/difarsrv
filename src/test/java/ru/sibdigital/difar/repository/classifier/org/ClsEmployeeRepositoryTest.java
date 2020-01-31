package ru.sibdigital.difar.repository.classifier.org;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.sibdigital.difar.domain.classifier.accs.ClsUserEntity;
import ru.sibdigital.difar.domain.classifier.dict.ClsOrganizationEntity;
import ru.sibdigital.difar.domain.classifier.org.ClsDepartEntity;
import ru.sibdigital.difar.domain.classifier.org.ClsEmployeeEntity;
import ru.sibdigital.difar.repository.classifier.base.ClsBaseRepositoryTest;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClsEmployeeRepositoryTest extends ClsBaseRepositoryTest {

    @Autowired
    private ClsEmployeeRepository repository;

    private ClsEmployeeEntity getEntityForSave() {
        String number = "00001";
        String name = "Сотрудник";

        ClsUserEntity user = userRepository.findById(DEFAULT_ID).get();
        ClsDepartEntity departEntity = departRepository.findById(DEFAULT_ID).get();
        ClsOrganizationEntity organizationEntity = organizationRepository.findById(DEFAULT_ID).get();
        ClsEmployeeEntity entity = new ClsEmployeeEntity();
        entity.setName(name)
                .setNumber(number)
                .setIdUserCreator(user.getId())
                .setClsOrganizationByIdOrganization(organizationEntity)
                .setClsDepartByIdDepart(departEntity);

        return entity;
    }

    @Test
    public void findDefaultEntryTest() {
        ClsEmployeeEntity entity = repository.findById(DEFAULT_ID).get();
        assertNotNull(entity);
    }

    @Test
    public void CRUDTest() throws Exception {
        // сохранение
        ClsEmployeeEntity entity = getEntityForSave();
        ClsEmployeeEntity saved = repository.save(entity);
        assertNotNull(saved);
        assertNotEquals(saved.getId(), 0L);

        // обновление
        ClsEmployeeEntity forUpdate = repository.findByName(entity.getName());
        String duplicateName = entity.getName() + entity.getName();
        forUpdate.setName(duplicateName);
        repository.save(forUpdate);
        ClsEmployeeEntity updated = repository.findByName(duplicateName);
        assertEquals(updated.getName(), duplicateName);
        assertNotEquals(updated.getName(), entity.getName());//????

        // чтение
        ClsEmployeeEntity byNumber = repository.findByNumber(entity.getNumber());
        assertNotNull(byNumber);
        assertEquals(updated, byNumber);

        // удаление
        repository.delete(entity);
        Optional<ClsEmployeeEntity> optional = repository.findById(entity.getId());
        assertFalse(optional.isPresent());
    }
}