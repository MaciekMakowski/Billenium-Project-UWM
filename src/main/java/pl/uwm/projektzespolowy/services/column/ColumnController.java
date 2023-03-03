package pl.uwm.projektzespolowy.services.column;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.uwm.projektzespolowy.models.basic.UpdateDTO;
import pl.uwm.projektzespolowy.models.column.ColumnCreateDTO;
import pl.uwm.projektzespolowy.models.column.ColumnResponseDTO;
import pl.uwm.projektzespolowy.services.column.crud.ColumnCRUDService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/columns")
public class ColumnController {

    private final ColumnCRUDService service;

    @PostMapping("")
    public ColumnResponseDTO createColumn(@RequestBody ColumnCreateDTO columnCreateDTO) {
        return service.createColumn(columnCreateDTO).toDto();
    }

    @GetMapping("/{columnId}")
    public ColumnResponseDTO getColumnById(@PathVariable Long columnId) {
        return service.getColumnById(columnId).toDto();
    }

    @GetMapping("/{boardId}/all")
    public List<ColumnResponseDTO> getAllColumnsByBoardId(@PathVariable Long boardId) {
        return service.getColumnsByBoardId(boardId);
    }

    @PatchMapping("")
    public void updateColumn(@RequestBody UpdateDTO updateDTO) {
        service.updateColumn(updateDTO);
    }

    @DeleteMapping("/{columnId}")
    public void deleteColumnById(@PathVariable Long columnId) {
        service.deleteColumn(columnId);
    }

}
