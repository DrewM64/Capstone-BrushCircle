import * as types from '../redux/constants';
import { uploadFileToServer, getProduct, updateProduct, deleteProduct } from "../api/api";
import debug from "debug";

const output = debug("product");

export const uploadFile = (formData) => async (dispatch) => {
    try {
        const response = await uploadFileToServer(formData);
        output("Upload Response", formData);
        dispatch({type: types.PRODUCT_UPLOADED, payload: response.data});
    } catch (error) {
        console.log(error);
    }
}

export const getGalleryProdctInfo = (product) => async (dispatch) => {
    try {
        output("Product", product);
        const response = await getProduct(product);
        dispatch({type: types.GALLERY_ITEM_INFO_RETRIEVED, payload: response.data});
    } catch (error) {
        console.log(error);
    }
}

export const updateGalleryProduct = (data) => async (dispatch) => {
    try {
        output("Update Data", data);
        const response = await updateProduct(data);
        dispatch({type: types.GALLERY_ITEM_INFO_UPDATED, payload: response.data})
    } catch (error) {
        console.log(error);
    }
}

export const deleteGalleryProduct = (data) => async (dispatch) => {
    try {
        output("Deleted Product", data);
        const response = await deleteProduct(data);
        output("Deleted Product Response", data);
        dispatch({type: types.GALLERY_ITEM_DELETED, payload: response.data.product});
        dispatch({type: types.USER_INFO_FETCHED, payload: response.data.user});
    } catch (error) {
        console.log(error);
    }
}