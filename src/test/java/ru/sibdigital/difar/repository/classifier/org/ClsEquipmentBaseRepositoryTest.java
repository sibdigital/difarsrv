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
import ru.sibdigital.difar.domain.classifier.org.ClsEquipmentBaseEntity;
import ru.sibdigital.difar.domain.classifier.org.ClsRanchEntity;
import ru.sibdigital.difar.repository.classifier.base.ClsBaseTest;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClsEquipmentBaseRepositoryTest extends ClsBaseTest {

    @Autowired
    private ClsEquipmentBaseRepository repository;

    private ClsEquipmentBaseEntity getEntityForSave() {
        String number = "00001";
        String name = "Оборудование";

        ClsUserEntity user = userRepository.findById(DEFAULT_ID).get();
        ClsDepartEntity departEntity = departRepository.findById(DEFAULT_ID).get();
        ClsDistrictEntity districtEntity = districtRepository.findById(DEFAULT_ID).get();
        ClsOrganizationEntity organizationEntity = organizationRepository.findById(DEFAULT_ID).get();
        ClsRanchEntity ranchEntity = ranchRepository.findById(DEFAULT_ID).get();
        ClsEquipmentBaseEntity entity = new ClsEquipmentBaseEntity();
        entity.setName(name)
                .setNumber(number)
                .setIdUserCreator(user.getId())
                .setClsOrganizationByIdOrganization(organizationEntity)
                .setClsDepartByIdDepart(departEntity)
                .setClsRanchByIdRanch(ranchEntity)
                .setClsDistrictByIdDistrict(districtEntity);
        return entity;
    }

    @Test
    public void findDefaultEntryTest() {
        ClsEquipmentBaseEntity entity = repository.findById(DEFAULT_ID).get();
        assertNotNull(entity);
    }

    @Test
    public void CRUDTest() throws Exception {
        // сохранение
        ClsEquipmentBaseEntity entity = getEntityForSave();
        ClsEquipmentBaseEntity saved = repository.save(entity);
        assertNotNull(saved);
        assertNotEquals(saved.getId(), 0L);

        // обновление
        ClsEquipmentBaseEntity forUpdate = repository.findByName(entity.getName());
        String duplicateName = entity.getName() + entity.getName();
        forUpdate.setName(duplicateName);
        repository.save(forUpdate);
        ClsEquipmentBaseEntity updated = repository.findByName(duplicateName);
        assertEquals(updated.getName(), duplicateName);
        assertNotEquals(updated.getName(), entity.getName());//????

        // чтение
        ClsEquipmentBaseEntity byNumber = repository.findByNumber(entity.getNumber());
        assertNotNull(byNumber);
        assertEquals(updated, byNumber);

        // удаление
        repository.delete(entity);
        Optional<ClsEquipmentBaseEntity> optional = repository.findById(entity.getId());
        assertFalse(optional.isPresent());
    }
}