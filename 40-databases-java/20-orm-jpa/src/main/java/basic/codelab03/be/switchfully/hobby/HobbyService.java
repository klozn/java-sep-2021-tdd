package basic.codelab03.be.switchfully.hobby;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class HobbyService {
    private final HobbyRepository repository;

    @Autowired
    public HobbyService(HobbyRepository repository) {
        this.repository = repository;
    }

    public Hobby createNewHobby(String name, String type) {
        int id = repository.save(new Hobby(name, type));
        return repository.findById(id);
    }
}
