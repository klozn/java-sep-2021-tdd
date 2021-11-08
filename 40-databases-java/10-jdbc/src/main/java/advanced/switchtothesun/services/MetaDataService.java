package advanced.switchtothesun.services;

import advanced.switchtothesun.domain.metadata.MetaDataRepository;
import org.springframework.stereotype.Service;

@Service
public class MetaDataService {

    private final MetaDataRepository repository;

    public MetaDataService(MetaDataRepository repository) {
        this.repository = repository;
    }

    public int incrementNrOfVisits() {
        repository.incrementNrOfVisits();
        return repository.getNumberOfVisits();
    }
}
