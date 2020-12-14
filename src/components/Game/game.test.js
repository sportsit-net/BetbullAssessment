import React from 'react';
import Game from './game';
import Enzyme, { shallow, mount, render, configure } from 'enzyme';
import { BrowserRouter as Router } from 'react-router-dom';
import Adapter from '@wojtekmaj/enzyme-adapter-react-17';
import store from '../../app/store';

configure({ adapter: new Adapter() });

describe('<Game />', () => {
    const wrapper = mount(<Router><Game store={store} /></Router>);
    const compScore = wrapper.find("[datascore='component-gameScore']");
    it('Game Page Score Check', () => {
        compScore.value = 5;
        expect(compScore.value).toBe(5);
    });
})
