import React, {Component} from 'react'
import { NavLink, Switch, Route} from 'react-router-dom'
import About from "./About";
import Cards from "./Cards"

const Home = () => (
    <div className='home'>
        <h1>Welcome to my portfolio website</h1>
        <p> Feel free to browse around and learn more about me.</p>
    </div>
);

class Main extends Component{
    render(){
        return(
            <div>
            <Switch>
                <Route exact path='/' component={Home}></Route>
                <Route exact path='/about' component={About}></Route>
                <Route exact path='/cards' component={Cards}></Route>
                <Route exact path='/login' component={About}></Route>
            </Switch>
            </div>
        )
    }
}

export default Main