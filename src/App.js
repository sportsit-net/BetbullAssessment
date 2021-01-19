import './App.css';
//import 'bootstrap/dist/css/bootstrap.min.css';
import './assets/css/main-styles.scss';
import UserForm from './components/userForm';
import GamePage from './components/gamePage';
import ScoreBoard from './components/scoreBoard';
import { useSelector } from 'react-redux';
import { BrowserRouter as Router, Route, Switch, Redirect } from 'react-router-dom';
import headerLogo from './assets/images/smg-logo.svg';
import humburgerMenu from './assets/images/hamburger.svg';

function App(props) {
  const playerName = useSelector(state => state.userValue);
  return (
    <>
      <header className="SMG-header">
        <div className="humburger">
          {<img src={humburgerMenu} alt="Humburger Menu" />}
        </div>
            {<img src={headerLogo} alt="logo" />}
      </header>
      <Router>
        <main className="userForm">
          <div className="SMG-section">
              <Switch>
                <Route exact path="/" render={() => <UserForm />} />
                {playerName ? <Route exact path="/game" render={() => <GamePage />} /> : <Redirect to="/" />}
                {playerName ? <Route exact path="/leaderBoard" render={() => <ScoreBoard />} /> : <Redirect to="/" />}
              </Switch>
          </div>
        </main>
      </Router>
    </>
  );
}

export default App;
