import { createSlice } from '@reduxjs/toolkit';

export const ScoreCardSlice = createSlice({
    name: 'scorecard',
    initialState: {
        scores: []
    }, reducers: {
        setScoreCard: (state, action) => {
            state.scores = action.payload;
        }
    }
});

export const { setScoreCard } = ScoreCardSlice.actions;
/**
 * Get the User details from the localstorage.
 * @returns {Array} userData from localstorage.
 */
export const getAllUsersScores = () => dispatch => {
    let userData = localStorage.getItem('usersData') &&
        localStorage.getItem('usersData').length > 0 ? JSON.parse(localStorage.getItem('usersData')) : [];
    dispatch(setScoreCard(userData));
}
/**
 * 
 * @param {object} props component props
 */
export const handleResetGame = (props) => dispatch => {
    var userId = localStorage.getItem('userId') ? JSON.parse(localStorage.getItem('userId')).userId : 0;
    const usersData = localStorage.getItem('usersData') && localStorage.getItem('usersData').length > 0 ? true : false;
    const data = usersData ? JSON.parse(localStorage.getItem('usersData')) : [];
    data.map((user) => {
        if (user.userId === userId)
            user.score = 0;
        return user;
    });
    localStorage.setItem('usersData', JSON.stringify(data));
    props.history.push('/game');
}

export default ScoreCardSlice.reducer;