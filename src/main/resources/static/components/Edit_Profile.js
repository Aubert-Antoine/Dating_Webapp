import '../css/profile_edit.css'
import React from "react";

class EditProfile extends React.Component {
    render() {
        return (
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
                        <input type="textarea" id="biography" name="biography" value={this.props.biography} />

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
        );
    }
}

export default EditProfile;
