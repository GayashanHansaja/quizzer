package org.example.quizzer.controller;

import org.example.quizzer.model.Question;
import org.example.quizzer.model.QuestionWrapper;
import org.example.quizzer.model.Quiz;
import org.example.quizzer.model.Response;
import org.example.quizzer.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    // Create a new quiz
    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int numQ, @RequestParam String quizTitle) {
       return quizService.createQuiz(category, numQ, quizTitle);
    }

    // Get quiz questions by quiz ID
    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable int id) {
        return quizService.getQuizQuestions(id);
    }

    // Submit quiz responses and calculate result
    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<Response> responses) {
        return quizService.calculateResult(id, responses);
    }
}
