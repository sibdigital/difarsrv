package ru.sibdigital.difar.repository.classifier;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.sibdigital.difar.domain.classifier.org.ClsDepartEntity;
import ru.sibdigital.difar.repository.classifier.org.ClsDepartRepository;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClsDepartRepositoryTest extends AbstractClsTest {

    @Autowired
    private ClsDepartRepository clsDepartRepository;

    @Test
    public void findByIdTest() {
        ClsDepartEntity clsDepartEntity = clsDepartRepository.findById(1L).get();
        assertNotNull(clsDepartEntity);
    }
}