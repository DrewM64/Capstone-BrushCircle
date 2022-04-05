import axios from 'axios';

import * as types from '../redux/constants';
import { register as registerAPI } from "../api/api";

export const uploadProfilePicture = (formData) => async (dispatch) => {
    //send to the backend
    axios.post("http://localhost:8080/reactuploadprofileimage", formData).then((response) => {
        const data = (response.data);
        dispatch({ type: types.PROFILE_PHOTO_UPLOADED, payload: data });
    }).catch((error) => {
        console.log(error);
    })

}

export const resetProfilePicture = () => async (dispatch) => {
    dispatch({ type: types.RESET_PROFILE_PHOTO });
}

export const register = (userData) => async (dispatch) => {
    try {
        const response = await registerAPI(userData);
        console.log(response);
    } catch (error) {
        console.log(error);
    }
}