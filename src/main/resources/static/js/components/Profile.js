import '../styleSheet/profile.css'

class Profile extends React.Component {
    render() {
        return (
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
                        <p>{this.props.biography}</p>
                        <h3>Location</h3>
                        <p>{this.props.location}</p>
                        <h3>Date of Birth</h3>
                        <p>{this.props.dob}</p>
                        <h3>Gender</h3>
                        <p>{this.props.gender}</p>
                    </div>
                </div>
            </div>
        );
    }
}

export default Profile;
