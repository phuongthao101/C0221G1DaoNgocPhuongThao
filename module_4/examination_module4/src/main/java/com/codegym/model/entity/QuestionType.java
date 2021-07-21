package com.codegym.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String question;
    @ManyToOne
    @JoinColumn(name = "id_question_type", referencedColumnName = "idQuestionType")
    private QuestionType questionType;

    public Question() {
    }

    public Question(Long id, String title, String question, QuestionType questionType) {
        this.id = id;
        this.title = title;
        this.question = question;
        this.questionType = questionType;
    }
}
