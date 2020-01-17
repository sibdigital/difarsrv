package ru.sibdigital.difar.repository.classifier;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.sibdigital.difar.domain.classifier.agrc.ClsPlantDiseaseEntity;
import ru.sibdigital.difar.repository.classifier.agrc.ClsPlantDiseaseRepository;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClsPlantDiseaseRepositoryTest extends AbstractClsTest {

    @Autowired
    private ClsPlantDiseaseRepository clsPlantDiseaseRepository;

    @Test
    public void findByIdTest() {
        ClsPlantDiseaseEntity clsPlantDiseaseEntity = clsPlantDiseaseRepository.findById(1L).get();
        assertNotNull(clsPlantDiseaseEntity);
    }


}