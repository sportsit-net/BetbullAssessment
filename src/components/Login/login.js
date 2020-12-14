import React, { Component } from 'react';
import { bindActionCreators } from "redux";
import { connect } from 'react-redux';
import { handleChange, onGamePlay } from './loginSlice';


class Login extends Component {
    componentDidMount() {
        if (this.props.isAutheticated)
            this.props.history.push('/game');
    }
    render() {
        return (
            <div className="SM-section">
                <h3 className="SM-txt-white">Welcome to Mini Memory Game...!</h3>
                <div className="SM-formControl-group">
                    <div className="SM-formLabel SM-txt-white">Enter User Name</div>
                    <div className="SM-formControl">
                        <input className="" type="text" data-test="component-login"
                            placeholder="Name" onChange={(e) => this.props.dispatch(handleChange(e))} />
                    </div>
                </div>
                <div className="button"><button data-btndisable="component-playButton"
                    onClick={() => this.props.dispatch(onGamePlay(this.props.userName, this.props))}
                    className={`btn SM-btnPrimary SM-btnLarge w-100 ${this.props.userName ? " active" : ""}`}
                    disabled={!this.props.userName}>Play</button></div>
            </div>
        );
    }
}
function mapStateToProps(state) {
    return {
        userName: state.login.userName,
        isAutheticated: state.login.isAutheticated
    }
}
function mapDispatchToProps(dispatch) {
    return {
        dispatch,
        actions: bindActionCreators({
            handleChange
        }, dispatch)
    }
}

export default connect(mapStateToProps, mapDispatchToProps)(Login);