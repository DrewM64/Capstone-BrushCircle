import axios from "axios";
import * as types from '../redux/constants';

export const getFileList = () => async (dispatch) => {
    axios.get("http://localhost:8080/testfilelist").then((response) => {
        dispatch({ type: types.GET_FILE_LIST, payload: response.data });
    }).catch((error) => {
        console.log(error);
    })
}

export const uploadFileToServer = (formData) => async (dispatch) => {
    //send to the backend
    axios.post("http://localhost:8080/reactupload", formData).then((response) => {
        const data = (response.data);
        dispatch({type: types.UPLOAD_FILE, payload: data});
    }).catch((error) => {
        console.log(error);
    })
}