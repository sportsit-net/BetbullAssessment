import React, { Component } from 'react';
import { bindActionCreators } from "redux";
import { connect } from 'react-redux';
import { generateCards, cardClick, successGuess, failureGuess, getUserDetails } from './gameSlice';
import { NavLink } from 'react-router-dom';

class Game extends Component {
    componentDidMount() {
        this.props.dispatch(generateCards());
        this.props.dispatch(getUserDetails(this.props.userId));
    }
    componentDidUpdate() { 
        if (this.props.firstCard && this.props.secondCard) {
            let firstCard = this.props.firstCard;
            let secondCard = this.props.secondCard;
            ((firstCard.value === secondCard.value) || (firstCard.suit === secondCard.suit)) ?
                this.props.dispatch(successGuess(firstCard, secondCard)) :
                this.props.dispatch(failureGuess(firstCard, secondCard));
        }
    }
    render() {
        return (
            <div className="SM-play">
                <div className="SM-section SM-play-section">
                    <div className="user-details"><span>User name:</span><span className="user-details-span"
                    >{this.props.userName}</span>
                        <span>Score:</span><span className="user-details-span" datascore="component-gameScore">
                            {this.props.score}</span>
                    </div>
                    <div className="SM-deck">
                        {this.props.cards.map(card =>
                            <div className="SM-card" key={card.id}>
                                <input type="checkbox" checked={card.isFlipped}
                                    onChange={() => { this.props.dispatch(cardClick(card)) }} />
                                <div className={`SM-front ${card.suit + card.value}`}></div>
                                <div className="SM-back"></div>
                            </div>
                        )}
                    </div>
                    <div className="button-group">
                        <NavLink to="/scorecard">
                            <button className="btn SM-btnPrimary SM-btnPlay SM-btnLarge w-150 active">Score Card</button>
                        </NavLink>
                    </div>
                </div>
            </div>
        );
    }
}
function mapStateToProps(state) {
    return {
        userId: state.login.userId,
        userName: state.game.userName,
        cards: state.game.cards,
        firstCard: state.game.firstCard,
        secondCard: state.game.secondCard,
        score: state.game.score
    }
}
function mapDispatchToProps(dispatch) {
    return {
        dispatch,
        actions: bindActionCreators({
            generateCards,
            cardClick,
            failureGuess,
            successGuess,
            getUserDetails
        }, dispatch)
    }
}
export default connect(mapStateToProps, mapDispatchToProps)(Game);