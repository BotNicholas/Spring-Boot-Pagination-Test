package org.botnicholas.projects.demopagination.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.botnicholas.projects.demopagination.model.Page;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PagesResponse {
    List<Page> pages;
    Integer totalPages;
    Integer totalElements;
    Integer previousPage;
    Integer currentPage;
    Integer nextPage;

}
