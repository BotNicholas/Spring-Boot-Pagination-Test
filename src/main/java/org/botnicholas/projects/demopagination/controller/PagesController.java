package org.botnicholas.projects.demopagination.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.botnicholas.projects.demopagination.model.Page;
import org.botnicholas.projects.demopagination.model.dto.PagesResponse;
import org.botnicholas.projects.demopagination.model.test.PropertyClass;
import org.botnicholas.projects.demopagination.model.test.Test;
import org.botnicholas.projects.demopagination.service.PagesService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/pages")
@AllArgsConstructor
public class PagesController {
    private final PagesService pagesService;

    private final Test test;
    private final PropertyClass propertyClass;

    @GetMapping("/say")
    public String say() {
        return test.saySomething();
    }

    @GetMapping("/enabled-class")
    public String enabledClass() {
        return propertyClass.logInfo();
    }

    //POST body example:
    /*
    {
        "Hello": "World",
        "This is": "a test :D"
    }
    */
    @PostMapping("/send-object")
    public String sendObject(@RequestBody Map<String, String> body) {
        body.entrySet().stream().forEach(entry -> {
            System.out.println(entry.getKey() + " " + entry.getValue());
        });
        return "Success!";
    }

    @GetMapping
    public ResponseEntity<List<Page>> getPages(@RequestParam(name = "page", defaultValue = "0") int page, @RequestParam(name = "size", defaultValue = "1") int size) {
        PagesResponse response = pagesService.getPages(page, size);
        var headers = new HttpHeaders();

        headers.add("total-pages", response.getTotalPages().toString());
        headers.add("total-elements-on-a-page", response.getTotalElements().toString());
        headers.add("prev-page", response.getPreviousPage().toString());
        headers.add("current-page", response.getCurrentPage().toString());
        headers.add("next-page", response.getNextPage().toString());

//        REST Best practices, but for test i used something like this ^
//        headers.set(HttpHeaders.LINK, buildLinks(response));

        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(response.getPages());
    }

//    private String buildLinks(PagesResponse response) {
//        //todo: implement...
//    }
}
