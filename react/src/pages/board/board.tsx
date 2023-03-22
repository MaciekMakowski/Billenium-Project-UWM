import React, {useEffect, useState} from 'react'
import {_Data} from "@/services/utils/boardUtils/DataBoard";
import {fetchData, loadDefaultData} from "@/services/actions/boardService";
import {Stack, useTheme} from "@mui/material";
import {ColorModeContext} from "@/App";
import '@/assets/styles/board.css'
import ModalEditBoard from "@/components/board/modalEditBoard/modalEditBoard";
import BoardHeader from "@/components/board/boardHeader/boardHeader";
import BoardContent from "@/components/board/boardContent/boardContent";
import AddRowButton from "@/components/row/addRowButton/addRowButton";

const Board = () => {
    const [data, setData] = useState<_Data['data']> (loadDefaultData);
    const [modalEdit, setModalEdit] = React.useState(false);
    const theme = useTheme();
    const colorMode = React.useContext(ColorModeContext);
    useEffect(() => {
        document.body.style.backgroundImage = 'none';
        return () => {
            document.body.style.backgroundImage = '';
        };
    }, []);

    React.useEffect(() => {
        // Pobieranie elementu body i ustawienie stylu tła
        document.body.style.backgroundColor = theme.palette.background.default;
    }, [theme]);

    useEffect(() => {
        fetchData(setData);
    }, []);


    return (
        <Stack spacing={2} >
            <BoardHeader data={data} setModalEdit={setModalEdit} setData={setData}/>
            <BoardContent data={data} setData={setData}/>
            <AddRowButton data={data} setData={setData}/>
            <ModalEditBoard
                id={data.id}
                title={data.title}
                modalEdit={modalEdit}
                setModalEdit={setModalEdit}
                data={data}
                setData={setData}
            />
        </Stack>
    );
}

export default Board