import { Button, Modal, Table, Alert, ModalFooter } from 'react-bootstrap';
import { useSelector, useDispatch } from 'react-redux';
import Cookies from 'universal-cookie';
import GameStatus from './../actions/gameStatus';
import { useState } from 'react';
import { useHistory } from 'react-router-dom';
import scoreStars from '../assets/images/stars.svg';

const cookie = new Cookies();
let keepPlayingCount = 0;
let resetCount = 0;
let playersList = []
let dataCount = 0;
const ScoreBoard = () => {
  const [show, setShow] = useState(false);
  const history = useHistory();
  const playerName = useSelector(state => state.userValue);
  const gameInfo = useSelector(state => state.mCount);
  const getGameStatus = useSelector(state => state.gameStatus)
  const dispatch = useDispatch();

  let playerData = cookie.get('playerData') ? cookie.get('playerData') : []
  playerData.forEach((data) => {
    playersList.push(data.name)
  })
  if (getGameStatus.isReset === false) {
    resetCount++
    if (resetCount === 1) {
      playerData.forEach((data, i) => {
        if (data.name === playerName && data.reset === 'false') {
          data.score = data.score + gameInfo.score
        }
      })
    }
  }
  if (getGameStatus.isReset === true) {
    keepPlayingCount++
    if (keepPlayingCount === 1) {
      playerData.forEach((data, i) => {
        if (data.name === playerName) {
          data.reset = 'true';
        }
      })
      playerData.push({ 'name': playerName, 'score': gameInfo.score, 'reset': 'false' })
    }

  }
  if (playerName.length > 0) {
    if (playersList.indexOf(playerName) === -1) {
      playerData.push({ 'name': playerName, 'score': gameInfo.score, 'reset': 'false' })
      playersList.push(playerName)

    }

  }
  // if (playerName.length > 0) {
  //   if (playersList.indexOf(playerName) === -1) {
  //     playerData.push({ 'name': playerName, 'score': gameInfo.score, 'reset': 'false' })
  //     playersList.push(playerName)

  //   }

  // }
  const toggleLeaderBoard = () => {
    if (show === true) {
      setShow(false)
    }
    if (show === false) {
      setShow(true)
    }
  }
  playerData.forEach((data, i) => {
    dataCount++
    if (dataCount === 1) {
      data.id = i + 1
    }
  })
  cookie.set('playerData', playerData)

  //let playerData=cookie.get('playerData')

  if (playerData.length > 0) {

    playerData.sort((a, b) => b.score - a.score); // For descending sort
  }
  const handleExit = () => {
    resetCount = 0;
    keepPlayingCount = 0;
    dispatch(GameStatus(false));
    dataCount = 0
    history.push('/');

  }
  const handleClose = () => {
    if (show === true) {
      setShow(false)
    }
  }


  return (
    <div className="SMG-leaderBoard">
      <div className="SMG-thanksFP">
        <Alert className="mb-20" variant='danger'>
          <div>Thanks for Playing</div>
          <b>{playerName}</b>
        </Alert>
        {<img src={scoreStars} alt="stars" width="100" />}
        <Alert className="SMG-score" variant='info'>
          <div>Your Score</div>
          <b>{gameInfo.score}</b>
        </Alert>
      </div>

      <div className="SMG-buttonRow" data-test="scoreBoardTest">
        {!show && <>
          <Button variant="primary" id="leaderBoardBtn" onClick={toggleLeaderBoard} type="submit" className="btn SMG-btnSecondary SMG-btnMedium w-100">
            Show Leaderboard
                    </Button>
            <Button variant="primary" onClick={handleExit} type="submit" className="btn SMG-btnPrimary SMG-btnMedium w-100 mt-10">
            <i className="fa fa-sign-out" aria-hidden="true"></i> Exit Game
            </Button>
        </>
        }
        <div className="SMG-footerBtn btnRow">
          <Button variant="primary" onClick={() => { history.goBack(); dispatch(GameStatus(false)); resetCount = 0 }} type="submit" className="btn SMG-btnSecondary">
            <i className="fa fa-play btnIcon" aria-hidden="true"></i>Keep Playing
          </Button>
          <Button variant="primary" onClick={() => { history.goBack(); dispatch(GameStatus(true)); keepPlayingCount = 0 }} type="submit" className="btn SMG-btnReset">
            <i className="fa fa-repeat btnIcon" aria-hidden="true"></i>Reset Game
          </Button>
        </div>
      </div>
      {show &&
        <Modal show={show} onHide={handleClose}>
          <Modal.Header closeButton>
            <Modal.Title>
              Leaderboard
            </Modal.Title>
          </Modal.Header>
          <Modal.Body>
            <Table striped bordered hover>
              <thead>
                <tr>
                  <th>Name</th>
                  <th>Score</th>
                </tr>
              </thead>
              <tbody>
                {playerData.map((data, i) => {
                  if (data.name) {
                    return (
                      <tr key={i}>
                        <td>{data.name}</td>
                        <td>{data.score}</td>
                      </tr>
                    )
                  }
                })}
              </tbody>
            </Table>
          </Modal.Body>
        </Modal>}
    </div>
  )
}

export default ScoreBoard;