import { createSlice } from '@reduxjs/toolkit';
import { userSession } from '../util/constants';

export const LoginSlice = createSlice({
    name: 'login',
    initialState: {
        userName: '',
        userId: '',
        isAutheticated:false
    },
    reducers: {
        setUserName: (state, actions) => {
            state.userName = actions.payload;
        }, setUserId: (state, actions) => {
            state.userId = actions.payload;
        }, setisAutheticated: (state, actions) => {
            state.isAutheticated = actions.payload;
        }
    }
});

const { setUserName,setUserId,setisAutheticated  } = LoginSlice.actions;
/**
 * handle the username input change.
 * @param {object} evt click event 
 */
export const handleChange = (evt) => dispatch => {
    dispatch(setUserName(evt.target.value));
}
/**
 * check Authorized user or not.
 * @returns {action} set userId
 */
export const authenticateUser = () => async (dispatch) => {
    var user = await localStorage.getItem('userId') && localStorage.getItem('userId') !== "" ? JSON.parse(localStorage.getItem('userId')) : '';
    if (user && user.userId) {
        dispatch(setUserId(user.userId));
        dispatch(setisAutheticated(true));
    }
}
/**
 * Play Game check user details and navigate to game page.
 * @param {string} userName entered userName
 * @param {object} props component state props
 */
export const onGamePlay = (userName,props) => dispatch => {
    const usersData = localStorage.getItem('usersData') && localStorage.getItem('usersData').length > 0 ? true : false;
    const data = usersData ? JSON.parse(localStorage.getItem('usersData')) : [];
    let user = {}
    if (!usersData) {
        user = {
            userId: 1,
            userName: userName,
            score: 0
        }
        data.push(user);
    } else {
        user = data.filter((info) => { if (info.userName.toLowerCase() === userName.toLowerCase()) return user })[0];
        if (!user) {
            user = {
                userId: data.length + 1,
                userName: userName,
                score: 0
            }
            data.push(user);
        }
    }
    localStorage.setItem('usersData', JSON.stringify(data));
    localStorage.setItem('userId', JSON.stringify({ userId: user.userId, expiry: (new Date().getTime()+userSession.timeOut) }));
    dispatch(setUserId(user.userId));
    dispatch(setisAutheticated(true));
    props.history.push('/game');
}
/**
 * handle the user logged out functionality.
 * @param {object} props Router component props.
 */
export const onLogout = (props) =>dispatch=> {
    localStorage.removeItem('userId');
    dispatch(setisAutheticated(false));
    props.history.push('/login');
}
export default LoginSlice.reducer;