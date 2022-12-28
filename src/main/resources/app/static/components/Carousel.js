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
        // Fetch the profiles from the backend

        fetch('/profiles')
            .then(response => response.json())
            .then(
                (response) => {
                    console.log(response);
                    this.setState({profiles: response})
                    this.setState({currentprofile: response[this.state.currentIndex]})
                })

    }

    changeActivePage= (page) =>{
        this.setState({
            activepage:page
        })
    }

    handleLike = (user_id) => {
        fetch('/likes?from='+this.state.user_id+"&to="+user_id)
        // Handle the "like" action for the current profile
        this.setState(prevState => ({
            currentIndex: (prevState.currentIndex + 1) % prevState.profiles.length
        }));
        this.setState({currentprofile: this.state.profiles[this.state.currentIndex]})
    }




    handleDislike = (user_id) => {
        fetch('/dislikes?from='+this.state.user_id+"&to="+user_id)
        // Handle the "like" action for the current profile
        this.setState(prevState => ({
            currentIndex: (prevState.currentIndex + 1) % prevState.profiles.length
        }));
        this.setState({currentprofile: this.state.profiles[this.state.currentIndex]})
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

        //<button onClick={this.handlePrev}>&lt;</button>
        //<button onClick={this.handleNext}>&gt;</button>
        const currentProfile =   this.state.currentprofile;
        const currentIndex = this.state.currentIndex;
        const activepage = this.state.activepage;


        if(activepage === "Discover")
        {
        return (
                <div>
                    <nav>
                        <ul className="Nav__bar_ul">
                            <button className="button_navbar" onClick={() =>this.changeActivePage("Discover")}>Discover</button>
                            <button className="button_navbar" onClick={() =>this.changeActivePage("Profile")}>Profile</button>
                        </ul>
                    </nav>

                     <body className="body">
                         <div className="carousel__item">
                             <img src={currentProfile.picture} alt="Profile picture" />
                             <div className="carousel__item__info">
                                 <h1>{currentProfile.firstName} {currentProfile.lastName}</h1>
                                 <p>{currentProfile.description}</p>
                                 <p>Location: {currentProfile.city}</p>
                                 <p>Age: {currentProfile.age}</p>
                             </div>
                             <button className="button_carousel-like" onClick={() =>this.handleLike(currentProfile.id)}>Like</button>
                             <button className="button_carousel-dislike" onClick={() =>this.handleDislike (currentProfile.id)}>Dislike</button>
                        </div>
                    </body>
                </div>
            );
        }
        else if (activepage === "Profile")
        {
        return (
            <div>
                <nav>
                <ul className="Nav__bar_ul">
                    <button className="button_navbar" onClick={() =>this.changeActivePage("Discover")}>Discover</button>
                    <button className="button_navbar" onClick={() =>this.changeActivePage("Profile")}>Profile</button>
                </ul>
                </nav>

                <body>
                <h1>test a la place de profil </h1>
                </body>
            </div>
            );
        }
    }//render()
}//class Carousel

ReactDOM.render(<Carousel/>, document.getElementById("carousel"))