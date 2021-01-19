import React from 'react'
import GamePage from './GamePage';
import { shallow,configure,mount} from 'enzyme';
import {Provider} from 'react-redux';
import store from './../store'
import Adapter from '@wojtekmaj/enzyme-adapter-react-17';

configure({ adapter: new Adapter() });
 describe('<GamePage /> with no props',()=>{
    const wrapper = mount(<Provider store={store}><GamePage /></Provider>);
   const gamePage= wrapper.find("[data-test='gamePageTest']")
    it('game page card count',()=>{
  const checkCard=  gamePage.hasClass("SMG-card");
  expect(checkCard).toBe(true)
    })
 })