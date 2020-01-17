package ru.sibdigital.difar.repository.classifier;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.sibdigital.difar.domain.classifier.agrc.ClsGpsModuleEntity;
import ru.sibdigital.difar.repository.classifier.agrc.ClsGpsModuleRepository;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClsGpsModuleRepositoryTest extends AbstractClsTest {

    @Autowired
    private ClsGpsModuleRepository clsGpsModuleRepository;

    @Test
    public void findByIdTest() {
        ClsGpsModuleEntity clsGpsModuleEntity = clsGpsModuleRepository.findById(1L).get();
        assertNotNull(clsGpsModuleEntity);
    }
}