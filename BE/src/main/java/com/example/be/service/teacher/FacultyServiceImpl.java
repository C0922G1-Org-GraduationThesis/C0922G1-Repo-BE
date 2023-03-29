package com.example.be.service.teacher;

import com.example.be.dto.IFacultyDTO;
import com.example.be.repository.IFacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FacultyServiceImpl implements IFacultyService{
    @Autowired
    private IFacultyRepository iFacultyRepository;
    @Override
    public List<IFacultyDTO> getAllFaculty() {
        return iFacultyRepository.getAllFaculty();
    }
}
