import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import Form from "./Components/Form";
import App from './App';
import * as serviceWorker from './serviceWorker';

import {BrowserRouter} from "react-router-dom";

const inputs = [{
    name: "username",
    placeholder: "username",
    type: "text"
},{
    name: "password",
    placeholder: "password",
    type: "password"
},{
    type: "submit",
    value: "Submit",
    className: "btn"
}]

const props = {
    name: 'loginForm',
    method: 'POST',
    action: '/login',
    inputs: inputs
}

const params = new URLSearchParams(window.location.search)

ReactDOM.render(
    <div><BrowserRouter><App/><Form {...props} error={params.get('error')} /></BrowserRouter></div>,
    document.getElementById('root'))

// ReactDOM.render(<BrowserRouter><App/></BrowserRouter>, document.getElementById('root'));
//
// // If you want your app to work offline and load faster, you can change
// // unregister() to register() below. Note this comes with some pitfalls.
// // Learn more about service workers: https://bit.ly/CRA-PWA
// serviceWorker.unregister();
