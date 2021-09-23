package com.switchfully.programming.advanced.integration.testing.laundry;

import com.switchfully.programming.advanced.integration.testing.time.TimeProvider;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class LaundryMapper {

    private final TimeProvider timeProvider;

    public LaundryMapper(TimeProvider timeProvider) {
        this.timeProvider = timeProvider;
    }

    public List<LaundryDTO> mapToDTO(List<Laundry> laundryList) {
        return laundryList.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    private LaundryDTO mapToDTO(Laundry laundry) {
        LocalDateTime now = timeProvider.getNow();
        return new LaundryDTO(laundry.getType().getLabel(), laundry.getOwner(), laundry.getDescription(), laundry.getTimeUntilCompletion(now), laundry.isDone(now));
    }

    public Laundry mapToEntity(LaundryDTO laundryDTO) {
        return new Laundry(LaundryType.valueOf(laundryDTO.getType().toUpperCase()), laundryDTO.getOwner(), laundryDTO.getDescription(), timeProvider.getNow());
    }
}
