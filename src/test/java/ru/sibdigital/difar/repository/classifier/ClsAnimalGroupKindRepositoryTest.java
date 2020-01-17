package ru.sibdigital.difar.repository.classifier;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.sibdigital.difar.domain.classifier.breed.ClsAnimalGroupKindEntity;
import ru.sibdigital.difar.repository.classifier.breed.ClsAnimalGroupKindRepository;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClsAnimalGroupKindRepositoryTest extends AbstractClsTest {

    @Autowired
    private ClsAnimalGroupKindRepository clsAnimalGroupKindRepository;

    @Test
    public void findByIdTest() {
        ClsAnimalGroupKindEntity clsAnimalGroupKindEntity = clsAnimalGroupKindRepository.findById(1L).get();
        assertNotNull(clsAnimalGroupKindEntity);
    }
}