import { combineReducers } from 'redux';

import ImageReducer from './ImageReducer';
import AuthenticationReducer from './AuthenticationReducer';
import ProductReducer from './ProductReducer';
import HomeReducer from './HomeReducer';
import AdminReducer from './AdminReducer';

const RootReducer = combineReducers({
    ImageReducer: ImageReducer,
    Authentication: AuthenticationReducer,
    Product: ProductReducer,
    Home: HomeReducer,
    Admin: AdminReducer,
})

export default RootReducer;