package kos.mo.book.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "FORM")
@SequenceGenerator(name = "FORM_SEQ_GEN", //시퀀스 제너레이터명
        sequenceName = "FORM_SEQ",  //시퀀스명
        initialValue = 1, //시작값
        allocationSize = 1 //시퀀스 증가 단위
)
public class FormEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FORM_SEQ_GEN")
    @Column(name = "ID")
    private  Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "AGE")
    private int age;

    @Column(name = "ROLE")
    private String role;
}
