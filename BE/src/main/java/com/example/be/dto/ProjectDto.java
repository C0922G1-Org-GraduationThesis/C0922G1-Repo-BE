package com.example.be.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ProjectDto {
    private Long teamId;
    private Long studentId;
    private Long projectId;
    private String projectName;
    private String description;

}
