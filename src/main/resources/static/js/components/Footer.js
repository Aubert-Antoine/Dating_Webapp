import '../styleSheet/footer.css';

function Footer(){
    return (
        <footer className="footer">
            <div className="footer__addr">
                <h1 className="footer__logo">Your Logo</h1>
            </div>

            <ul className="footer__nav">
                <li className="nav__item">
                    <h2 className="nav__title">Dating App</h2>

                    <ul className="nav__ul">
                        <li>
                            <a href="static/js/components#">Join Now</a>
                        </li>

                        <li>
                            <a href="static/js/components#">Manage Account</a>
                        </li>
                    </ul>
                </li>

                <li className="nav__item">
                    <h2 className="nav__title">The Project</h2>

                    <ul className="nav__ul">
                        <li>
                            <a href="static/js/components#">About Dev</a>
                        </li>

                        <li>
                            <a href="static/js/components#">Contact us</a>
                        </li>
                    </ul>
                </li>

                <li className="nav__item">
                    <h2 className="nav__title">Code</h2>

                    <ul className="nav__ul">
                        <li>
                            <a href="static/js/components#">GitHub</a>
                        </li>

                        <li>
                            <a href="static/js/components#">UCY</a>
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