package ru.sibdigital.difar.repository.classifier;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.sibdigital.difar.domain.classifier.accs.ClsUserEntity;
import ru.sibdigital.difar.domain.classifier.breed.ClsAgeSexGroupEntity;
import ru.sibdigital.difar.repository.classifier.breed.ClsAgeSexGroupRepository;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClsAgeSexGroupRepositoryTest extends AbstractClsTest {

    @Autowired
    private ClsAgeSexGroupRepository ageSexGroupRepository;

    private ClsAgeSexGroupEntity getEntityForSave() {
        String code = "А-00001";
        String number = "00001";
        String name = "Молодняк";
        Integer beginAgeInDays = 90;
        Integer endAgeInDays = 365;

        final ClsUserEntity user = userRepository.findById(DEFAULT_ID).get();
        final ClsAgeSexGroupEntity saveAgeSexGroupEntity = new ClsAgeSexGroupEntity();
        saveAgeSexGroupEntity.setCode(code);
        saveAgeSexGroupEntity.setName(name);
        saveAgeSexGroupEntity.setNumber(number);
        saveAgeSexGroupEntity.setSex(FEMALE);
        saveAgeSexGroupEntity.setBeginAge(beginAgeInDays);
        saveAgeSexGroupEntity.setEndAge(endAgeInDays);
        saveAgeSexGroupEntity.setIdUserCreator(user.getId());

        return saveAgeSexGroupEntity;
    }

    @Test
    public void findDefaultEntryTest() {
        ClsAgeSexGroupEntity clsAgeSexGroupEntity = ageSexGroupRepository.findById(DEFAULT_ID).get();
        assertNotNull(clsAgeSexGroupEntity);
    }

    @Test
    public void CRUDTest() throws Exception {
        // сохранение
        ClsAgeSexGroupEntity entity = getEntityForSave();
        ClsAgeSexGroupEntity saved = ageSexGroupRepository.save(entity);
        assertNotNull(saved);
        assertNotEquals(saved.getId(), 0L);

        // обновление
        ClsAgeSexGroupEntity forUpdate = ageSexGroupRepository.findByName(entity.getName());
        String duplicateName = entity.getName() + entity.getName();
        forUpdate.setName(duplicateName);
        ageSexGroupRepository.save(forUpdate);
        ClsAgeSexGroupEntity updated = ageSexGroupRepository.findByName(duplicateName);
        assertEquals(updated.getName(), duplicateName);
        assertNotEquals(updated.getName(), entity.getName());//????

        // чтение
        ClsAgeSexGroupEntity byNumber = ageSexGroupRepository.findByNumber(entity.getNumber());
        assertNotNull(byNumber);
        assertEquals(updated, byNumber);

        // удаление
        ageSexGroupRepository.delete(entity);
    }

}