import { Button, Form } from 'react-bootstrap';
import { useDispatch } from 'react-redux';
import addPlayer from './../actions/addPlayer';
import React, { useState } from 'react';
import { useHistory } from 'react-router-dom';

const UserForm = () => {
    const history = useHistory();
    const dispatch = useDispatch()
    const [name, setPlayerName] = useState('')
    const [errMsg, showErrMsg] = useState(false)

    let validateUser = (e) => {
        e.preventDefault();
        if (name.length > 0) {
            dispatch(addPlayer(name))

            showErrMsg(false)
            history.push('/game')
            setPlayerName('')
        }
        else {
            showErrMsg(true)
        }
    }

    let getUserValue = (e) => {
        setPlayerName(e.target.value)
    }

    return (

        <div className="SMG-startPage">
            <h5 className="SMG-homePageTitle">
                Welcome to <br /><span className="main-title">Simple Memory Game</span>
            </h5>
            <Form data-id="loginForm" className="SMG-formControl-group mb-4 hello">
                <Form.Row className="SMG-formControl">
                    <Form.Control type="text" className="SMG-input text-center" placeholder="Enter Your Name" onChange={getUserValue} />
                </Form.Row>
                {errMsg && <Form.Row className="SMG-formControl text-center" data-test="errorMessage">
                    <Form.Label className="SMG-validationMsg validator"> <b>Please Enter Your Name</b></Form.Label>
                </Form.Row>}

            </Form>

            <div className="SMG-footerBtn">
                <Button onClick={validateUser} variant="primary" type="submit" className="btn SMG-btnSecondary w-100 playButton">Lets Play <i className="fa fa-arrow-right btnInfo" aria-hidden="true"></i></Button>
            </div>
        </div>
    )
}
export default UserForm;