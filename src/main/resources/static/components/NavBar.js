import '../css/nav.css'


function NavBar() {
    return (
        <nav>
            <ul className="Nav__bar_ul">
                <li className="Nav__bar_li"><a href="../index.html"><b>Discover</b></a></li>
                <li className="Nav__bar_li"><a href="../index.html"><b>Chat</b></a></li>
                <li className="Nav__bar_li"><a href="../index.html"><b>Profile</b></a></li>
            </ul>
        </nav>
    );
}

export default NavBar;