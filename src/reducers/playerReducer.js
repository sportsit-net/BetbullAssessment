var userValue='';
const playerReducer=(state=userValue,action)=>{
switch(action.type){
    case 'USER_ValUE':
        state=action.user
        userValue=action.user
return state
default :
return state
}

}
export default playerReducer;