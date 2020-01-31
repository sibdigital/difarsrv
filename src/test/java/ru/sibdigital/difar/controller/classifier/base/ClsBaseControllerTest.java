package ru.sibdigital.difar.controller.classifier.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import ru.sibdigital.difar.repository.classifier.accs.ClsUserRepository;
import ru.sibdigital.difar.repository.classifier.agrc.ClsCropRepository;
import ru.sibdigital.difar.repository.classifier.breed.ClsKindAnimalRepository;
import ru.sibdigital.difar.repository.classifier.dict.*;
import ru.sibdigital.difar.repository.classifier.org.ClsDepartRepository;
import ru.sibdigital.difar.repository.classifier.org.ClsEmployeeRepository;
import ru.sibdigital.difar.repository.classifier.org.ClsRanchRepository;

public abstract class ClsBaseControllerTest {

    protected static final long DEFAULT_ID = 1L;
    protected static final String DEFAULT_NAME = "Test";
    protected static final String DEFAULT_CODE = "A-00001";
    protected static final String DEFAULT_NUMBER = "1";
    protected static final String UPDATED_NAME = "TestTest";
    protected static final String DEFAULT_PASSWORD = "qwerty";
    protected static final Logger LOG = LoggerFactory.getLogger(ClsBaseControllerTest.class);

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected ClsUserRepository userRepository;

    @Autowired
    protected ClsOrganizationRepository organizationRepository;

    @Autowired
    protected ClsEmployeeRepository employeeRepository;

    @Autowired
    protected ClsCropRepository cropRepository;

    @Autowired
    protected ClsUnitRepository unitRepository;

    @Autowired
    protected ClsKindAnimalRepository kindAnimalRepository;

    @Autowired
    protected ClsRegionRepository regionRepository;

    @Autowired
    protected ClsStandardPeriodRepository standardPeriodRepository;

    @Autowired
    protected ClsDistrictRepository districtRepository;

    @Autowired
    protected ClsConsumableKindRepository consumableKindRepository;

    @Autowired
    protected ClsEquipmentTypeRepository equipmentTypeRepository;

    @Autowired
    protected ClsLegalEntityRepository legalEntityRepository;

    @Autowired
    protected ClsDepartRepository departRepository;

    @Autowired
    protected ClsRanchRepository ranchRepository;

}
