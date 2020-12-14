
import React, { Component } from 'react';
import './css/main.css';
import Login from './components/Login/login';
import Game from './components/Game/game';
import ScoreCard from './components/ScoreCard/scorecard';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import GuardedRoute from './components/AuthGuard/AuthGuard';
import { connect } from 'react-redux';
import { bindActionCreators } from "redux";
import { authenticateUser } from './components/Login/loginSlice';
import Header from './components/header/header';
class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      isRender: false
    }
  }

  async componentDidMount() {
    await this.props.dispatch(authenticateUser());
    this.setState({ isRender: true });
  }

  render() {
    const { isRender } = this.state;
    return (
      isRender && <div className="SM-home-bgImage">
        <Router>
          <Route path='/' component={Header} {...this.props} />
          <Switch>
            <Route exact path="/" component={Login} {...this.props} />
            <Route exact path="/login" component={Login} {...this.props} />
            <GuardedRoute exact path="/game" component={Game} auth={this.props.isAutheticated} />
            <GuardedRoute exact path="/scorecard" component={ScoreCard} auth={this.props.isAutheticated} />
          </Switch>
        </Router>
      </div>

    );
  }
}
function mapStateToProps(state) {
  return {
    isAutheticated: state.login.isAutheticated
  }
}
function mapDispatchToProps(dispatch) {
  return {
    dispatch,
    actions: bindActionCreators({
      authenticateUser
    }, dispatch)
  }
}
export default connect(mapStateToProps, mapDispatchToProps)(App);

