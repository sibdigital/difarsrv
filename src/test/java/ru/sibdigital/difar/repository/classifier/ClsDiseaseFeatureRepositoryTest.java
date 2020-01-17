package ru.sibdigital.difar.repository.classifier;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.sibdigital.difar.domain.classifier.agrc.ClsDiseaseFeatureEntity;
import ru.sibdigital.difar.repository.classifier.agrc.ClsDiseaseFeatureRepository;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClsDiseaseFeatureRepositoryTest extends AbstractClsTest {

    @Autowired
    private ClsDiseaseFeatureRepository clsDiseaseFeatureRepository;

    @Test
    public void findByIdTest() {
        ClsDiseaseFeatureEntity clsDiseaseFeatureEntity = clsDiseaseFeatureRepository.findById(1L).get();
        assertNotNull(clsDiseaseFeatureEntity);
    }

}