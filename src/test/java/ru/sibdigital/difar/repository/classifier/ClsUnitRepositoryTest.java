package ru.sibdigital.difar.repository.classifier;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.sibdigital.difar.domain.classifier.dict.ClsUnitRatioEntity;
import ru.sibdigital.difar.repository.classifier.dict.ClsUnitRadioRepository;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClsUnitRepositoryTest extends AbstractClsTest {

    @Autowired
    private ClsUnitRadioRepository clsUnitRadioRepository;

    @Test
    public void findById() {
        ClsUnitRatioEntity clsUnitRatioEntity = clsUnitRadioRepository.findById(1L).get();
        assertNotNull(clsUnitRatioEntity);
    }

}