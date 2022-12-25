import '../styleSheet/profile.css'

function Profile(){
    return (
        <div className="profile">
                <div className="profile__primary__info">
                    <ul className="profile__picture">
                        <img src="static/js/components" className="pp" alt="PP"/>
                    </ul>
                    <ul className="profile__fn_lf">
                        <div><h1 className="h1__FirstName"><b>John-John</b></h1></div>
                        <div><h1 className="h1__LastName">Doe</h1></div>
                    </ul>
                    <ul className="profile__edit">
                        <button className="btn__edit"><b>Edit</b></button>
                    </ul>
                </div>

                <div className="profile__info">
                    <div className="profile__secondary__info">
                        <h3>Biography</h3>
                        <p>
                            Hey I am John, from Atlanta, I love trucks, and donuts. It is time to go to mick party.
                        </p>
                        <h3>Location</h3>
                        <p>Atlanta</p>
                        <h3>Date of Birth</h3>
                        <p>11/12/1996</p>
                        <h3>Gender</h3>
                        <p>male</p>
                    </div>
                </div>
        </div>
    );
}

export default Profile;