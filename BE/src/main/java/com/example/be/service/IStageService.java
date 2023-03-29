package com.example.be.service;

import com.example.be.model.ProgressReport;
import com.example.be.model.Project;
import com.example.be.model.Stage;

import java.util.List;

public interface IStageService {
    List<Stage> findAll();

    Stage findById(int id);

    void save(Stage stage);

    void delete(int id);
}
