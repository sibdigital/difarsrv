package ru.sibdigital.difar.repository.classifier.org;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.sibdigital.difar.domain.classifier.accs.ClsUserEntity;
import ru.sibdigital.difar.domain.classifier.dict.ClsDistrictEntity;
import ru.sibdigital.difar.domain.classifier.dict.ClsOrganizationEntity;
import ru.sibdigital.difar.domain.classifier.org.ClsDepartEntity;
import ru.sibdigital.difar.domain.classifier.org.ClsRanchEntity;
import ru.sibdigital.difar.repository.classifier.base.ClsBaseRepositoryTest;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClsRanchRepositoryTest extends ClsBaseRepositoryTest {

    @Autowired
    private ClsRanchRepository repository;

    private ClsRanchEntity getEntityForSave() {
        String number = "00001";
        String name = "Ферма";

        ClsUserEntity user = userRepository.findById(DEFAULT_ID).get();
        ClsDepartEntity departEntity = departRepository.findById(DEFAULT_ID).get();
        ClsDistrictEntity districtEntity = districtRepository.findById(DEFAULT_ID).get();
        ClsOrganizationEntity organizationEntity = organizationRepository.findById(DEFAULT_ID).get();
        ClsRanchEntity entity = new ClsRanchEntity();
        entity.setName(name)
                .setNumber(number)
                .setIdUserCreator(user.getId())
                .setClsOrganizationByIdOrganization(organizationEntity)
                .setClsDepartByIdDepart(departEntity)
                .setClsDistrictByIdDistrict(districtEntity);
        return entity;
    }

    @Test
    public void findDefaultEntryTest() {
        ClsRanchEntity entity = repository.findById(DEFAULT_ID).get();
        assertNotNull(entity);
    }

    @Test
    public void CRUDTest() throws Exception {
        // сохранение
        ClsRanchEntity entity = getEntityForSave();
        ClsRanchEntity saved = repository.save(entity);
        assertNotNull(saved);
        assertNotEquals(saved.getId(), 0L);

        // обновление
        ClsRanchEntity forUpdate = repository.findByName(entity.getName());
        String duplicateName = entity.getName() + entity.getName();
        forUpdate.setName(duplicateName);
        repository.save(forUpdate);
        ClsRanchEntity updated = repository.findByName(duplicateName);
        assertEquals(updated.getName(), duplicateName);
        assertNotEquals(updated.getName(), entity.getName());//????

        // чтение
        ClsRanchEntity byNumber = repository.findByNumber(entity.getNumber());
        assertNotNull(byNumber);
        assertEquals(updated, byNumber);

        // удаление
        repository.delete(entity);
        Optional<ClsRanchEntity> optional = repository.findById(entity.getId());
        assertFalse(optional.isPresent());
    }
}