import * as types from './constants';

const initialState = {
    user: null,
}

export default function(state = initialState, action){
    switch(action.type){
        case types.PROFILE_PHOTO_UPLOADED:
            return {
                ...state,
                user: action.payload,
            }

        case types.RESET_PROFILE_PHOTO:
            return {
                ...state,
                user: action.payload,
            }
        
        case types.USER_REGISTERED:
            return {
                ...state,
                user: action.payload,
            }

        case types.USER_LOGGED_IN:
            return {
                ...state,
                user: action.payload,
            }

        case types.USER_LOGGED_OUT:
            return {
                ...state,
                user: null,
            }

        case types.USER_INFO_UPDATED:
            return {
                ...state,
                user: action.payload,
            }

        case types.USER_INFO_FETCHED:
            return {
                ...state,
                user: action.payload,
            }

        default:
            return state
    };
};