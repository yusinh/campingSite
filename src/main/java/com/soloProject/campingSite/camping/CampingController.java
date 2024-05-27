package com.soloProject.campingSite.camping;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class CampingController {

    @GetMapping("/update")
    public String update() {

        return "camping_update";
    }

}
