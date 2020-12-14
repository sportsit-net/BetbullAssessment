import React from 'react';
import Login from './login';
import Enzyme, { shallow, mount, render, configure } from 'enzyme';
import { BrowserRouter as Router } from 'react-router-dom';
import Adapter from '@wojtekmaj/enzyme-adapter-react-17';
import { Provider } from 'react-redux';
import Loginreducer from './loginSlice';
import store from '../../app/store';

configure({ adapter: new Adapter() });

describe('<Login />', () => {
    const wrapper = mount(<Router><Login store={store} /></Router>);
    const comp = wrapper.find("[data-test='component-login']");
    it('start page input validation', () => {
        const input = comp.find("input");
        input.instance().value = "tes";
        expect(input.instance().value.length).toBe(3);
    });

    const btnPlay = wrapper.find("[data-btndisable='component-playButton']").prop('disabled');
    it('start page input validation message', () => {
        const input = comp.find("input");
        input.instance().value = "";
        expect(input.instance().value.length).toBe(0);
        expect(btnPlay).toBeTruthy();
    });
})
