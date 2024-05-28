package com.soloProject.campingSite.camping;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class CampingController {

    private final CampingService campingService;

    @Getter
    @Setter
    public class CampingForm {
        @NotEmpty(message = "캠핑장 이름을 입력해주세요.")
        private String campingName;
        @NotEmpty(message = "주소를 입력해주세요.")
        private String address;
        @NotEmpty(message = "가격을 입력해주세요.")
        private Integer amount;
        @NotEmpty(message = "수용 가능인원을 입력해주세요.")
        private Integer personnel;
    }

    @PostMapping("/local/{localId}/create")
    public String create(@PathVariable("localId") Long localId,
                         @Valid CampingForm campingForm,
                         BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "redirect:/";
        }

        this.campingService.create(
                campingForm.getCampingName(),
                campingForm.getAddress(),
                campingForm.getAmount(),
                campingForm.getPersonnel()
        );
        return "redirect:/";
    }


    @GetMapping("/create")
    public String create(CampingForm campingForm) { return "create"; }

    }
