package com.example.be.controller;

import com.example.be.dto.AnswerDto;
import com.example.be.dto.QuestionDto;
import com.example.be.model.Answers;
import com.example.be.model.Question;
import com.example.be.service.IAnswerService;
import com.example.be.service.IQuestionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuestionAndAnswerController {
    @Autowired
    private IAnswerService iAnswerService;

    @Autowired
    private IQuestionService iQuestionService;
    private static int size = 0;

    /**
     * Created by: LanTTN,
     * Date created : 29/03/2023
     * Function : show list question
     *
     * @return HttpStatus.OK if result is not error or HttpStatus.NO_CONTENT if no content
     */
    @GetMapping("")
    private ResponseEntity<?> showQuestion() {
        size += 1;
        Pageable pageable = PageRequest.of(0, size);
        Page<Question> questionPage = iQuestionService.findAll(pageable);
        if (questionPage == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(questionPage, HttpStatus.OK);
    }

    /**
     * Created by: LanTTN,
     * Date created : 29/03/2023
     * Function : show answer by question_id
     *
     * @param questionId
     * @return HttpStatus.OK if result is not erroror HttpStatus.NO_CONTENT if no content
     */
    @GetMapping("/answer/{questionId}")
    private ResponseEntity<?> showAnswer(@PathVariable Integer questionId) {
        System.out.println(questionId);
        List<Answers> answersList = iAnswerService.findAll(questionId);
        if (answersList == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(answersList, HttpStatus.OK);
    }

    /**
     * Created by: LanTTN,
     * Date created : 29/03/2023
     * Function : create question by id
     *
     * @param questionDto
     * @return HttpStatus.CREATED if result is not error or HttpStatus.BAD_REQUEST if result is error
     */
    @PostMapping("/save-question")
    private ResponseEntity<?> saveQuestion(@RequestBody QuestionDto questionDto) {
        try {
            Question question = new Question();
            BeanUtils.copyProperties(questionDto, question);
            iQuestionService.save(questionDto.getQuestionContent(), questionDto.getQuestionTopic());
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Created by: LanTTN,
     * Date created : 29/03/2023
     * Function : create answer by id
     *
     * @param answersDto
     * @return HttpStatus.CREATED if result is not error or HttpStatus.BAD_REQUEST if result is error
     */
    @PostMapping("/save-answer")
    private ResponseEntity<?> saveAnswer(@RequestBody AnswerDto answersDto) {
        try {
            Answers answers = new Answers();
            BeanUtils.copyProperties(answersDto, answers);
            iAnswerService.save(answersDto.getAnswerContent(), answersDto.getQuestion().getQuestionId(), answersDto.getTeacher().getTeacherId());
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
