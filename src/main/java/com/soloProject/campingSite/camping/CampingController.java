package com.soloProject.campingSite.camping;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class CampingController {

    private final CampingService campingService;

    @PostMapping("/create")
    public String create(Model model, @Valid CampingForm campingForm, BindingResult bindingResult, @RequestParam("localId") Long localId) throws IOException {

        if (bindingResult.hasErrors()) {
            return "create";
        }

        campingService.create(
                campingForm.getCampingName(),
                campingForm.getAddress(),
                campingForm.getAmount(),
                campingForm.getPersonnel(),
                campingForm.getDescription(),
                localId,
                campingForm.getPhoto()
        );
        return "redirect:/";
    }

    @GetMapping("/create")
    public String create(CampingForm campingForm) {
        return "create";
    }
}
