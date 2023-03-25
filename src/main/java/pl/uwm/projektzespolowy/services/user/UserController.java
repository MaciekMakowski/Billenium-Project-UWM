package pl.uwm.projektzespolowy.services.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.uwm.projektzespolowy.models.user.UserBoardsDTO;
import pl.uwm.projektzespolowy.models.user.UserResponseDTO;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserFacade userFacade;

    @GetMapping("/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public UserResponseDTO getUserById(@PathVariable Long userId) {
        return userFacade.getUserById(userId);
    }

    @GetMapping("/{userId}/boards")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<UserBoardsDTO>> getAllUserBoards(@PathVariable Long userId) {
        var userBoards = userFacade.getAllUserBoards(userId);
        return userBoards.size() > 0 ? ResponseEntity.ok(userBoards) : ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUserById(@PathVariable Long userId) {
        userFacade.deleteUser(userId);
    }

}
