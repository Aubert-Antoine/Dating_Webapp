// render

/**
 *
 <div className="carousel">

 <button onClick={this.handlePrev}>&lt;</button>
 {
                this.state.profiles.map((currentProfile =>
                    <div className="carousel__item">
                        <img src={currentProfile.picture} alt="Profile picture" />
                        <div className="carousel__item__info">
                            <h1>{currentProfile.firstName} {currentProfile.lastName}</h1>
                            <p>{currentProfile.biography}</p>
                            <p>Location: {currentProfile.city}</p>
                            <p>Date of birth: {currentProfile.dob}</p>
                            <p>Gender: {currentProfile.gender}</p>
                            <p>id: {currentProfile.id}</p>

                        </div>


                        <button onClick={() =>this.handleLike(currentProfile.id)}>Like</button>
                        <button onClick={() =>this.handleDislike (currentProfile.id)}>Dislike</button>
                    </div>
                    ))
                }
 <button onClick={this.handleNext}>&gt;</button>
 </div>
 */


//nav bar

/**
 NavBar() {
        return (
            <nav>
                <ul className="Nav__bar_ul">
                    <button onClick={() =>Carousel.changeActivePage("Discover")}>Discover</button>
                    <button onClick={() =>Carousel.changeActivePage("Profile")}>Profile</button>
                </ul>
            </nav>
        );
    }
 */

