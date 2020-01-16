package ru.sibdigital.difar.repository.catalog;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.sibdigital.difar.domain.catalog.accs.ClsUserEntity;
import ru.sibdigital.difar.domain.catalog.dict.ClsWorkTypeEntity;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClsWorkTypeRepositoryTest extends AbstractClsTest {

    @Autowired
    private ClsWorkTypeRepository clsWorkTypeRepository;

    private ClsWorkTypeEntity workTypeRepair() {
        String number = "00001";
        String name = "Ремонт";
        final ClsUserEntity user = userRepository.findById(DEFAULT_ID).get();
        final ClsWorkTypeEntity entity = new ClsWorkTypeEntity()
                .setName(name)
                .setNumber(number)
                .setIdUserCreator(user.getId())
                .setIdParent(EMPTY_PARENT);
        return entity;
    }

    @Test
    public void findByIdTest() {
        ClsWorkTypeEntity clsWorkTypeEntity = clsWorkTypeRepository.findById(1L).get();
        assertNotNull(clsWorkTypeEntity);
    }

}