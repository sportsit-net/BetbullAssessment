import React from 'react'
import ScoreBoard from './scoreBoard';
import { shallow,configure,mount} from 'enzyme';
import {Provider} from 'react-redux';
import store from './../store'
import Adapter from '@wojtekmaj/enzyme-adapter-react-17';

configure({ adapter: new Adapter() });
 describe('<ScoreBoard /> with no props',()=>{
    const wrapper = mount(<Provider store={store}><ScoreBoard /></Provider>);
    const scoreInfo= wrapper.find("[data-test='scoreBoardTest']")
   it('display Valid score',()=>{
    const checkScore=  scoreInfo.hasClass("SMG-buttonRow");
    expect(checkScore).toBe(true)
   })
 })