package com.soloProject.campingSite;

import com.soloProject.campingSite.local.Local;
import com.soloProject.campingSite.local.LocalService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Getter
@Setter
public class MainController {

    private final LocalService localService;

    @GetMapping("/")
    public String main(Model model) {
        List<Local> localList = localService.getLocalList();
        model.addAttribute("localList", localList);

        return "main";
    }
}
