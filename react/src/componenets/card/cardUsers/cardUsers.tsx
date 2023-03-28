import React from "react";
import {Droppable} from "react-beautiful-dnd";
import {Avatar, AvatarGroup, Tooltip, useTheme} from "@mui/material";
import Typography from "@mui/material/Typography";
import {CardUsersProps} from "@/componenets/card/interfaces/CardUsers/cardUsers";


const CardUsers = (props:CardUsersProps) =>{
    const theme = useTheme()

    return(
                    <AvatarGroup
                        max={4}
                    >
                        {props.assignedUsers.map(user => {
                            return(
                                <Tooltip
                                    key={user.id}
                                    title={user.firstName + " " +user.lastName}
                                    placement={"bottom"}>
                                    <Avatar
                                        sx={{
                                            width: 35,
                                            height: 35,
                                            bgcolor:theme.palette.primary.main
                                        }}
                                    >
                                        <Typography variant={"body1"}>
                                            {user.firstName[0].toUpperCase() + user.lastName[0].toUpperCase()}
                                        </Typography>
                                    </Avatar>
                                </Tooltip>
                            )
                        })}
                        {props.providedDrop.placeholder}
                    </AvatarGroup>
    )
}

export default CardUsers
