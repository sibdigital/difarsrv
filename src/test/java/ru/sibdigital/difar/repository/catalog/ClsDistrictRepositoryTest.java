package ru.sibdigital.difar.repository.catalog;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.sibdigital.difar.domain.catalog.accs.ClsUserEntity;
import ru.sibdigital.difar.domain.catalog.dict.ClsDistrictEntity;
import ru.sibdigital.difar.domain.catalog.dict.ClsRegionEntity;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClsDistrictRepositoryTest extends AbstractClsTest {

    @Autowired
    private ClsDistrictRepository clsDistrictRepository;

    @Autowired
    private ClsRegionRepository regionRepository;

    private ClsDistrictEntity districtInDefaultRegion() {
        String number = "00001";
        String name = "Район в регионе по умолчанию";

        final ClsUserEntity user = userRepository.findById(DEFAULT_ID).get();
        final ClsRegionEntity region = regionRepository.findById(DEFAULT_ID).get();

        ClsDistrictEntity entity = new ClsDistrictEntity()
                .setName(name)
                .setNumber(number)
                .setIdUserCreator(user.getId())
                .setClsRegionByIdRegion(region);
        return entity;
    }

    @Test
    public void findById() {
        ClsDistrictEntity clsDistrictEntity = clsDistrictRepository.findById(1L).get();
        assertNotNull(clsDistrictEntity);
    }
}