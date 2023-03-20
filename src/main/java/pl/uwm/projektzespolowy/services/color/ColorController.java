package pl.uwm.projektzespolowy.services.color;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.uwm.projektzespolowy.models.color.ColorRequestDTO;
import pl.uwm.projektzespolowy.models.color.ColorResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/colors")
public class ColorController {

    private final ColorFacade colorFacade;

    @PutMapping("")
    @ResponseStatus(HttpStatus.OK)
    public ColorResponseDTO changeColorTitle(@RequestBody ColorRequestDTO colorRequestDTO) {
        return colorFacade.changeColorTitle(colorRequestDTO);
    }

}
