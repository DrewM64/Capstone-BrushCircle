import { combineReducers } from 'redux';

import ImageReducer from './ImageReducer';
import AuthenticationReducer from './AuthenticationReducer';
import ProductReducer from './ProductReducer';
import HomeReducer from './HomeReducer';

const RootReducer = combineReducers({
    ImageReducer: ImageReducer,
    Authentication: AuthenticationReducer,
    Product: ProductReducer,
    Home: HomeReducer,
})

export default RootReducer;