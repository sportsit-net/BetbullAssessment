import React, { Component } from 'react';
import { bindActionCreators } from "redux";
import { connect } from 'react-redux';
import { onLogout } from '../Login/loginSlice';

class Header extends Component {
    render() {
        return (
            <header>
                <nav className="navbar">
                    <div className="navbar-brand">
                        <span className="logo"><h1>LOGO</h1></span>
                        {this.props.isAutheticated &&
                            <span className="logout"  onClick={()=>this.props.dispatch(onLogout(this.props))}>Logout</span>
                        }
                    </div>
                </nav>
            </header>
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
        onLogout
      }, dispatch)
    }
  }
export default connect(mapStateToProps,mapDispatchToProps) (Header);