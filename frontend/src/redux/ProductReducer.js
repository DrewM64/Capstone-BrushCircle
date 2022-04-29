import * as types from '../redux/constants';
import { mockProducts } from '../data/mockData';

const initialState = {
    userProductList: mockProducts,
    gallerySelectedProduct: mockProducts[0],
}

export default function (state = initialState, action){
    switch(action.type){
        case types.PRODUCT_UPLOADED:
            return {
                ...state,
                userProductList: action.payload,
            }

        case types.USER_PRODUCT_LIST_RETRIEVED:
            return {
                ...state,
                userProductList: action.payload,
            }
        
        case types.GALLERY_ITEM_INFO_RETRIEVED:
            return {
                ...state,
                gallerySelectedProduct: action.payload,
            }

        case types.GALLERY_ITEM_INFO_UPDATED:
            return {
                ...state,
                gallerySelectedProduct: action.payload,
            }
        
        case types.GALLERY_ITEM_DELETED:
            return {
                ...state,
                gallerySelectedProduct: null,
                userProductList: action.payload,
            }

        default:
            return state;
    }
}