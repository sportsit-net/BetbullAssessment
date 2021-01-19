let initialState={
    score:0,
    cardValue:0,
    isFirst:true,
    cardsCount:0,
    flipCard:false,
cards:[3,9,6,7,2,6,7,8,9,2,3,8]
}
let cardCount=0

const shuffleCards=(cards)=>{
    for (let i = cards.length - 1; i > 0; i--) {
      const j = Math.floor(Math.random() * (i + 1));
      [cards[i], cards[j]] = [cards[j], cards[i]];
    }
 
  }
  shuffleCards(initialState.cards)
const matchCount=(state=initialState,action)=>{
    switch(action.type){
        case  'IS_MATCHED':
           cardCount= cardCount+1
           state.cardsCount=cardCount;
            if(cardCount>6){ 
                state.cardValue=0
                state.flipCard=false          
                 state.score=0;
                 cardCount=1;
                 state.cardsCount=1;
                 state.isFirst=true;
                // shuffleCards(state.cards)
            }
            if(cardCount===6){
            setTimeout(()=>{
                 shuffleCards(state.cards)
                },2000)
            }

         if(state.cardValue>0 && state.cardValue===action.matchValue){
              state.cardValue=0;
             state.flipCard=false;          
              state.score=state.score+10;
              state.isFirst=true;
          }
          else if(state.cardValue>0  && state.cardValue!==action.matchValue){
            state.flipCard=true;
            state.cardValue=0;
            state.isFirst=true;
         }
         else{
            state.cardValue=action.matchValue;
            state.flipCard=false;
            state.isFirst=false;
         }

         
           return state; 
                default:
                return state
    }
    

}
export default matchCount