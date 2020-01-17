package ru.sibdigital.difar.repository.classifier;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.sibdigital.difar.domain.classifier.dict.ClsArbitraryPeriodEntity;
import ru.sibdigital.difar.repository.classifier.dict.ClsArbitraryPeriodRepository;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClsArbitraryPeriodRepositoryTest extends AbstractClsTest {

    @Autowired
    private ClsArbitraryPeriodRepository clsArbitraryPeriodRepository;

    @Test
    public void findByIdTest() {
        ClsArbitraryPeriodEntity clsArbitraryPeriodEntity = clsArbitraryPeriodRepository.findById(1L).get();
        assertNotNull(clsArbitraryPeriodEntity);
    }
}