import React from 'react'
import UserForm from './userForm';
import { shallow,configure,mount} from 'enzyme';
import {Provider} from 'react-redux';
 import store from './../store'
import Adapter from '@wojtekmaj/enzyme-adapter-react-17';


configure({ adapter: new Adapter() });
describe('<UserForm /> with no props',()=>{
    const wrapper = mount(<Provider store={store}><UserForm /></Provider>);
     const loginForm=wrapper.find("[data-id='loginForm']");
     it('checks input validation',()=>{
const userValue=loginForm.find('input');
userValue.instance().value="sample_User"
expect(userValue.instance().value.length).toBe(11);
     });
     
})