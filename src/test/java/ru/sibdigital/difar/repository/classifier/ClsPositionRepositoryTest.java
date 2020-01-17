package ru.sibdigital.difar.repository.classifier;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.sibdigital.difar.domain.classifier.org.ClsPositionEntity;
import ru.sibdigital.difar.repository.classifier.org.ClsPositionRepository;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClsPositionRepositoryTest extends AbstractClsTest {

    @Autowired
    private ClsPositionRepository clsPositionRepository;

    @Test
    public void findByIdTest() {
        ClsPositionEntity clsPositionEntity = clsPositionRepository.findById(1L).get();
        assertNotNull(clsPositionEntity);
    }

}