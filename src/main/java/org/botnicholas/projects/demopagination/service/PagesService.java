package org.botnicholas.projects.demopagination.service;

import lombok.AllArgsConstructor;
import org.botnicholas.projects.demopagination.model.dto.PagesResponse;
import org.botnicholas.projects.demopagination.repo.PagesRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PagesService {
    private final PagesRepo repo;

    public PagesResponse getPages(int pageNumber, int size) {
        var pageable = PageRequest.of(pageNumber, size);
        Page page = repo.findAll(pageable);

        return new PagesResponse(page.getContent(), page.getTotalPages(), page.getSize(), pageNumber > 0 ? pageNumber-1 : 0, pageNumber, pageNumber+1);
    }
}
