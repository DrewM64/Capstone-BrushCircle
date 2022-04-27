import * as types from '../redux/constants';

const initialState = {
    userProductList: null
}

export default function (state = initialState, action){
    switch(action.type){
        // case types.PRODUCT_UPLOADED:
        //     return {
        //         ...state,
        //         imageList: action.payload,
        //     }
        default:
            return state;
    }
}