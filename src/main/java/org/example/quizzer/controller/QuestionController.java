package org.example.quizzer.controller;

import org.example.quizzer.model.Question;
import org.example.quizzer.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("questions")
public class QuestionController {

    @Autowired //inject object of service class using autowire
    QuestionService questionService;

    //get all questions
    @GetMapping("allQuestions")
    public ResponseEntity <List<Question>> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    //get question by category
    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getAllQuestionsByCategory(@PathVariable String category) {
        try {
            List<Question> questions = questionService.getQuestionsByCategory(category).getBody();
            return new ResponseEntity<>(questions, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(List.of(), HttpStatus.BAD_REQUEST);
        }
    }
    //add question
    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);
    }

}
