package ru.sibdigital.difar.repository.classifier;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.sibdigital.difar.domain.classifier.agrc.ClsFertilizerEntity;
import ru.sibdigital.difar.repository.classifier.agrc.ClsFertilizerRepository;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClsFertilizerRepositoryTest extends AbstractClsTest {

    @Autowired
    private ClsFertilizerRepository clsFertilizerRepository;

    @Test
    public void findByIdTest() {
        ClsFertilizerEntity clsFertilizerEntity = clsFertilizerRepository.findById(1L).get();
        assertNotNull(clsFertilizerEntity);
    }
}