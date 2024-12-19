package kos.mo.book.controller;

import kos.mo.book.dto.ResponseDTO;
import kos.mo.book.dto.TestDTO;
import kos.mo.book.repository.TestRepository;
import kos.mo.book.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class TestRestController {

    private final TestService testService;
    private final TestRepository testRepository;

    @GetMapping("/getTest")
    public List<TestDTO> getAll(){
        return testService.getAll();
    }

    @GetMapping("/getTest/{id}")
    public TestDTO getData(@PathVariable("id") Long id){
        return testService.getTest(id);
    }

    @PostMapping("/saveTest")
    public ResponseEntity<String > addData(TestDTO testDTO) {
        testService.saveTest(testDTO);
        return ResponseEntity.ok("저장완료");
    }

    @PostMapping("/updateTest/{id}")
    public ResponseEntity<String> updateData(@RequestBody TestDTO testDTO) {
        testService.updateTest(testDTO);
        return ResponseEntity.ok("수정완료");
    }

    @DeleteMapping("/deleteTest/{id}")
    public ResponseEntity<String> deleteData(@PathVariable("id") Long id) {
        testService.deleteTest(id);
        return ResponseEntity.ok("삭제완료");
    }
}
