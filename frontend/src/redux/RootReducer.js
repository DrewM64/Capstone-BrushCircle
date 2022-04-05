import { combineReducers } from 'redux';

import ImageReducer from './ImageReducer';
import AuthenticationReducer from './AuthenticationReducer';

const RootReducer = combineReducers({
    ImageReducer: ImageReducer,
    Authentication: AuthenticationReducer,
})

export default RootReducer;