import * as types from './constants';

const initialState = {
    profilePhotoAddress: null,
    user: null,
}

export default function(state = initialState, action){
    switch(action.type){
        case types.PROFILE_PHOTO_UPLOADED:
            return {
                ...state,
                profilePhoto: action.payload
            }

        case types.RESET_PROFILE_PHOTO:
            return {
                ...state,
                profilePhoto: null,
            }
        
        case types.USER_REGISTERED:
            return {
                ...state,
                user: action.payload
            }

        default:
            return state
    };
};