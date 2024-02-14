package com.harshit.quizapp.dao;

import com.harshit.quizapp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question,Integer> {
    List<Question> findByCategory(String category);

    @Query(value = "SELECT * FROM Question q WHERE q.category= ?1 ORDER BY RANDOM() LIMIT ?2",nativeQuery = true)
    List<Question> getNRandomQuestionsByCategory(String category, int numQ);
}
