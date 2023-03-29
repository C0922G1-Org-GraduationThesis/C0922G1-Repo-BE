package com.example.be.service.impl;

import com.example.be.dto.ITeacherDto;
import com.example.be.repository.ITeacherRepository;
import com.example.be.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeacherService implements ITeacherService {
    @Autowired
    private ITeacherRepository teacherRepository;

    /**
     * tên : phan văn hùng
     * nội dung:phương thức lấy danh sách giáo viên có tìm kiếm và phân trang
     * tham số truyền vào : tên cần tìm và pageable để phân trang
     * return : page
     */
    @Override
    public Page<ITeacherDto> getAllTeacher(String name, Pageable pageable) {
        return teacherRepository.getAllTeacher(name, pageable);
    }

    /**
     * tên : phan văn hùng
     * nội dung: phuoương thức tìm kiếm theo id
     * tham số truyền vào : id cần tìm kiếm
     * return : teacher
     */
    @Override
    public Optional<ITeacherDto> findTeacherById(Long id) {
        return teacherRepository.findTeacherById(id);
    }

    /**
     * tên : phan văn hùng
     * nội dung:tạo phương thức xóa 1 giáo viên theo id
     * tham số truyền vào : id cần xóa
     * return : trạng thái
     */
    @Override
    public void deleteTeacherById(long id) {
        teacherRepository.deleteTeacherById(id);
    }
}
