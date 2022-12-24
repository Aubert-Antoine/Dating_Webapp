import NavBar from "./components/NavBar";
import Footer from "./components/Footer";
import Profile from "./components/Profile";
import Edit_Profile from "./components/Edit_Profile";
import Lorem from "./components/Lorem";
import ImageSlider from "./components/Slider.mjs";

import './styleSheet/App.css'

function App () {
    const boolVal = false;

    return (
        <>
            <NavBar/>
            <br/>
            <ImageSlider />
            <br/>
            <Footer/>
        </>

)
}
export default App;

