package com.example.be.service;

import com.example.be.model.Stage;
import com.example.be.repository.IStageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StageService implements IStageService {
    @Autowired
    private IStageRepository stageRepository;

    @Override
    public List<Stage> findAll() {
        return stageRepository.findAll();
    }

    @Override
    public Stage findById(int id) {
        return stageRepository.findById(id).get();
    }

    @Override
    public void save(Stage stage) {
        stageRepository.save(stage);
    }

    @Override
    public void delete(int id) {
        stageRepository.deleteById(id);
    }
}
