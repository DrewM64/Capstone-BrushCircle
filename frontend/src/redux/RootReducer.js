import { combineReducers } from 'redux';

import ImageReducer from './ImageReducer';

const RootReducer = combineReducers({
    ImageReducer: ImageReducer,
})

export default RootReducer;