import { Alert } from 'react-bootstrap';
import MatchCounter from './../actions/matchCounter';
import TotalChances from './../actions/totalChances';
import { useSelector, useDispatch } from 'react-redux';
import { useState } from 'react';
import { useHistory } from 'react-router-dom';
//let isFirst=true;
let prevCard;
const GamePage = () => {
  const history = useHistory();
  const dispatcher = useDispatch()
  const [flip, isFlip] = useState();
  const gameData = useSelector(state => state.mCount)
  const chancesCount = useSelector(state => state.cCount)


  let cardChange = (e) => {
    if (e.target.checked === false) {
      e.target.checked = true;
      return
    }

    if(gameData.isFirst){
      prevCard=e.target
    }
    isFlip();
    isFlip(e.target)
    dispatcher(MatchCounter(e.target.value))
    dispatcher(TotalChances())
  
  }


  if (gameData.flipCard) {
    setTimeout(() => {
      if (flip) {
        flip.checked = false
        if(prevCard && prevCard.value!==flip.value){
          prevCard.checked=false;
         
        }
      }
    }, 2000)
  }
  if (chancesCount.totalChances === 0) {
    dispatcher(TotalChances(3))
  
   setTimeout(()=>{
    history.push('/leaderBoard') 
    prevCard='';
  },2500)
  }
  return (
    <div className="SMG-gamePage">
      <h6 className="SMG-pageTitle">Please click on cards</h6>
      <div className="SMG-cardsRow">
        {gameData.cards.map((card, i) => {
          if (i <= 3) {
            return <div className="SMG-card" key={"first" + i} onChange={cardChange} data-test="gamePageTest">
              <input type="checkbox" value={card} />
              <div className={"SMG-front s" + card}></div>
              <div className="SMG-back"></div>
            </div>
          }
        }
        )}
      </div>
      <div className="SMG-cardsRow">
        {gameData.cards.map((card, i) => {
          if (i > 3 && i < 8) {
            return <div className="SMG-card" key={"second" + i} onChange={cardChange} data-test="gamePageTest">
              <input type="checkbox" value={card} />
              <div className={"SMG-front s" + card}></div>
              <div className="SMG-back"></div>
            </div>
          }
        }
        )}

      </div>
      <div className="SMG-cardsRow">
        {gameData.cards.map((card, i) => {
          if (i > 7) {
            return <div className="SMG-card" onChange={cardChange} key={"third" + i} data-test="gamePageTest">
              <input type="checkbox" value={card} />
              <div className={"SMG-front s" + card}></div>
              <div className="SMG-back"></div>
            </div>
          }
        }
        )}

      </div>
      <div className="SMG-footerBtn btnInfo" >
        <Alert variant='info' data-test="leftChancesCount">
          <i className="fa fa-info-circle btnIcon" aria-hidden="true"></i>
          <span className="btnInfo-title">You have <b>{ gameData.cardsCount>=6?0:chancesCount.totalChances}</b> chances left</span>
        </Alert>
      </div>
    </div>
  )
}
export default GamePage