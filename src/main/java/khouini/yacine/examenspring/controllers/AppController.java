package khouini.yacine.examenspring.controllers;

import khouini.yacine.examenspring.services.IAppService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("restApp")
@AllArgsConstructor
public class AppController {
    private final IAppService appService;

    @GetMapping("test")
    public String test() {
        return appService.test();
    }
}
