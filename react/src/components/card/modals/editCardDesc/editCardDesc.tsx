import React, {useState} from "react";
import {TextField, Typography, useTheme, Box, IconButton, Tooltip} from "@mui/material";
import {EditCardFormProps} from "@/components/card/interfaces/editCardForm/editCardForm";
import {openModal,closeModal} from "@/services/utils/modalUtils/modalUtils";
import BorderColorOutlinedIcon from "@mui/icons-material/BorderColorOutlined";
import CloseIcon from '@mui/icons-material/Close';
import CheckIcon from '@mui/icons-material/Check';
const EditCardDesc = (props:EditCardFormProps) => {
    const theme = useTheme()
    const [isEditing, setIsEditing] = useState(false)

    return(
        <>
            {isEditing && (
                <Box display={"flex"} alignItems={"center"}>
                    <TextField
                        sx={{margin:'0 0 8px 0', width:'80%'}}
                        id="outlined-basic"
                        label="Desc"
                        variant="outlined"
                        multiline={true}
                        maxRows={5}
                        value={props.text}
                        onChange={props.handleChangeText}
                    />
                    <IconButton
                        sx={{
                            maxWidth:'35px',
                            maxHeight:'35px',
                            color:theme.palette.primary.main
                        }}
                        size={"small"}
                        onClick={() => closeModal(setIsEditing)}
                    >
                        <CheckIcon/>
                    </IconButton>
                    <IconButton
                        sx={{
                        maxWidth:'35px',
                        maxHeight:'35px'
                        }}
                        size={"small"}
                        onClick={() => closeModal(setIsEditing)}
                        >
                        <CloseIcon/>
                    </IconButton>
                </Box>
)}
    {!isEditing && (
        <Box
            display={"flex"}
            alignItems={"center"}
            justifyContent={"space-between"}
        >
            <Typography
                textAlign={"left"}
                variant={"body2"}
                color={theme.palette.text.primary}
            >
                {props.text}
            </Typography>
            <Tooltip title={'Edit Description'}>
                <IconButton
                    sx={{
                        maxWidth:'30px',
                        maxHeight:'30px'
                    }}
                    size={"small"}
                    onClick={() => openModal(setIsEditing)}
                >
                    <BorderColorOutlinedIcon
                        sx={{
                            maxWidth:'20px',
                            maxHeight:'20px'
                        }}
                    />
                </IconButton>
            </Tooltip>
        </Box>
    )}
    </>
)
}
export default EditCardDesc