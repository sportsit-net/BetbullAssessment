import { configureStore } from '@reduxjs/toolkit';
import loginReducer from '../components/Login/loginSlice';
import gameReducer from '../components/Game/gameSlice';
import scoreCardReducer from '../components/ScoreCard/scorecardSlice';

export default configureStore({
  reducer: {
    login: loginReducer,
    game: gameReducer,
    scorecard:scoreCardReducer
  },
});
