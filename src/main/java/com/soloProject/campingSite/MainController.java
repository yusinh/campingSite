package com.soloProject.campingSite;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
@Getter
@Setter
public class MainController {

    @GetMapping("/")
    public String main() {

        return "main_form";
    }
}
