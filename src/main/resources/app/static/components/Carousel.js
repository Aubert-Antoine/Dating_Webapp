const { Component } = React

class Carousel extends Component {

    constructor(props){
        super(props)
        this.state = {
            activepage: "Edit Profile",
            currentIndex: 0,
            profiles: [],
            user_id:1,
            currentprofile: {"id":0,"username":"0","email":"initial value","password":"initial value","firstName":"Clara"
            ,"lastName":"Imbert","age":21,"birthDate":"test",
            "picture":"/asset/favicon/favicon-16x16.png","city":"test","description":"Bonjour, je suis Clara, une étudiante en médecine de 21 ans basée à Bologne, en Espagne. Je suis très active et j'adore la danse et le judo. Je suis passionnée par mon métier et j'aime apprendre de nouvelles choses. Je suis également très sociable et j'aime passer du temps avec mes amis et ma famille. En dehors de mes études, j'aime également sortir et découvrir de nouveaux endroits. Si tu cherches une personne dynamique et passionnée, n'hésite pas à me contacter !","male":false}
        }
        this.changeActivePage=this.changeActivePage.bind(this)
    }


    componentDidMount() {
        // Fetch the profiles from the backend

        fetch('/profiles?id='+this.state.user_id)
            .then(response => response.json())
            .then(
                (response) => {
                    console.log(response);
                    this.setState({profiles: response})
                    this.setState({currentprofile: response[this.state.currentIndex]})
                    console.log(response[this.state.currentIndex])
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



    render() {
        const currentProfile =   this.state.currentprofile;
        const activepage = this.state.activepage;


        if(activepage === "Discover")
        {
        return (
                <div>
                    <nav className="Nav__bar_ul">
                            <button className="button_navbar" onClick={() =>this.changeActivePage("Discover")}>Discover</button>
                            <button className="button_navbar" onClick={() =>this.changeActivePage("Profile")}>Profile</button>
                            <button className="button_navbar" onClick={() =>this.changeActivePage("Edit Profile")}>Edit Profile</button>
                    </nav>

                     <main className="main-item">
                         <div className="carousel__item">
                             <img src={currentProfile.picture} alt="Profile picture" />
                             <div className="carousel__item__info">
                                 <h1>{currentProfile.firstName} {currentProfile.lastName}</h1>
                                 <p>{currentProfile.description}</p>
                                 <p>Location: {currentProfile.city}</p>
                                 <p>Age: {currentProfile.age}</p>
                             </div>
                             <button className="button_carousel-dislike" onClick={() =>this.handleDislike (currentProfile.id)}>Dislike &#128078;</button>
                             <button className="button_carousel-like" onClick={() =>this.handleLike(currentProfile.id)}>Like &#128077;</button>
                         </div>
                    </main>
                </div>
            );
        }
        else if (activepage === "Profile") {
            return (
                <div>
                    <nav className="Nav__bar_ul">
                        <button className="button_navbar" onClick={() =>this.changeActivePage("Discover")}>Discover</button>
                        <button className="button_navbar" onClick={() =>this.changeActivePage("Profile")}>Profile</button>
                        <button className="button_navbar" onClick={() =>this.changeActivePage("Edit Profile")}>Edit Profile</button>
                    </nav>
                    <main className="main-item">
                        <div className="profile">
                            <div className="profile__primary__info">
                                <ul className="profile__picture">
                                    <img src={this.props.picture} className="pp" alt="PP"/>
                                </ul>
                                <ul className="profile__fn_lf">
                                    <div><h1 className="h1__FirstName"><b>{this.props.firstName}</b></h1></div>
                                    <div><h1 className="h1__LastName">{this.props.lastName}</h1></div>
                                </ul>
                                <ul className="profile__edit">
                                    <button className="btn__edit"><b>Edit</b></button>
                                </ul>
                            </div>

                            <div className="profile__info">
                                <div className="profile__secondary__info">
                                    <h3>Biography</h3>
                                    <p>{this.props.description}</p>
                                    <h3>Location</h3>
                                    <p>{this.props.location}</p>
                                    <h3>Date of Birth</h3>
                                    <p>{this.props.birthDate}</p>
                                    <h3>Gender</h3>
                                    <p>{this.props.male}</p>
                                </div>
                            </div>
                        </div>
                    </main>
                </div>
            );
        }
        else if (activepage === "Edit Profile")
        {
            return (
                <div>
                    <nav>
                        <ul className="Nav__bar_ul">
                            <button className="button_navbar" onClick={() =>this.changeActivePage("Discover")}>Discover</button>
                            <button className="button_navbar" onClick={() =>this.changeActivePage("Profile")}>Profile</button>
                            <button className="button_navbar" onClick={() =>this.changeActivePage("Edit Profile")}>Edit Profile</button>
                        </ul>
                    </nav>
                    <main>
                        <div className="center">
                            <form action={this.props.action} className="profile__form">
                                <div className="profile__primary__info">
                                    <ul className="profile__picture">
                                        <img src={this.props.picture} className="pp" alt="PP"/>
                                    </ul>
                                    <ul className="profile__fn_lf">
                                        <div><h1 className="h1__FirstName"><b>{this.props.firstName}</b></h1></div>
                                        <div><h1 className="h1__LastName">{this.props.lastName}</h1></div>
                                    </ul>
                                </div>

                                <div className="profile__info">
                                    <div className="profile__secondary__info">
                                        <label htmlFor="fname"><h3>First name:</h3></label>
                                        <input type="text" id="fname" name="fname" value={this.props.firstName} />

                                        <label htmlFor="fname"><h3>Last name:</h3></label>
                                        <input type="text" id="lname" name="lname" value={this.props.lastName} /><br/>

                                        <label htmlFor="myfile"><h3>Profile picture:</h3></label>
                                        <input type="file" id="myfile" name="myfile"/>

                                        <label htmlFor="biography"><h3>Biography:</h3></label>
                                        <input type="textarea" id="biography" name="biography" value={this.props.description} />

                                        <label htmlFor="location"><h3>Location:</h3></label>
                                        <input type="text" id="location" name="location" value={this.props.location}/><br/>

                                        <label htmlFor="birthday"><h3>Birthday:</h3></label>
                                        <input type="date" id="birthday" name="birthday"/>

                                        <label htmlFor="gender"><h3>Gender:</h3></label>
                                        <input type="radio" id="male" name="gender" value="Male"/>
                                        <label htmlFor="male">Male</label>
                                        <input type="radio" id="female" name="gender" value="Female"/>
                                        <label htmlFor="female">Female</label>
                                        <input type="radio" id="other" name="gender" value="Other"/>
                                        <label htmlFor="other">other</label>

                                        <br/><br/>
                                        <input type="submit" value="Save"/>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </main>
                </div>
            );
        }
    }//render()
}//class Carousel

ReactDOM.render(<Carousel/>, document.getElementById("carousel"))