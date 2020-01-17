package ru.sibdigital.difar.repository.classifier;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.sibdigital.difar.domain.classifier.agrc.ClsVegetPeriodEntity;
import ru.sibdigital.difar.repository.classifier.agrc.ClsVegetPeriodRepository;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClsVegetPeriodRepositoryTest extends AbstractClsTest {

    @Autowired
    private ClsVegetPeriodRepository clsVegetPeriodRepository;

    @Test
    public void findByIdTest() {
        ClsVegetPeriodEntity clsVegetPeriodEntity = clsVegetPeriodRepository.findById(1L).get();
        assertNotNull(clsVegetPeriodEntity);
    }

}