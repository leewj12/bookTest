package kos.mo.book.service;

import kos.mo.book.dto.FormDTO;
import kos.mo.book.entity.FormEntity;
import kos.mo.book.repository.FormRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class FormServiceImpl implements FormService{

    private final FormRepository formRepository;

    @Override
    public List<FormDTO> getAll() {
        List<FormEntity> list = null;
        list = formRepository.findAll();

        List<FormDTO> arrList = list.stream()
                .map(entity -> new FormDTO(
                        entity.getId(),
                        entity.getName(),
                        entity.getAge(),
                        entity.getRole()
                ))
                .collect(Collectors.toList());
        return arrList;
    }

    @Override
    public FormEntity saveForm(FormDTO formDTO) {
        FormEntity createEntity = FormEntity.builder()
                .name(formDTO.getName())
                .age(formDTO.getAge())
                .role(formDTO.getRole())
                .build();
        FormEntity entity = formRepository.save(createEntity);
        return entity;
    }

    @Override
    public FormEntity updateForm(FormDTO formDTO) {
        return null;
    }

    @Override
    public void deleteById(Long id) {
        formRepository.deleteById(id);
    }
}
