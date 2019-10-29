import React, { Component } from 'react'
import Yuheng from "../yuheng_photo.jpg"
import Stephanie from "../IMG_6974.JPG"
import "../About.css"

class About extends Component{
    render() {
        return (
            <div className="container">
                <h1>About the creators</h1>
                <img onMouseOver={() => console.log("Yuheng")} src={Yuheng} />
                <img onMouseOver={() => console.log("Stephanie")} src={Stephanie} className="Steph"/>
            </div>
        )
    }
}

export default About