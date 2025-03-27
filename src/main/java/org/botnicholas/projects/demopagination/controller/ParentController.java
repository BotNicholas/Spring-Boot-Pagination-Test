package org.botnicholas.projects.demopagination.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/parents")
public class ParentController {
    @GetMapping("/{parentId}")
    public String accessParent(@PathVariable int parentId) {
        return "Hello from Parent " + parentId;
    }
}
