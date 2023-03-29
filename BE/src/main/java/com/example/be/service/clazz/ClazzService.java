package com.example.be.service.clazz;

import com.example.be.model.Clazz;
import com.example.be.repository.IClazzRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClazzService implements IClazzService{

    @Autowired
    private IClazzRepository clazzRepository;
    @Override
    public List<Clazz> display() {
        return clazzRepository.display();
    }
}
