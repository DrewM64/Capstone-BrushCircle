import * as types from './constants';

const initialState = {
    usersArray: null,
    selectedUserObject: null,
    selectedUserProducts: null,
    selectedProduct: null,
}

export default function(state = initialState, action){
    switch(action.type){
        case types.ADMIN_ALL_USERS_FETCHED:
            return {
                ...state,
                usersArray: action.payload,
            }

        case types.ADMIN_USER_SEARCH:
            return {
                ...state,
                usersArray: action.payload,
            }
        
        case types.ADMIN_USER_SELECTED:
            return {
                ...state,
                selectedUserObject: action.payload.user,
                selectedUserProducts: action.payload.productsArray,
            }

        case types.ADMIN_USER_UPDATED:
            return {
                ...state,
                selectedUserObject: action.payload,
            }

        case types.ADMIN_USER_DELETED:
            return {
                ...state,
                selectedUserObject: null,
                selectedUserProducts: null,
            }

        case types.ADMIN_PRODUCT_SELECTED:
            return {
                ...state,
                selectedProduct: action.payload,
            }

        case types.ADMIN_PRODUCT_UPDATED:
            return {
                ...state,
                selectedProduct: action.payload,
            }

        case types.ADMIN_PRODUCT_DELETED:
            return {
                ...state,
                selectedProduct: null,
            }

        case types.ADMIN_USER_CREATED:
            return {
                ...state,
                selectedUserObject: action.payload,
            }

        default:
            return state
    };
};