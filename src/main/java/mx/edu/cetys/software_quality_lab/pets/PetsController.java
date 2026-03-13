package mx.edu.cetys.software_quality_lab.pets;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pets") //localhost:8080/pets
public class PetsController {

    //HTTP Verbs: POST, GET, PUT, PATCH, DELETE
    //GET localhost:8080/pets = TODOS los pets, TODO PAGINATION via queryParameters
    //GET localhost:8080/pets/{id} = Pet by ID
    //POST localhost:8080/pets = Nuevo Pet - RequestBody {json body}
    //PUT localhost:8080/pets/{id} = Actualizar Pet por ID
    //DELETE localhost:8080/pets/{id} // Flag available:yes/no

    record Pet(String name, String color, String race){}
    private record PetResponse(String info, Pet pet) {}

    @GetMapping("/help")
    public PetResponse help() {
        return new PetResponse("This is a Help for Pets", null);
    }

}
