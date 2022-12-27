import NavBar from "./components/NavBar";
import Footer from "./components/Footer";
import Carousel from "./components/Carousel";


function App(){
    return (
        <div>
            <NavBar/>
            <Footer/>
        </div>

    );
}

ReactDOM.render(<App/>, document.getElementById("root"))