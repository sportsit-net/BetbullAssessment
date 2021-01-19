var status={
    isKeepPlaying:false,
    isReset:false
}
const GameStatus =(state=status,action)=>{
    switch(action.type){
        case 'GAME_STATUS':
            if(action.status){
                state.isReset=true
            }
            else{
                state.isReset=false
            }
            return state
            default:
                return state
    }

}
export default GameStatus;