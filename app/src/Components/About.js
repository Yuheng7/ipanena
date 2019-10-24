import React, { Component } from 'react'
import Yuheng from "../yuheng_photo.jpg"
import Stephanie from "../IMG_6974.JPG"
import "../About.css"

class About extends Component{
    render() {
        return (
            <div className="container">
                <hi>About the creators</hi>
                <img src={Yuheng} />
                <img src={Stephanie} className="Steph"/>
            </div>
        )
    }
}

export default About