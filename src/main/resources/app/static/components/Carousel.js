import React from 'react';

class Carousel extends React.Component {
    state = {
        currentIndex: 0,
        profiles: []
    }

    componentDidMount() {
        // Fetch the profiles from the backend
        fetch('/profiles')
            .then(response => response.json())
            .then(profiles => {
                this.setState({ profiles });
            });
    }

    //[{"id":0,"username":"maria","email":"test","password":"test","firstName":"test","lastName":"test","age":1,"birthDate":"test","picture":"/assets/favicon/favicon-16x16.png","city":"test","description":"test","male":true}]
    changeActivePage= (page) =>{
        this.setState({
            activepage:page
        })
    }

    handleLike = (user_id) => {
        alert("handle like from"+ +this.state.user_id+" to " +user_id  )
        fetch('/likes?from='+this.state.user_id+"&to="+user_id)

        // Handle the "like" action for the current profile
    }

    handleDislike = () => {
        // Handle the "dislike" action for the current profile
    }

    handleNext = () => {
        this.setState(prevState => ({
            currentIndex: (prevState.currentIndex + 1) % prevState.profiles.length
        }));
    }

    handlePrev = () => {
        this.setState(prevState => ({
            currentIndex: (prevState.currentIndex - 1 + prevState.profiles.length) % prevState.profiles.length
        }));
    }

    render() {
        const { currentIndex, profiles } = this.state;
        const currentProfile = profiles[currentIndex];

        return (
            <div className="carousel">
                <button onClick={this.handlePrev}>&lt;</button>
                <div className="carousel__item">
                    <img src={currentProfile.picture} alt="Profile picture" />
                    <div className="carousel__item__info">
                        <h1>{currentProfile.firstName} {currentProfile.lastName}</h1>
                        <p>{currentProfile.biography}</p>
                        <p>Location: {currentProfile.location}</p>
                        <p>Date of birth: {currentProfile.dob}</p>
                        <p>Gender: {currentProfile.gender}</p>
                    </div>
                </div>
                <button onClick={this.handleLike}>Like</button>
                <button onClick={this.handleDislike}>Dislike</button>
                <button onClick={this.handleNext}>&gt;</button>
            </div>
        );
    }
}

export default Carousel;
