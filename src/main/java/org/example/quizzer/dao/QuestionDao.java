package org.example.quizzer.dao;

import org.example.quizzer.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {

    //in here there is no query. Use JPA to understand the column name
    //otherwise we have to write query if there are lot-of customization
    List<Question> findByCategory(String category);

    //this will be a complex find so we write a query
    @Query(value = "SELECT * FROM question q WHERE q.category =:category ORDER BY RANDOM() LIMIT :numQ", nativeQuery = true)
    List<Question> findRandomQuestionsByCategory(String category, int numQ);
}

