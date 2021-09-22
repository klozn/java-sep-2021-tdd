package com.switchfully.programming.advanced.integration.testing.laundry;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "laundries")
public class LaundryController {

    private final LaundryService laundryService;

    public LaundryController(LaundryService laundryService) {
        this.laundryService = laundryService;
    }

    @GetMapping(produces = "application/json")
    public List<LaundryDTO> getAllLaundries(){
        return laundryService.getAllLaundries();
    }

    @PostMapping(consumes = "application/json")
    public void addLaundry(@RequestBody LaundryDTO laundryDTO){
        laundryService.addLaundry(laundryDTO);
    }
}
