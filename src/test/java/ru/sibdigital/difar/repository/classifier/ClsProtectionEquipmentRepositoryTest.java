package ru.sibdigital.difar.repository.classifier;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.sibdigital.difar.domain.classifier.agrc.ClsProtectionEquipmentEntity;
import ru.sibdigital.difar.repository.classifier.agrc.ClsProtectionEquipmentRepository;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClsProtectionEquipmentRepositoryTest extends AbstractClsTest {

    @Autowired
    private ClsProtectionEquipmentRepository clsProtectionEquipmentRepository;

    @Test
    public void findByIdTest() {
        ClsProtectionEquipmentEntity clsProtectionEquipmentEntity = clsProtectionEquipmentRepository.findById(1L).get();
        assertNotNull(clsProtectionEquipmentEntity);
    }
}