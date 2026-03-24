package mx.edu.cetys.software_quality_lab.pets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        // Name length > 2 char
        // Name > 0
        // Color is not empty (extra validation from teacher)

        var savedPet = petRepository.save(
                new Pet(requestPet.name(),
                        requestPet.race(),
                        requestPet.color(),
                        requestPet.age())
        );

        return new PetController.PetResponse(
                savedPet.getId(),
                savedPet.getRace(),
                savedPet.getColor(),
                savedPet.getName(),
                savedPet.getAge()
        );
    }
}
