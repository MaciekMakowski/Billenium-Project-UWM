package pl.uwm.projektzespolowy.services.column.crud;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.uwm.projektzespolowy.models.column.Column;
import pl.uwm.projektzespolowy.services.column.ColumnRepository;
import pl.uwm.projektzespolowy.exceptions.EntityNotFoundException;

@Component
@RequiredArgsConstructor
public class ColumnReader {

    private final ColumnRepository columnRepository;

    public Column getColumnById(Long id) {
        return columnRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("column", "Column with id: " + id + " does not exist!"));
    }

}
