import React, { Component } from 'react';
// import './App.css';
import NavBar from "./Components/NavBar";
import Main from "./Components/Main"

class App extends Component{
  state = {
    isLoading: true,
    cards: []
  };

  render() {
    return (
        <div className="App">
          <header className="App-header">
            <NavBar/>
            <Main />
          </header>
        </div>
    );
  }
}

export default App;
