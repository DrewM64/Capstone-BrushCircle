import axios from 'axios';

import * as types from '../redux/constants';
import { userData } from '../data/mockData'
import { register, login, update, uploadProfilePhoto, resetProfilePhoto } from '../api/api';

export const uploadProfilePicture = (formData) => async (dispatch) => {
    //send to the backend
    try {
        const response = await uploadProfilePhoto(formData);
        dispatch({type: types.PROFILE_PHOTO_UPLOADED, payload: response.data});
    } catch (error) {
        console.log(error);
    }
    
}

export const resetProfilePicture = (user) => async (dispatch) => {
    try {
        const response = await resetProfilePhoto(user);
        dispatch({type: types.RESET_PROFILE_PHOTO, payload: response.data});
    } catch (error) {
        console.log(error);
    }
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

export const updateUser = (userInfo) => async (dispatch) => {
    try {
        const response = await update(userInfo);
        dispatch({type: types.USER_INFO_UPDATED, payload: response.data})
    } catch (error) {
        console.log(error);
    }
}