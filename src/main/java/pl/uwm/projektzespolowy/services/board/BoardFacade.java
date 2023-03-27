package pl.uwm.projektzespolowy.services.board;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.uwm.projektzespolowy.models.board.BoardCreateDTO;
import pl.uwm.projektzespolowy.models.board.BoardResponseDTO;
import pl.uwm.projektzespolowy.models.board.BoardUpdateDTO;
import pl.uwm.projektzespolowy.models.board.BoardUserUpdateDTO;
import pl.uwm.projektzespolowy.models.user.User;
import pl.uwm.projektzespolowy.models.user.UserResponseDTO;
import pl.uwm.projektzespolowy.services.board.crud.BoardCRUDService;
import pl.uwm.projektzespolowy.services.user.crud.UserCRUDService;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class BoardFacade {

    private final BoardCRUDService boardCRUDService;
    private final UserCRUDService userCRUDService;

    public BoardResponseDTO createBoard(BoardCreateDTO boardCreateDTO) {
        var creatorId = Long.parseLong(boardCreateDTO.userId());
        var creator = userCRUDService.getUserById(creatorId);
        return boardCRUDService.createBoard(creator, boardCreateDTO.title()).toDto();
    }

    public BoardResponseDTO getBoardById(Long boardId) {
        return boardCRUDService.getBoardById(boardId).toDto();
    }

    public String getBoardTitleById(String boardId) {
        var id = Long.parseLong(boardId);
        return boardCRUDService.getBoardTitleById(id).toString();
    }

    public List<UserResponseDTO> getAllAssignedUsersToBoard(Long boardId) {
        return boardCRUDService
                .getAllAssignedUsersToBoard(boardId)
                .stream()
                .map(User::toDto)
                .sorted(Comparator.comparing(UserResponseDTO::firstName)
                        .thenComparing(UserResponseDTO::lastName))
                .collect(Collectors.toList());
    }

    public BoardResponseDTO updateBoard(BoardUpdateDTO boardUpdateDTO) {
        var boardId = Long.parseLong(boardUpdateDTO.boardId());
        var newTitle = boardUpdateDTO.newTitle();
        return boardCRUDService.updateBoard(boardId, newTitle).toDto();
    }

    public List<UserResponseDTO> assignUserToBoard(BoardUserUpdateDTO boardUserUpdateDTO) {
        var userToAssign = userCRUDService.getUserByEmail(boardUserUpdateDTO.userEmail());
        var boardId = Long.parseLong(boardUserUpdateDTO.boardId());
        return boardCRUDService
                .assignUserToBoard(boardId, userToAssign)
                .stream()
                .map(User::toDto)
                .sorted(Comparator.comparing(UserResponseDTO::firstName)
                        .thenComparing(UserResponseDTO::lastName))
                .collect(Collectors.toList());
    }

    public void deleteBoard(Long boardId) {
        boardCRUDService.deleteBoard(boardId);
    }

    public List<UserResponseDTO> deleteAssignedUserFromBoard(BoardUserUpdateDTO boardUserUpdateDTO) {
        var boardId = Long.parseLong(boardUserUpdateDTO.boardId());
        var userToDeleteFromBoard = userCRUDService.getUserByEmail(boardUserUpdateDTO.userEmail());
        return boardCRUDService
                .deleteAssignedUserFromBoard(boardId, userToDeleteFromBoard)
                .stream()
                .map(User::toDto)
                .sorted(Comparator.comparing(UserResponseDTO::firstName)
                        .thenComparing(UserResponseDTO::lastName))
                .collect(Collectors.toList());
    }

}
