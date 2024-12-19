package kos.mo.book.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "TEST") // 테이블명 대문자로 설정
@SequenceGenerator(name = "TEST_SEQ_GEN", //시퀀스 제너레이터명
        sequenceName = "TEST_SEQ",  //시퀀스명
        initialValue = 1, //시작값
        allocationSize = 1 //시퀀스 증가 단위
)
public class TestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TEST_SEQ_GEN")
    @Column(name = "ID")
    private  Long id;

    @Column(name = "STR")
    private String str;

    @Column(name = "STR2")
    private String str2;

    @Column(name = "STR3")
    private String str3;
}
