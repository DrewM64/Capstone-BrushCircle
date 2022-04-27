import { combineReducers } from 'redux';

import ImageReducer from './ImageReducer';
import AuthenticationReducer from './AuthenticationReducer';
import ProductReducer from './ProductReducer';

const RootReducer = combineReducers({
    ImageReducer: ImageReducer,
    Authentication: AuthenticationReducer,
    Product: ProductReducer,
})

export default RootReducer;