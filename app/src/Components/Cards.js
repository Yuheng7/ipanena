import React, { Component } from 'react'

class Cards extends Component{
    constructor(props) {
        super(props);
        this.state = {cards: [], isLoading: true};
    }

    componentDidMount() {
        this.setState({isLoading: true});

        fetch('/api/cards')
            .then(response => response.json())
            .then(data => this.setState({cards: data, isLoading: false}));
    }

    render() {
        const {cards, isLoading} = this.state;

        if(isLoading){
            return <p>Loading...</p>
        }

        return (
            <div>
                <h2>Credit Cards</h2>
                {cards.map(card =>
                    <div>
                        {card.bank}
                        {card.card_name}
                    </div>
                )}
            </div>
        )
    }
}

export default Cards