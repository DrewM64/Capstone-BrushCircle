import * as types from '../redux/constants';
import { getAllProducts, fetchHomeData, fetchExploreData, fetchSearchResults, getUser, getProduct } from "../api/api";
import debug from 'debug';

const output = debug("home")

export const getProductsList = () => async (dispatch) => {
    try {
        const response = await getAllProducts();
        dispatch({type: types.ALL_PRODUCTS_RETRIEVED, payload: response.data});
    } catch (error) {
        console.log(error);
    }
}

export const getHomeData = () => async (dispatch) => {
    try {
        const response = await fetchHomeData();
        dispatch({type: types.HOME_DATA_RETRIEVED, payload: response.data});
    } catch (error) {
        console.log(error);
    }
}

export const getExploreData = () => async (dispatch) => {
    try {
        const response = await fetchExploreData();
        dispatch({type: types.EXPLORE_DATA_RETRIEVED, payload: response.data});
    } catch (error) {
        console.log(error);
    }
}

export const search = (query) => async (dispatch) => {
    try {
        const response = await fetchSearchResults(query);
        output("Search Results", response.data);
        dispatch({type: types.SEARCH_RESULTS_RECIEVED, payload: response.data});
    } catch (error) {
        console.log(error);
    }
}

export const getUserProfile = (email) => async (dispatch) => {
    try {
        output("Get Profile Reuqest", email);
        const response = await getUser(email);
        output("Get Profile Response", response.data);
        dispatch({type: types.USER_PROFILE_REQUESTED, payload: response.data});
    } catch (error) {
        console.log(error);
    }
}

export const getProductInfo = (product) => async (dispatch) => {
    try {
        output("Request Info", product);
        const response = await getProduct(product);
        output("Response", response.data);
        dispatch({type: types.PRODUCT_INFO_REQUESTED, payload: response.data});
    } catch (error) {
        console.log(error);
    }
}