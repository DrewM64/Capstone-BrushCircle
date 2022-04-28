import * as types from './constants';

const initialState = {
    allProductsArray: null,
    homeCategoriesArray: null,
    exploreCategoriesArray: null,
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

        default:
            return state
    };
};