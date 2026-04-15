package mx.edu.cetys.software_quality_lab.pets;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

public class PetServiceTest {

    //Service Class: Es la clase donde se ejecuta el negocio / bussiness rules

    //Controller: No hay logica, excepto validacion de valores de entrada

    @InjectMocks
    PetService petService;

    @Mock
    PetRepository petRepository;



    @Test
    void savePet()
    {

        // Arrange

        var petRequest = new PetController.PetRequest("Lu","Negro","Perro",5);

        var mockPetDB = new Pet("Lu", "Negro", "Perro", 5);
        mockPetDB.setId(1L);

        when(petRepository.save(any())).thenReturn(mockPetDB);

        // Act
        var pet = petService.savePet(petRequest);

        // Assert
        Mockito.verify(
                        petRepository, times(1)
                )
                .save(any());

        assertEquals(1L , pet.id());
        assertEquals("Lu", pet.name());
        assertEquals("Perro", pet.race());

        // Recibir la peticion desde el controller (Pet)
        // Verificar los valores del pet:
        // - Edad no sea negativa:
        // - Nombre mas de 2 letras
        // - Salvar a la BD, y la base datos nos regresa el mismo pet pero con ID

    }

    // TODO save pet _ invalid data:

    // TODO get by ID, - get of id 1, but its not in DB
    // 404 Not Found
    @Test
    void getAllPets()
    {

        // Recibir la peticion desde el controller GetAll
        // Query a la BD
        // Mapear los valores del DTO -> Pet Respuesta
        // Si la BD no tiene valores, no fallar request, solo regresar un array vacio

    }
}
