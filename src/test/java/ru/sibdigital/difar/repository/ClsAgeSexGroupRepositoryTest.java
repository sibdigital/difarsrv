package ru.sibdigital.difar.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.sibdigital.difar.domain.ClsAgeSexGroupEntity;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClsAgeSexGroupRepositoryTest {

    @Autowired
    private ClsAgeSexGroupRepository clsAgeSexGroupRepository;

    @Test
    public void findByIdTest() {
        ClsAgeSexGroupEntity clsAgeSexGroupEntity = clsAgeSexGroupRepository.findById(1L).get();
        assertNotNull(clsAgeSexGroupEntity);
    }
}