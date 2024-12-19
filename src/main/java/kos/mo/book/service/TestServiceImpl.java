package kos.mo.book.service;

import kos.mo.book.dto.TestDTO;
import kos.mo.book.entity.TestEntity;
import kos.mo.book.repository.TestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class TestServiceImpl implements TestService{

    private final TestRepository testRepository;

    @Override
    public List<TestDTO> getAll() {
        List<TestEntity> list = null;
        list = testRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));

        List<TestDTO> arrList = list.stream()
                .map(entity -> new TestDTO(
                        entity.getId(),
                        entity.getStr(),
                        entity.getStr2(),
                        entity.getStr3()
                ))
                .collect(Collectors.toList());
        return arrList;
    }

    @Override
    public TestDTO getTest(Long id) {
        Optional<TestEntity> data = testRepository.findById(id);
        if (data.isPresent())
        return data.map(entity -> new TestDTO(entity.getId(),
                entity.getStr(), entity.getStr2(), entity.getStr3())).get();

        return null;
    }

    @Override
    public TestEntity saveTest(TestDTO testDTO) {
        TestEntity createEntity = TestEntity.builder()
                .str(testDTO.getStr())     // testDTO 인스턴스의 메서드 호출
                .str2(testDTO.getStr2())   // testDTO 인스턴스의 메서드 호출
                .str3(testDTO.getStr3())   // testDTO 인스턴스의 메서드 호출
                .build();
        TestEntity entity = testRepository.save(createEntity);
        return entity;
    }

    @Override
    public TestEntity updateTest(TestDTO testDTO) {
        TestEntity existEntity = testRepository.findById(testDTO.getId())
                .orElseThrow(() -> new IllegalArgumentException("no data found"));

        TestEntity createEntity = TestEntity.builder()
                .id(testDTO.getId())
                .str(testDTO.getStr())     // testDTO 인스턴스의 메서드 호출
                .str2(testDTO.getStr2())   // testDTO 인스턴스의 메서드 호출
                .str3(testDTO.getStr3())   // testDTO 인스턴스의 메서드 호출
                .build();
        TestEntity entity = testRepository.save(createEntity);
        return entity;
    }

    @Override
    public void deleteTest(Long id) {
        testRepository.deleteById(id);
    }

}
