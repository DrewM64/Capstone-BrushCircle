import * as types from './constants';
import { mockProducts } from '../data/mockData';

const initialState = {
    allProductsArray: mockProducts,
    homeCategoriesArray: null,
    exploreCategoriesArray: null,
    searchResultsArray: null,
    userProfileObject: null,
    userProfileProducts: null,
    selectedProduct: null,
    serverAddress: "/",
}

export default function(state = initialState, action){
    switch(action.type){
        case types.ALL_PRODUCTS_RETRIEVED:
            return {
                ...state,
                allProductsArray: action.payload,
            }

        case types.HOME_DATA_RETRIEVED:
            return {
                ...state,
                homeCategoriesArray: action.payload,
            }

        case types.EXPLORE_DATA_RETRIEVED:
            return {
                ...state,
                exploreCategoriesArray: action.payload,
            }

        case types.SEARCH_RESULTS_RECIEVED:
            return {
                ...state,
                searchResultsArray: action.payload,
            }
            
        case types.USER_PROFILE_REQUESTED:
            return {
                ...state,
                userProfileObject: action.payload.user,
                userProfileProducts: action.payload.productsArray,
            }

        case types.PRODUCT_INFO_REQUESTED:
            return {
                ...state,
                selectedProduct: action.payload,
            }

        default:
            return state
    };
};