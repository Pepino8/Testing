package mx.edu.cetys.software_quality_lab.pets;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class PetControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc; //Cliente Rest como: Postman/Insomnia

    @Autowired
    private PetRepository petRepository; //Usar el repositorio de perros para las pruebas

    //BeforeAll
    //AfterAll
    //BeforeEach
    //AfterEach

    @BeforeEach
    public void tearDown() {
        // Limpiar la DB despues de cada prueba
        petRepository.deleteAll();
    }

    // Create

    @Test
    //@Named
    void shouldCreatePetAndReturn201() throws Exception {
        String requestBody = """
            {
                "name": "Jose",
                "color": "Negro",
                "race": "Nose",
                "age": 4
            }""";

        mockMvc.perform(
                //Request Setup
                post("/pets")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(requestBody)
                )
                // Assert Mode: ON
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.info")
                        .value("New pet was created"))
                .andExpect(jsonPath("$.response.pet.name")
                                .value("Jose"))
                .andExpect(jsonPath("$.response.pet.color")
                        .value("Negro"))
                .andExpect(jsonPath("$.response.pet.race")
                        .value("Dalmata"))

        //Agregar Mas Asserts
        ;
    }


    // TODO Integration Test for 404
    //  .andExpect(status().isCreated())
    //  but for 404, 400 (invalid input) etc.
/*
NameBuilder.withName("aaron")
.withLastName("rivera")
.withAge(...).create()
*/
}
