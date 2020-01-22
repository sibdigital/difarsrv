package ru.sibdigital.difar.repository.classifier.org;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.sibdigital.difar.domain.classifier.org.ClsEquipmentBaseEntity;
import ru.sibdigital.difar.repository.classifier.base.ClsBaseTest;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClsEquipmentBaseRepositoryTest extends ClsBaseTest {

    @Autowired
    private ClsEquipmentBaseRepository clsEquipmentBaseRepository;

    @Test
    public void findByIdTest() {
        ClsEquipmentBaseEntity clsEquipmentBaseEntity = clsEquipmentBaseRepository.findById(1L).get();
        assertNotNull(clsEquipmentBaseEntity);
    }
}