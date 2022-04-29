import * as types from '../redux/constants';
import { fetchAllUsers, fetchUserSearch, getUser, update, deleteUser, getProduct, updateProduct, deleteProduct, createUser } from "../api/api";

export const getAllUsers = (admin) => async (dispatch) => {
    try {
        const response = await fetchAllUsers(admin);
        dispatch({type: types.ADMIN_ALL_USERS_FETCHED, payload: response.data});
    } catch (error) {
        console.log(error);
    }
}

export const searchUsers = (data) => async (dispatch) => {
    try {
        const response = await fetchUserSearch(data);
        dispatch({type: types.ADMIN_USER_SEARCH, payload: response.data});
    } catch (error) {
        console.log(error)
    }
}

export const getUserData = (email) => async (dispatch) => {
    try {
        const response = await getUser(email);
        dispatch({type: types.ADMIN_USER_SELECTED, payload: response.data});
    } catch (error) {
        console.log(error)
    }
}

export const  updateUserData = (user) => async (dispatch) => {
    try {
        const response = await update(user);
        dispatch({type: types.ADMIN_USER_UPDATED, payload: response.data});
    } catch (error) {
        console.log(error)
    }
}

export const  deleteSelectedUser = (data) => async (dispatch) => {
    try {
        const response = await deleteUser(data);
        dispatch({type: types.ADMIN_USER_DELETED, payload: response});
    } catch (error) {
        console.log(error)
    }
}

export const getProductInfo = (product) => async (dispatch) => {
    try {
        const response = await getProduct(product);
        dispatch({type: types.ADMIN_PRODUCT_SELECTED, payload: response.data});
    } catch (error) {
        console.log(error);
    }
}

export const updateProductInfo = (data) => async (dispatch) => {
    try {
        const response = await updateProduct(data);
        dispatch({type: types.ADMIN_PRODUCT_UPDATED, payload: response.data});
    } catch (error) {
        console.log(error);
    }
}

export const adminDeleteProduct = (data) => async (dispatch) => {
    try {
        const response = await deleteProduct(data);
        dispatch({type: types.ADMIN_PRODUCT_DELETED, payload: response});
    } catch (error) {
        console.log(error);
    }
}

export const adminCreateUser = (data) => async (dispatch) => {
    try {
        const response = await createUser(data);
        dispatch({type: types.ADMIN_USER_CREATED, payload: response.data});
    } catch (error) {
        console.log(error);
    }
}