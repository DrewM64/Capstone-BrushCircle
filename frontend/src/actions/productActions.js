import axios from "axios";
import * as types from '../redux/constants';
import { uploadFileToServer } from "../api/api";

export const uploadFile = (formData) => async (dispatch) => {
    try {
        const response = await uploadFileToServer(formData);
        // dispatch({type: types.PRODUCT_UPLOADED, payload: response.data});
    } catch (error) {
        console.log(error);
    }
}