import axios from 'axios';

import * as types from '../redux/constants';
import { userData } from '../data/mockData'
import { register, login } from '../api/api';

export const uploadProfilePicture = (formData) => async (dispatch) => {
    //send to the backend
    axios.post("http://localhost:8080/reactuploadprofileimage", formData).then((response) => {
        const data = (response.data);
        dispatch({type: types.PROFILE_PHOTO_UPLOADED, payload: data});
    }).catch((error) => {
        console.log(error);
    })
    
}

export const resetProfilePicture = () => async (dispatch) => {
    dispatch({type: types.RESET_PROFILE_PHOTO});
}

export const registerUser = (userInfo) => async (dispatch) => {
    try {
        const response = await register(userInfo);
        dispatch({type: types.USER_REGISTERED, payload: response.data});
    } catch (error) {
        console.log(error);
    }
}

export const loginUser = (userInfo) => async (dispatch) => {
    try {
        const response = await login(userInfo);
        dispatch({type: types.USER_LOGGED_IN, payload: response.data});
    } catch (error) {
        console.log(error);
    }
}