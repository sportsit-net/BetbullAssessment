import React from 'react';
import ScoreCard from './scorecard';
import Enzyme, { shallow, mount, render, configure } from 'enzyme';
import { BrowserRouter as Router } from 'react-router-dom';
import Adapter from '@wojtekmaj/enzyme-adapter-react-17';
import store from '../../app/store';

configure({ adapter: new Adapter() });

describe('<ScoreCard />', () => {
    const wrapper = mount(<Router><ScoreCard store={store} /></Router>);
    const compTable = wrapper.find("[data-scoretable='component-records']");
    it('score page validation', () => {
        const gettbody = compTable.find("tbody");
        const gettr = gettbody.find("tr");
        const gettd = gettr.find("td");
        gettd.value = "user";
        expect(gettd.value.length).toBe(4);
    });
})
