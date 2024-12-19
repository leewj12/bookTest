package kos.mo.book.service;

import kos.mo.book.dto.TestDTO;
import kos.mo.book.entity.TestEntity;

import java.util.List;

public interface TestService {

    List<TestDTO> getAll();
    TestDTO getTest(Long id);
    TestEntity saveTest(TestDTO testDTO);
    TestEntity updateTest(TestDTO testDTO);
    void deleteTest(Long id);

}
