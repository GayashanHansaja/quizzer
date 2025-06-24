package org.example.quizzer.dao;

import org.example.quizzer.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {

    //in here there is no query. Use JPA to understand the column name
    //ther wise we have to write quesry if there lot of customization
    List<Question> findByCategory(String category);
}
