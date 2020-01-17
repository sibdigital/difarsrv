package ru.sibdigital.difar.repository.classifier;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.sibdigital.difar.domain.classifier.agrc.ClsPlantOrganEntity;
import ru.sibdigital.difar.repository.classifier.agrc.ClsPlantOrganRepository;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClsPlantOrganRepositoryTest extends AbstractClsTest {

    @Autowired
    private ClsPlantOrganRepository clsPlantOrganRepository;

    @Test
    public void findByIdTest() {
        ClsPlantOrganEntity clsPlantOrganEntity = clsPlantOrganRepository.findById(1L).get();
        assertNotNull(clsPlantOrganEntity);
    }
}