import * as types from './constants';

const initialState = {
    profilePhoto: null
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

        default:
            return state
    };
};