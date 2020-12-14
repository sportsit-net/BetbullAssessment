import { createSlice } from '@reduxjs/toolkit';
import { Points, Card, Interval } from '../util/constants';

export const GameSlice = createSlice({
    name: 'game',
    initialState: {
        cards: [],
        firstCard: null,
        secondCard: null,
        score: 0,
        userId: 0,
        userName: ''
    },
    reducers: {
        setCards: (state, action) => {
            state.cards = action.payload;
        }, setCardFlipped: (state, action) => {
            state.cards.map((c,i)=> {
                if (c.id === action.payload.id) {
                    state.cards[i].isFlipped = action.payload.isFlipped;
                    state.cards[i].canFlip = action.payload.canFlip;
                }
                return c;
            })
        }, setCard: (state, action) => {
            if (state.firstCard) {
                state.secondCard = action.payload;
            } else {
                state.firstCard = action.payload;
            }
        }, resetFirstAndSecondCards: (state, action) => {
            state.firstCard = null;
            state.secondCard = null;
        }, calculateScore: (state, action) => {
            if (action.payload.firstCard.value === action.payload.secondCard.value) {
                state.score = state.score + Points.number;
            } else {
                state.score = state.score + Points.suit;
            }
            let usersData = JSON.parse(localStorage.getItem('usersData'));
            usersData.map((user) => { if (user.userId === state.userId) user.score = state.score });
            localStorage.setItem('usersData', JSON.stringify(usersData));
        }, setUserDetails: (state, action) => {
            state.userName = action.payload.userName;
            state.score = action.payload.score;
            state.userId = action.payload.userId;
        }
    }
});

export const { setCards, setCardFlipped, setCard, resetFirstAndSecondCards, calculateScore, setUserDetails } = GameSlice.actions;

/**
 * Generate a deck of 52 cards.
 * @returns {Array} cards 
 */
export const generateCards = () => dispatch => {
    const values = Card.values;
    const suits = Card.suits;
    const cards = [];
    let cardId = 1;
    for (let s = 0; s < suits.length; s++) {
        for (let v = 0; v < values.length; v++) {
            let objCard = {};
            cardId = cardId + 1;
            objCard.id = cardId;
            objCard.value = values[v];
            objCard.suit = suits[s];
            objCard.isFlipped = true;
            objCard.canFlip = true;
            cards.push(objCard);
            setTimeout(() => { // Flip Animation After Initial Load.
                let index = 0;
                setTimeout(() => dispatch(setCardFlipped({ ...objCard, isFlipped: false })), index++ * Interval.PtOneSec);
            }, Interval.threeSec);
        }
    }
    const shuffledCards = cards.sort(() => .5 - Math.random());
    dispatch(setCards(shuffledCards));
}
/**
 * handle the card click and store the selected card.
 * @param {object} card  selected card. 
 * @returns {action} storing the card info.
 */
export const cardClick = (card) => dispatch => {
    if (card.canFlip) {
        setTimeout(() => dispatch(setCardFlipped({ ...card, isFlipped: true })), Interval.PtOneSec);
        dispatch(setCard(card));
    }
};
/**
 * handle the user succcessful guess.
 * @param {object} firstCard user first selection
 * @param {object} secondCard user second selection
 * @returns { action } calculate the score and reset the first and second cards.
 */
export const successGuess = (firstCard, secondCard) => dispatch => {
    dispatch(calculateScore({ firstCard, secondCard }));
    setTimeout(() => dispatch(setCardFlipped({ ...firstCard, canFlip: false,isFlipped:true })), Interval.PtOneSec);
    setTimeout(() => dispatch(setCardFlipped({ ...secondCard, canFlip: false,isFlipped:true })), Interval.PtOneSec);
    dispatch(resetFirstAndSecondCards())
}
/**
 * handle the user failure guess.
 * @param {object} firstCard user first selection
 * @param {object} secondCard user second selection
 * @returns {action} reset the first and second cards.
 */
export const failureGuess = (firstCard, secondCard) => dispatch => {
    setTimeout(() => dispatch(setCardFlipped({ ...firstCard, isFlipped: false })), Interval.twoSecs);
    setTimeout(() => dispatch(setCardFlipped({ ...secondCard, isFlipped: false })), Interval.twoSecs);
    dispatch(resetFirstAndSecondCards());
}
/**
 * Get the Logged in user details from localstorage.
 * @param {strring} userId logged in user id
 */
export const getUserDetails = (userId) => dispatch => {
    const usersData = localStorage.getItem('usersData') && localStorage.getItem('usersData').length > 0 ? true : false;
    let data = usersData ? JSON.parse(localStorage.getItem('usersData')) : [];
    let user = {};
    user = data.filter((info) => { if (info.userId === userId) return user })[0];
    if (user) {
        dispatch(setUserDetails(user));
    }

}
export default GameSlice.reducer;