package ru.sibdigital.difar.repository.classifier.org;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.sibdigital.difar.domain.classifier.org.ClsEmployeeEntity;
import ru.sibdigital.difar.repository.classifier.base.ClsBaseTest;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClsEmployeeRepositoryTest extends ClsBaseTest {

    @Autowired
    private ClsEmployeeRepository clsEmployeeRepository;

    @Test
    public void findByIdTest() {
        ClsEmployeeEntity clsEmployeeEntity = clsEmployeeRepository.findById(1L).get();
        assertNotNull(clsEmployeeEntity);
    }
}