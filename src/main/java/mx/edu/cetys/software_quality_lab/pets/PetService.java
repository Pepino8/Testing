package mx.edu.cetys.software_quality_lab.pets;

import mx.edu.cetys.software_quality_lab.pets.exceptions.InvalidPetDataException;
import mx.edu.cetys.software_quality_lab.pets.exceptions.PetNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {
    private final Logger log = LoggerFactory.getLogger(PetService.class);

    //@Autowired Spring since 2014 is able to inject without explicit Autowired aspect/annotation
    private final PetRepository petRepository;

    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    PetController.PetResponse savePet(PetController.PetRequest requestPet) {
        log.info("Starting Pet Request Validations, requestPet={}", requestPet);
        // TODO Validation
        // Name length >= 2 char
        if(requestPet.name().isEmpty()
                || requestPet.name().isBlank()
                || requestPet.name().length() < 2) {
            throw new InvalidPetDataException("Pet name is invalid");
        }
        // TODO regresar un 400 - Invalid data si no se cumple la validacion
        // Age >= 0
        // TODO regresar un 400
        // Color is not empty (extra validation from teacher)

        var savedPet = petRepository.save(
                new Pet(requestPet.name(),
                        requestPet.race(),
                        requestPet.color(),
                        requestPet.age())
        );

        return getPetResponseMapper(savedPet);

    }

    public PetController.PetResponse getPetById(Long petId) {
        log.info("Starting Pet Response Validations, petId={}", petId);
        //Validar si petId es corecto (numerico, mayor a o) else fail with 400
        var petFromDb = petRepository.findById(petId); // Return an optional

        // what if the petFromDB is null? or empty or not found?
        // Do we throw an exception or handle it by the ControllerAdvice
        // YES WE THROW EXCEPTION, AND Handle it in the advicer
        if(petFromDb.isEmpty()) {
            throw new PetNotFoundException("Pet with id " + petId + " not found");
            //throw 404 // TODO Create 404 Exception
        }
        var realPet = petFromDb.get();
        return getPetResponseMapper(realPet);
    }

    public List<PetController.PetResponse> getAllPets() {
        log.info("Getting all pets");
        return petRepository.findAll().stream()
                .map(this::getPetResponseMapper)
                .toList();
    }

    private PetController.PetResponse getPetResponseMapper (Pet realPet){
        return new PetController.PetResponse(
                realPet.getId(),
                realPet.getName(),
                realPet.getColor(),
                realPet.getRace(),
                realPet.getAge()
        );
    }
}
