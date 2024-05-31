package com.soloProject.campingSite.camping;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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

        @NotNull(message = "가격을 입력해주세요.")
        @Min(value = 1, message = "가격은 1 이상이어야 합니다.")
        private Long amount;

        @NotNull(message = "수용 가능인원을 입력해주세요.")
        @Min(value = 1, message = "수용 가능인원은 1 이상이어야 합니다.")
        private Long personnel;

        @NotEmpty(message = "부가 설명을 입력해주세요.")
        private String description;
    }

    @PostMapping("/create")
    public String create(Model model, @Valid CampingForm campingForm, BindingResult bindingResult, @RequestParam("localId") Long localId) {

        if (bindingResult.hasErrors()) {
            return "create";
        }

        campingService.create(
                campingForm.getCampingName(),
                campingForm.getAddress(),
                campingForm.getAmount(),
                campingForm.getPersonnel(),
                campingForm.getDescription(),
                localId
        );
        return "redirect:/";
    }

    @GetMapping("/create")
    public String create(CampingForm campingForm) { return "create"; }





}