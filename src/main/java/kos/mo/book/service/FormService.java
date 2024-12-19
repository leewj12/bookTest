package kos.mo.book.service;

import kos.mo.book.dto.FormDTO;
import kos.mo.book.entity.FormEntity;

import java.util.List;

public interface FormService {

    List<FormDTO> getAll();

    FormEntity saveForm(FormDTO formDTO);

    FormEntity updateForm(FormDTO formDTO);

    void deleteById(Long id);

}
