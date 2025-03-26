package org.botnicholas.projects.demopagination.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.botnicholas.projects.demopagination.model.Page;
import org.botnicholas.projects.demopagination.model.dto.PagesResponse;
import org.botnicholas.projects.demopagination.model.test.Test;
import org.botnicholas.projects.demopagination.service.PagesService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pages")
@AllArgsConstructor
public class PagesController {
    private final PagesService pagesService;

    private final Test test;

    @GetMapping("/say")
    public void say() {
        test.saySomething();
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
