package ru.sibdigital.difar.repository.classifier;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.sibdigital.difar.domain.classifier.breed.ClsTypeAnimalEventEntity;
import ru.sibdigital.difar.repository.classifier.breed.ClsTypeAnimalEventRepository;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClsTypeAnimalEventRepositoryTest extends AbstractClsTest {

    @Autowired
    private ClsTypeAnimalEventRepository clsTypeAnimalEventRepository;

    @Test
    public void findByIdTest() {
        ClsTypeAnimalEventEntity clsTypeAnimalEventEntity = clsTypeAnimalEventRepository.findById(1L).get();
        assertNotNull(clsTypeAnimalEventEntity);
    }

}