package ru.sibdigital.difar.repository.classifier.accs;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.sibdigital.difar.domain.classifier.accs.ClsUserEntity;
import ru.sibdigital.difar.domain.classifier.dict.ClsOrganizationEntity;
import ru.sibdigital.difar.domain.classifier.org.ClsEmployeeEntity;
import ru.sibdigital.difar.repository.classifier.base.ClsBaseTest;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClsUserRepositoryTest extends ClsBaseTest {

    @Autowired
    private ClsUserRepository repository;

    private ClsUserEntity getEntityForSave() {
        String number = "00001";
        String name = "Пользователь";
        ClsOrganizationEntity organizationEntity = organizationRepository.findById(DEFAULT_ID).get();
        ClsEmployeeEntity employeeEntity = employeeRepository.findById(DEFAULT_ID).get();

        ClsUserEntity user = userRepository.findById(DEFAULT_ID).get();
        ClsUserEntity entity = new ClsUserEntity();
        entity.setName(name)
                .setNumber(number)
                .setPassword(DEFAULT_PASSWORD)
                .setIdUserCreator(user.getId())
                .setClsEmployeeByIdEmployee(employeeEntity)
                .setClsOrganizationByIdOrganization(organizationEntity);

        return entity;
    }

    @Test
    public void findDefaultEntryTest() {
        ClsUserEntity entity = repository.findById(DEFAULT_ID).get();
        assertNotNull(entity);
    }

    @Test
    public void CRUDTest() throws Exception {
        // сохранение
        ClsUserEntity entity = getEntityForSave();
        ClsUserEntity saved = repository.save(entity);
        assertNotNull(saved);
        assertNotEquals(saved.getId(), 0L);

        // обновление
        ClsUserEntity forUpdate = repository.findByName(entity.getName());
        String duplicateName = entity.getName() + entity.getName();
        forUpdate.setName(duplicateName);
        repository.save(forUpdate);
        ClsUserEntity updated = repository.findByName(duplicateName);
        assertEquals(updated.getName(), duplicateName);
        assertNotEquals(updated.getName(), entity.getName());//????

        // чтение
        ClsUserEntity byNumber = repository.findByNumber(entity.getNumber());
        assertNotNull(byNumber);
        assertEquals(updated, byNumber);

        // удаление
        repository.delete(entity);
        Optional<ClsUserEntity> optional = repository.findById(entity.getId());
        assertFalse(optional.isPresent());
    }

}