const { Component } = React

class Carousel extends Component {

    constructor(props,context){
        super(props)
        this.state = {
            activepage: "Discover",
            currentIndex: 0,
            profiles: [],
            user_id:0,
            currentprofile: {"id":0,"username":"0","email":"initial value","password":"initial value","firstName":"initial value"
            ,"lastName":"initial value","age":0,"birthDate":"test",
            "picture":"/asset/favicon/favicon-16x16.png","city":"test","description":"test","male":true}
        }
        this.changeActivePage=this.changeActivePage.bind(this)
            //  this.componentDidMount()
    }


    componentDidMount() {
        alert("component did mount ")
        // Fetch the profiles from the backend

        fetch('/profiles')
            .then(response => response.json())
            .then(
                (response) => {
                    alert(response)
                    console.log(response);
                    this.setState({profiles: response})
                    this.setState({currentprofile: response[this.state.currentIndex]})
                    alert("first profile"+response[this.state.currentIndex].firstName)



                })

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
    handleDislike = (user_id) => {
        alert("handle dislike")
        // Handle the "dislike" action for the current profile
    }

    handleNext = () => {
        this.setState(prevState => ({
            currentIndex: (prevState.currentIndex + 1) % prevState.profiles.length
        }));
        this.setState({currentprofile: this.state.profiles[this.state.currentIndex]})
    }

    handlePrev = () => {
        this.setState(prevState => ({
            currentIndex: (prevState.currentIndex - 1 + prevState.profiles.length) % prevState.profiles.length
        }));
        this.setState({currentprofile: this.state.profiles[this.state.currentIndex]})
    }

    render() {
        //const { currentIndex, profiles } = this.state;
        //const currentProfile = profiles[currentIndex];
        const currentProfile =   this.state.currentprofile;
        const currentIndex = this.state.currentIndex;
        const activepage = this.state.activepage;
        if(activepage === "Discover") {
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

        return (
            <div>
                <nav>
                    <ul className="Nav__bar_ul">
                        <button onClick={() =>this.changeActivePage("Discover")}>Discover</button>
                        <button onClick={() =>this.changeActivePage("Profile")}>Profile</button>
                    </ul>
                </nav>
             <div> User profile </div>

             <div className="carousel">

                <button onClick={this.handlePrev}>&lt;</button>


                    <div className="carousel__item">

                        <img src={currentProfile.picture} alt="Profile picture" />
                        <div className="carousel__item__info">
                            <h1>{currentProfile.firstName} {currentProfile.lastName}</h1>
                            <p>{currentProfile.description}</p>
                            <p>Location: {currentProfile.city}</p>
                            <p>Date of birth: {currentProfile.dob}</p>
                            <p>Gender: {currentProfile.gender}</p>
                            <p>id: {currentProfile.id}</p>

                        </div>

                        <button onClick={() =>this.handleLike(currentProfile.id)}>Like</button>
                        <button onClick={() =>this.handleDislike (currentProfile.id)}>Dislike</button>

                    </div>


                    <button onClick={this.handleNext}>&gt;</button>
                </div>

            </div>

        );
        }
        else
        {
            return (<div>
                    <nav>
                    <ul className="Nav__bar_ul">
                        <button onClick={() =>this.changeActivePage("Discover")}>Discover</button>
                        <button onClick={() =>this.changeActivePage("Profile")}>Profile</button>
                    </ul>
                    </nav>
                something else </div>)
        }
    }

}

ReactDOM.render(<Carousel/>, document.getElementById("carousel"))