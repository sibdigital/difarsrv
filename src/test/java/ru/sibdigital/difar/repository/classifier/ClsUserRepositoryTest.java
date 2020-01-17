package ru.sibdigital.difar.repository.classifier;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.sibdigital.difar.domain.classifier.accs.ClsUserEntity;
import ru.sibdigital.difar.repository.classifier.accs.ClsUserRepository;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClsUserRepositoryTest extends AbstractClsTest {

    @Autowired
    private ClsUserRepository clsUserRepository;

    @Test
    public void findByIdTest() {
        ClsUserEntity userEntity = clsUserRepository.findById(1L).get();
        assertNotNull(userEntity);
    }

}