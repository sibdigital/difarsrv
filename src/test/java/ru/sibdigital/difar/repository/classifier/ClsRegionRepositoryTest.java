package ru.sibdigital.difar.repository.classifier;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.sibdigital.difar.domain.classifier.dict.ClsRegionEntity;
import ru.sibdigital.difar.repository.classifier.dict.ClsRegionRepository;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClsRegionRepositoryTest extends AbstractClsTest {

    @Autowired
    private ClsRegionRepository clsRegionRepository;

    @Test
    public void findByIdTest() {
        ClsRegionEntity clsRegionEntity = clsRegionRepository.findById(1L).get();
        assertNotNull(clsRegionEntity);
    }

}