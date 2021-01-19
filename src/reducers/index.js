import chancesCount from './chancesCount';
import matchCount from './matchCount';
import{combineReducers } from 'redux';
import playerReducer from './playerReducer';
import GameStatus from './gameStatus';

const appReducer=combineReducers({
    cCount:chancesCount,
    mCount:matchCount,
    userValue:playerReducer,
    gameStatus:GameStatus
});

export default appReducer;