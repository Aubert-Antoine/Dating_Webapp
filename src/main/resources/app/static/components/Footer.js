import '../css/footer.css';

function Footer(){
    return (
        <footer className="footer">
            <div className="footer__addr">
                <h1 className="footer__logo">Dating Webapp</h1>
            </div>

            <ul className="footer__nav">
                <li className="nav__item">
                    <h2 className="nav__title">Dating App</h2>

                    <ul className="nav__ul">
                        <li>
                            <a href="../login.html">Join Now</a>
                        </li>

                        <li>
                            <a href="app/static/js/components#">Edit Profile</a>
                        </li>
                    </ul>
                </li>

                <li className="nav__item">
                    <h2 className="nav__title">The Project</h2>

                    <ul className="nav__ul">
                        <li>
                            <a href="https://www.linkedin.com/in/antoine0aubert/">About Dev</a>
                        </li>

                        <li>
                            <a href="mailto:antoine0aubert@edu.esiee.fr">Contact us</a>
                        </li>
                    </ul>
                </li>

                <li className="nav__item">
                    <h2 className="nav__title">Code</h2>

                    <ul className="nav__ul">
                        <li>
                            <a href="https://github.com/Aubert-Antoine/Dating_Webapp">GitHub</a>
                        </li>

                        <li>
                            <a href="https://www.ucy.ac.cy/">UCY</a>
                        </li>
                    </ul>
                </li>
            </ul>

            <div className="legal">
                <i>Made by Antoine Aubert & Benoit Marchadier</i>
            </div>
        </footer>
    );
}

export default Footer