import axios from "axios";
import {urlDomain} from '@/services/actions/boardService'
export async function addCardToBackend(cellId:string, title:string, description:string){

    try{
        const response = await axios.post(urlDomain+'/api/cards', {cellId, title, description})
        return response.data
    }catch(error:any){
        if (error.response && error.response.data && error.response.data.error) {
            return error.response.data.error;
        }
    }

}
export async function updateCardToBackend(cardId:string, title:string, description:string){
    try{
        const response = await axios.put(urlDomain+`/api/cards`, {cardId, title, description})
        return response.data
    }catch(error:any){
        if (error.response && error.response.data && error.response.data.error) {
            return error.response.data.error;
        }
    }

}
export async function moveCardToAnotherCell(cardId:string, newCellId:string, newPosition:number){
    const apiUrl = urlDomain+`/api/cards/another-cell`;
    try {
        const response = await axios.put(apiUrl, {cardId, newCellId,newPosition});
    } catch (error) {
    }
}
export async function moveCardInCell(movedObjectId:string, newPosition:number){
    const apiUrl = urlDomain+`/api/cards/same-cell`;
    try {
        const response = await axios.put(apiUrl, {movedObjectId, newPosition});
    } catch (error) {
    }
}

export async function assignUserToCardToBackend(cardId:string, userId:string){
    const apiUrl = urlDomain+`/api/cards/users/`;
    try {
        const response = await axios.put(apiUrl, {cardId, userId});
        return response.data
    } catch (error:any) {
        if (error.response && error.response.data && error.response.data.error) {
            return error.response.data.error;
        }
    }
}

export async function removeUserFromCardToBackend(cardId:string, userId:string){
    const apiUrl = urlDomain+`/api/cards/users`;
    try {
        const response = await axios.patch(apiUrl, {cardId, userId});
        return response.data
    } catch (error:any) {
        if (error.response && error.response.data && error.response.data.error) {
            return error.response.data.error;
        }
    }
}

export async function removeCardToBackend(cardId:string){
    const apiUrl = urlDomain+`/api/cards/${cardId}`;
    try {
        const response = await axios.delete(apiUrl);
    } catch (error) {
    }
}
