import * as types from '../redux/constants';
import { getAllProducts, fetchHomeData, fetchExploreData } from "../api/api";

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