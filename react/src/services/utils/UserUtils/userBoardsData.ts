import React from "react";

export interface userBoard{
    boardId:string
    boardTitle:string
    creatorName:string
}


export interface userBoardsData{
    userBoards: userBoard[];
    setUserBoards: React.Dispatch<React.SetStateAction<userBoard[]>>;
}