let data={
    totalChances:3,
    showModal:false
}
let count=0;
const chancesCount=(state=data,action)=>{
    switch(action.type){
        case 'Chances_State':
            count++
            if(count===2 || count===4 ||count===6){
            state.totalChances=state.totalChances-1;
            }
            if(state.totalChances===0){
                state.showModal=!state.showModal;
            }
            if(action.status===3){
                state.totalChances=3
                count=0
            }
        
            
            
           return state
            default:
                return state
           
    }
}
export default chancesCount;