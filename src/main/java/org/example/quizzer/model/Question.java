package org.example.quizzer.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Question {

    //model for question table
    @Id //annotaitn to soecify primary key
    @GeneratedValue(strategy = GenerationType.SEQUENCE) //annotation to autogenarate this variable value
    private Integer id;
    private String questionTitle;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String rightAnswer;
    private String difficultyLevel;
    private String category;

}
