package com.codegym.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class QuestionType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String answer;
    private Long idQuestionType;
    private String dateCreate;
    private String status;
    @OneToMany(mappedBy = "questionType")
    private List <Question> questionList;

    public QuestionType() {
    }

    public QuestionType(Long id, String name, String answer, Long idQuestionType, String dateCreate, String status, List<Question> questionList) {
        this.id = id;
        this.name = name;
        this.answer = answer;
        this.idQuestionType = idQuestionType;
        this.dateCreate = dateCreate;
        this.status = status;
        this.questionList = questionList;
    }
}
