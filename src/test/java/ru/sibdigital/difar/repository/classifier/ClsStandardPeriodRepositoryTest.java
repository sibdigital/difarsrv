package ru.sibdigital.difar.repository.classifier;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.sibdigital.difar.domain.classifier.dict.ClsStandardPeriodEntity;
import ru.sibdigital.difar.repository.classifier.dict.ClsStandardPeriodRepository;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClsStandardPeriodRepositoryTest extends AbstractClsTest {

    @Autowired
    private ClsStandardPeriodRepository clsStandardPeriodRepository;

    @Test
    public void findByIdTest() {
        ClsStandardPeriodEntity ClsStandardPeriodEntity = clsStandardPeriodRepository.findById(1L).get();
        assertNotNull(ClsStandardPeriodEntity);
    }

}