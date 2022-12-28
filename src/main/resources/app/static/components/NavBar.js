function NavBar() {
    return (
        <nav>
            <ul className="Nav__bar_ul">
                <li className="Nav__bar_li"><a href="../main.html"><b>Discover</b></a></li>
                <li className="Nav__bar_li"><a href="../main.html"><b>Chat</b></a></li>
                <li className="Nav__bar_li"><a href="../main.html"><b>Profile</b></a></li>
            </ul>
        </nav>
    );
}

ReactDOM.render(<App/>, document.getElementById("root"))