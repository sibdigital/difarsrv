package ru.sibdigital.difar.controller.classifier.agrc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.jayway.jsonpath.JsonPath;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MvcResult;
import ru.sibdigital.difar.controller.classifier.base.ClsBaseControllerTest;
import ru.sibdigital.difar.domain.classifier.agrc.ClsWeatherStationEntity;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class ClsWeatherStationControllerTest extends ClsBaseControllerTest {

    @Test
    public void requestsTest() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        ClsWeatherStationEntity entity = new ClsWeatherStationEntity();
        entity.setName(DEFAULT_NAME)
                .setNumber(DEFAULT_NUMBER)
                .setClsOrganizationByIdOrganization(organizationRepository.findById(DEFAULT_ID).get());

        String json = ow.writeValueAsString(entity);

        MvcResult result = this.mockMvc.perform(post("/weather-station/create").contentType("application/json").content(json))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.name").value(DEFAULT_NAME))
                .andDo(print())
                .andReturn();

        String content = result.getResponse().getContentAsString();
        Integer id = JsonPath.parse(content).read("$.id");
        LOG.info("ID = " + id.toString());

        this.mockMvc.perform(get("/weather-station/" + id))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.name").value(DEFAULT_NAME))
                .andDo(print());

        entity.setId(id);
        entity.setName(UPDATED_NAME);
        json = ow.writeValueAsString(entity);

        this.mockMvc.perform(put("/weather-station/update").contentType("application/json").content(json))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.name").value(UPDATED_NAME))
                .andExpect(jsonPath("$.id").value(id))
                .andDo(print());

        this.mockMvc.perform(delete("/weather-station/" + id))
                .andExpect(status().isOk())
                .andExpect(content().string("true"));
    }

}