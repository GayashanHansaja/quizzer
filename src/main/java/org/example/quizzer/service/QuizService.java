package org.example.quizzer.service;

import org.example.quizzer.dao.QuestionDao;
import org.example.quizzer.dao.QuizDao;
import org.example.quizzer.model.Question;
import org.example.quizzer.model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;

    //need to fetch questons
    @Autowired
    private QuestionDao questionDao;

    public ResponseEntity<String> createQuiz(String category, int numQ, String quizTitle) {

        List<Question> questions = questionDao.findRandomQuestionsByCategory(category, numQ);
        Quiz quiz = new Quiz();
         quiz.setTitle(quizTitle);
         quiz.setQuestions(questions);
         quizDao.save(quiz);

         return  new ResponseEntity<>("success", HttpStatus.CREATED);
    }
}
