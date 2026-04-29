package mx.edu.cetys.software_quality_lab.pets;

import mx.edu.cetys.software_quality_lab.pets.exceptions.InvalidPetDataException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pets") //localhost:8080/pets
public class PetController {

    //HTTP Verbs: POST, GET, PUT, PATCH, DELETE
    //GET localhost:8080/pets = TODOS los pets, TODO PAGINATION via queryParameters
    //GET localhost:8080/pets/{id} = Pet by ID
    //POST localhost:8080/pets = Nuevo Pet - RequestBody {json body}
    //PUT localhost:8080/pets/{id} = Actualizar Pet por ID
    //DELETE localhost:8080/pets/{id} // Flag available:yes/no

    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    //DTOs (Data Transfer Object) for Request and Responses
    record PetRequest(String name, String color, String race, Integer age) {}
    record PetResponse(Long id, String name, String color, String race, Integer age) {}

    // Response Generic Wrapper to include standarized info in all our APIs
    public record ApiResponse<T>(String info, T response, String error) {}
    public record PetWrapper(PetResponse pet) {}

    @GetMapping("/help")
    ApiResponse<PetResponse> help() {
        return new ApiResponse<>("This is the help API", null, null);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    ApiResponse<List<PetResponse>> getAllPets() {
        return new ApiResponse<>("Getting all pets", petService.getAllPets(), null);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ApiResponse<PetWrapper> createPet(@RequestBody PetController.PetRequest requestPet) {
        return new ApiResponse<>("New pet was added",
                new PetWrapper(petService.savePet(requestPet)),
                null);
    }

    //GET localhost:8080/pets = TODOS los pets, TODO PAGINATION via queryParameters

    @GetMapping("/{petId}")
    @ResponseStatus(HttpStatus.OK)
    ApiResponse<PetWrapper> findPetById(@PathVariable Long petId) {
        return new ApiResponse<>("Pet found",
                new PetWrapper(petService.getPetById(petId)), null);
    }


//    ApiResponse<PetResponse> getAllPets(@RequestBody PetController.PetRequest requestPet) {
//        return new ApiResponse<>("Getting all pets", petService.getAllPets(requestPet), null);
//    }


}
