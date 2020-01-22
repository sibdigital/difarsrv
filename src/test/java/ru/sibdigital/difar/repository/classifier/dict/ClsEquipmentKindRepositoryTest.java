package ru.sibdigital.difar.repository.classifier.dict;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.sibdigital.difar.domain.classifier.accs.ClsUserEntity;
import ru.sibdigital.difar.domain.classifier.dict.ClsEquipmentKindEntity;
import ru.sibdigital.difar.domain.classifier.dict.ClsEquipmentTypeEntity;
import ru.sibdigital.difar.repository.classifier.base.ClsBaseTest;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClsEquipmentKindRepositoryTest extends ClsBaseTest {

    @Autowired
    private ClsEquipmentKindRepository repository;

    private ClsEquipmentKindEntity getEntityForSave() {
        String number = "00001";
        String name = "Разновидность оборудования";

        ClsUserEntity user = userRepository.findById(DEFAULT_ID).get();
        ClsEquipmentTypeEntity equipmentTypeEntity = equipmentTypeRepository.findById(DEFAULT_ID).get();
        ClsEquipmentKindEntity entity = new ClsEquipmentKindEntity();
        entity.setName(name)
                .setNumber(number)
                .setIdUserCreator(user.getId())
                .setClsEquipmentTypeByIdEquipmentType(equipmentTypeEntity);

        return entity;
    }

    @Test
    public void findDefaultEntryTest() {
        ClsEquipmentKindEntity clsAgeSexGroupEntity = repository.findById(DEFAULT_ID).get();
        assertNotNull(clsAgeSexGroupEntity);
    }

    @Test
    public void CRUDTest() throws Exception {
        // сохранение
        ClsEquipmentKindEntity entity = getEntityForSave();
        ClsEquipmentKindEntity saved = repository.save(entity);
        assertNotNull(saved);
        assertNotEquals(saved.getId(), 0L);

        // обновление
        ClsEquipmentKindEntity forUpdate = repository.findByName(entity.getName());
        String duplicateName = entity.getName() + entity.getName();
        forUpdate.setName(duplicateName);
        repository.save(forUpdate);
        ClsEquipmentKindEntity updated = repository.findByName(duplicateName);
        assertEquals(updated.getName(), duplicateName);
        assertNotEquals(updated.getName(), entity.getName());//????

        // чтение
        ClsEquipmentKindEntity byNumber = repository.findByNumber(entity.getNumber());
        assertNotNull(byNumber);
        assertEquals(updated, byNumber);

        // удаление
        repository.delete(entity);
        Optional<ClsEquipmentKindEntity> optional = repository.findById(entity.getId());
        assertFalse(optional.isPresent());
    }

}