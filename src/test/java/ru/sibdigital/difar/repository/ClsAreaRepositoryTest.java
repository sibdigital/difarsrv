package ru.sibdigital.difar.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.sibdigital.difar.domain.ClsAreaEntity;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClsAreaRepositoryTest {

    @Autowired
    private ClsAreaRepository clsAreaRepository;

    @Test
    public void findByIdTest() {
        ClsAreaEntity clsAreaEntity = clsAreaRepository.findById(1L).get();
        assertNotNull(clsAreaEntity);
    }

}