import React, { Component } from 'react';
import { bindActionCreators } from "redux";
import { connect } from 'react-redux';
import { getAllUsersScores,handleResetGame } from './scorecardSlice';
import { NavLink } from 'react-router-dom';

class ScoreCard extends Component {
    componentDidMount() {
        this.props.dispatch(getAllUsersScores());
    }
    render() {
        return (
            <div className="SM-play">
                <div className="SM-section SM-play-section">
                    <table id="user-table">
                        <thead>
                            <tr>
                                <th>User Id</th>
                                <th>User Name</th>
                                <th>Score</th>
                            </tr>
                        </thead>
                        <tbody data-scoretable='component-records'>
                            {this.props.scores && this.props.scores.map(user =>
                                <tr key={user.userId}>
                                    <td>{user.userId}</td>
                                    <td>{user.userName}</td>
                                    <td>{user.score}</td>
                                </tr>
                            )}
                        </tbody>
                    </table>
                    <div className="button-group">
                        <NavLink to="/game"><button className="btn active SM-btnPlay SM-btnLarge w-150">Return To Menu</button></NavLink>
                        <button onClick={()=>this.props.dispatch(handleResetGame(this.props))} className="btn active SM-btnPrimary SM-btnPlay SM-btnLarge w-150">Reset Game</button>
                    </div>
                </div>
            </div>
        );
    }
}
function mapStateToProps(state) {
    return {
        userName: state.login.userName,
        scores: state.scorecard.scores
    }
}
function mapDispatchToProps(dispatch) {
    return {
        dispatch,
        actions: bindActionCreators({
            getAllUsersScores,
            handleResetGame
        }, dispatch)
    }
}
export default connect(mapStateToProps, mapDispatchToProps)(ScoreCard);