package ru.sibdigital.difar.repository.classifier.dict;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.sibdigital.difar.domain.classifier.accs.ClsUserEntity;
import ru.sibdigital.difar.domain.classifier.dict.*;
import ru.sibdigital.difar.repository.classifier.base.ClsBaseRepositoryTest;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClsArbitraryPeriodRepositoryTest extends ClsBaseRepositoryTest {

    @Autowired
    private ClsArbitraryPeriodRepository repository;

    private ClsArbitraryPeriodEntity getEntityForSave() {
        String number = "00001";
        String name = "Период";
        ClsStandardPeriodEntity standardPeriodEntity = standardPeriodRepository.findById(DEFAULT_ID).get();
        ClsUserEntity user = userRepository.findById(DEFAULT_ID).get();
        ClsRegionEntity regionEntity = regionRepository.findById(DEFAULT_ID).get();
        ClsDistrictEntity districtEntity = districtRepository.findById(DEFAULT_ID).get();
        ClsOrganizationEntity organizationEntity = organizationRepository.findById(DEFAULT_ID).get();

        ClsArbitraryPeriodEntity entity = new ClsArbitraryPeriodEntity();
        entity.setName(name)
                .setNumber(number)
                .setIdUserCreator(user.getId())
                .setClsStandardPeriodByIdStandardPeriod(standardPeriodEntity)
                .setClsRegionByIdRegion(regionEntity)
                .setClsDistrictByIdDistrict(districtEntity)
                .setClsOrganizationByIdOrganization(organizationEntity);

        return entity;
    }

    @Test
    public void findDefaultEntryTest() {
        ClsArbitraryPeriodEntity entity = repository.findById(DEFAULT_ID).get();
        assertNotNull(entity);
    }

    @Test
    public void CRUDTest() throws Exception {
        // сохранение
        ClsArbitraryPeriodEntity entity = getEntityForSave();
        ClsArbitraryPeriodEntity saved = repository.save(entity);
        assertNotNull(saved);
        assertNotEquals(saved.getId(), 0L);

        // обновление
        ClsArbitraryPeriodEntity forUpdate = repository.findByName(entity.getName());
        String duplicateName = entity.getName() + entity.getName();
        forUpdate.setName(duplicateName);
        repository.save(forUpdate);
        ClsArbitraryPeriodEntity updated = repository.findByName(duplicateName);
        assertEquals(updated.getName(), duplicateName);
        assertNotEquals(updated.getName(), entity.getName());//????

        // чтение
        ClsArbitraryPeriodEntity byNumber = repository.findByNumber(entity.getNumber());
        assertNotNull(byNumber);
        assertEquals(updated, byNumber);

        // удаление
        repository.delete(entity);
        Optional<ClsArbitraryPeriodEntity> optional = repository.findById(entity.getId());
        assertFalse(optional.isPresent());
    }
}