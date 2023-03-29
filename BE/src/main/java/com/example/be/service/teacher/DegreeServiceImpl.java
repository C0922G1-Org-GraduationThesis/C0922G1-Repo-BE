package com.example.be.service.teacher;

import com.example.be.dto.IDegreeDTO;
import com.example.be.model.Degree;
import com.example.be.repository.IDegreeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DegreeServiceImpl implements IDegreeService{
    @Autowired
    private IDegreeRepository iDegreeRepository;
    @Override
    public List<IDegreeDTO> getAllDegree() {
        return iDegreeRepository.getAllDegree();
    }
}
