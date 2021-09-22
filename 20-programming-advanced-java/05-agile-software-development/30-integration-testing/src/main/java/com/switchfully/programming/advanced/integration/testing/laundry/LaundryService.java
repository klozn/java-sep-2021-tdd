package com.switchfully.programming.advanced.integration.testing.laundry;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class LaundryService {

    private final LaundryRepository laundryRepository;
    private final LaundryMapper laundryMapper;

    public LaundryService(LaundryRepository laundryRepository, LaundryMapper laundryMapper) {
        this.laundryRepository = laundryRepository;
        this.laundryMapper = laundryMapper;
    }

    public List<LaundryDTO> getAllLaundries() {
        return laundryMapper.mapToDTO(laundryRepository.findAll());
    }

    public void addLaundry(LaundryDTO laundryDTO) {
        laundryRepository.save(laundryMapper.mapToEntity(laundryDTO));
    }
}
