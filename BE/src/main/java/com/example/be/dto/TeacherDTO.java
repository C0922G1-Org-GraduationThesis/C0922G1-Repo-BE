package com.example.be.dto;

import com.example.be.model.Degree;
import com.example.be.model.Faculty;
import org.springframework.validation.Errors;

import javax.validation.constraints.*;
import java.util.List;

public class TeacherDTO {
    private Long teacherId;
    private String teacherCode;
    //    @Size(max = 50, message = "tên có độ dài tối đa 50 ký tự")
//    @NotEmpty(message = "không được để trống")
    private String teacherName;

    //    @Min(value = 18, message = "Tuổi của bạn phải lớn hơn hoặc bằng 18")
    private String dateOfBirth;

    //    @NotBlank(message = "Email ko được để trống")
//    @Pattern(regexp = "^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "Email sai định dạng")
    private String email;

    //    @NotBlank(message = "Nhập số điện thoại")
//    @Pattern(regexp = "[0][1-9]{9}", message = "Số điện thoại phải có 10 số và bắt đầu bằng 0")
    private String phoneNumber;

    //    @NotBlank(message = "Chọn giới tính")
    private boolean teacherGender;

    //    @NotBlank(message = "Nhập địa chỉ")
    private String teacherAddress;
    private String img;

    //    @NotBlank(message = "Chọn học vị")
    private Faculty faculty;

    //    @NotBlank(message = "Chọn khoa")
    private Degree degree;

    public TeacherDTO() {
    }

    public TeacherDTO(String teacherCode, String teacherName, String dateOfBirth, String email, String phoneNumber, boolean teacherGender, String teacherAddress, String img, Faculty faculty, Degree degree) {
        this.teacherCode = teacherCode;
        this.teacherName = teacherName;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.teacherGender = teacherGender;
        this.teacherAddress = teacherAddress;
        this.img = img;
        this.faculty = faculty;
        this.degree = degree;
    }

    public TeacherDTO(Long teacherId, String teacherCode, String teacherName, String dateOfBirth, String email, String phoneNumber, boolean teacherGender, String teacherAddress, String img, Faculty faculty, Degree degree) {
        this.teacherId = teacherId;
        this.teacherCode = teacherCode;
        this.teacherName = teacherName;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.teacherGender = teacherGender;
        this.teacherAddress = teacherAddress;
        this.img = img;
        this.faculty = faculty;
        this.degree = degree;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherCode() {
        return teacherCode;
    }

    public void setTeacherCode(String teacherCode) {
        this.teacherCode = teacherCode;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isTeacherGender() {
        return teacherGender;
    }

    public void setTeacherGender(boolean teacherGender) {
        this.teacherGender = teacherGender;
    }

    public String getTeacherAddress() {
        return teacherAddress;
    }

    public void setTeacherAddress(String teacherAddress) {
        this.teacherAddress = teacherAddress;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public void checkValidateCreateTeacher(List<IEmailAndPhoneNumberDTO> list, TeacherDTO teacherDTO, Errors errors) {
        if (teacherDTO.getTeacherName().matches("")) {
            errors.rejectValue("teacherName", "teacherName", "Tên giáo viên không được để trống");
        }

        if (teacherDTO.getDateOfBirth().matches("")) {
            errors.rejectValue("dateOfBirth", "dateOfBirth", "Ngày sinh không được để trống");
        }

        if (teacherDTO.getDegree().getDegreeName().matches("")) {
            errors.rejectValue("degree", "degree", "Học vị không được để trống");
        }

        if (teacherDTO.getTeacherAddress().matches("")) {
            errors.rejectValue("teacherAddress", "teacherAddress", "Địa chỉ không được để trống");
        }

        if (teacherDTO.getPhoneNumber().matches("")) {
            errors.rejectValue("phoneNumber", "phoneNumber", "Số điện thoại không được để trống");
        } else {
            for (int i = 0; i < list.size(); i++) {
                if (teacherDTO.getPhoneNumber().equals(list.get(i).getPhoneNumber())){
                    errors.rejectValue("phoneNumber", "phoneNumber", "Số điện thoại đã được sử dụng");
                    break;
                }
            }
        }

        if (teacherDTO.getFaculty() == null) {
            errors.rejectValue("faculty", "faculty", "Học vị không được để trống");
        }

        if (teacherDTO.getEmail().matches("")){
            errors.rejectValue("email", "email", "Email không được để trống");
        } else {
            for (int i = 0; i < list.size(); i++) {
                if(teacherDTO.getEmail().equals(list.get(i).getEmail())){
                    errors.rejectValue("email", "email", "Email đã được sử dụng");
                    break;
                }
            }
        }
    }

    public void checkValidateUpdateTeacher(List<IEmailAndPhoneNumberDTO> list, TeacherDTO teacherDTO, Errors errors) {
        if (teacherDTO.getTeacherName().matches("")) {
            errors.rejectValue("teacherName", "teacherName", "Tên giáo viên không được để trống");
        }

        if (teacherDTO.getDateOfBirth().matches("")) {
            errors.rejectValue("dateOfBirth", "dateOfBirth", "Ngày sinh không được để trống");
        }

        if (teacherDTO.getDegree().getDegreeName().matches("")) {
            errors.rejectValue("degree", "degree", "Học vị không được để trống");
        }

        if (teacherDTO.getTeacherAddress().matches("")) {
            errors.rejectValue("teacherAddress", "teacherAddress", "Địa chỉ không được để trống");
        }

        if (teacherDTO.getPhoneNumber().matches("")) {
            errors.rejectValue("phoneNumber", "phoneNumber", "Số điện thoại không được để trống");
        } else {
            for (int i = 0; i < list.size(); i++) {
                int count = 0;
                if (teacherDTO.getPhoneNumber().equals(list.get(i).getPhoneNumber()) && count==2){
                    errors.rejectValue("phoneNumber", "phoneNumber", "Số điện thoại đã được sử dụng");
                    count++;
                    break;
                }
            }
        }

        if (teacherDTO.getFaculty() == null) {
            errors.rejectValue("faculty", "faculty", "Học vị không được để trống");
        }

        if (teacherDTO.getEmail().matches("")){
            errors.rejectValue("email", "email", "Email không được để trống");
        } else {
            int count = 0;
            for (int i = 0; i < list.size(); i++) {
                if(teacherDTO.getEmail().equals(list.get(i).getEmail()) && count==2){
                    errors.rejectValue("email", "email", "Email đã được sử dụng");
                    count++;
                    break;
                }
            }
        }
    }
}
