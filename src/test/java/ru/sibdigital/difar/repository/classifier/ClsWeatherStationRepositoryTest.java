package ru.sibdigital.difar.repository.classifier;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.sibdigital.difar.domain.classifier.agrc.ClsWeatherStationEntity;
import ru.sibdigital.difar.repository.classifier.agrc.ClsWeatherStationRepository;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClsWeatherStationRepositoryTest extends AbstractClsTest {

    @Autowired
    private ClsWeatherStationRepository clsWeatherStationRepository;

    @Test
    public void findByIdTest() {
        ClsWeatherStationEntity clsWeatherStationEntity = clsWeatherStationRepository.findById(1L).get();
        assertNotNull(clsWeatherStationEntity);
    }

}