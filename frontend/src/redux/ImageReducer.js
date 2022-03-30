import * as types from '../redux/constants';

const initialState = {
    imageList: null
}

export default function (state = initialState, action){
    switch(action.type){
        case types.GET_FILE_LIST:
            return {
                ...state,
                imageList: action.payload,
            }
        
        case types.UPLOAD_FILE:
            return {
                ...state,
                imageList: action.payload,
            }
        default:
            return state;
    }
}