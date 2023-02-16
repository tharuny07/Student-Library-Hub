package com.example.StudentLibraryManagement.Services;

import com.example.StudentLibraryManagement.DTOs.StudentUpdateMobReqDto;
import com.example.StudentLibraryManagement.Enums.CardStatus;
import com.example.StudentLibraryManagement.Models.Card;
import com.example.StudentLibraryManagement.Models.Student;
import com.example.StudentLibraryManagement.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public String createStudent(Student student)
    {
        Card card=new Card();
        card.setCardStatus(CardStatus.ACTIVATED);//card status is being set
        card.setStudentVariableName(student);//foreignkey attribute
        //filling out the values of unidirectional mapping

        //going to student object
        student.setCard(card);

        //If it an unidirectional mapping we have to save both of them
        //i.e studentRepository.save() cardRepository.save()
        //But we are using bidirectional mapping. Child object saved automatically

        studentRepository.save(student);
        //by cascade effect, child will be automatically saved(cardRepository saved)

        return "Student and card added succesfully";
    }

    public String getNameByEmailId(String emailId){
        Student student=studentRepository.findbyemailId(emailId);
        return student.getName();
    }

    public String updateMobNo(StudentUpdateMobReqDto updateMobReq)
    {
        Student student=new Student();

        Student originalStudent=studentRepository.findById(updateMobReq.getId()).get();
        originalStudent.setMobNo(updateMobReq.getMobNo());

        studentRepository.save(originalStudent);
        return"Mobile Number Updated Succesfully";
    }
}
