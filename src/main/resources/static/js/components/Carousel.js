import React, { useState } from 'react';

function Carousel() {
    const [currentIndex, setCurrentIndex] = useState(0);
    const images = ['/path/to/image1.jpg', '/path/to/image2.jpg', '/path/to/image3.jpg'];
    const profiles = [
        { name: 'Alice', age: 25, location: 'New York' },
        { name: 'Bob', age: 27, location: 'Los Angeles' },
        { name: 'Charlie', age: 30, location: 'Chicago' }
    ];

    function goToPrevSlide() {
        setCurrentIndex(currentIndex - 1);
    }

    function goToNextSlide() {
        setCurrentIndex(currentIndex + 1);
    }

    function handleMatch() {
        // Add code here to handle a match
    }

    function handleUnlike() {
        // Add code here to handle an unlike
    }

    return (
        <div className="carousel">
            <div className="profile-info">
                <h2>{profiles[currentIndex].name}</h2>
                <p>Age: {profiles[currentIndex].age}</p>
                <p>Location: {profiles[currentIndex].location}</p>
            </div>
            <button onClick={goToPrevSlide}>Prev</button>
            <img src={images[currentIndex]} alt="Slide" />
            <button onClick={goToNextSlide}>Next</button>
            <button onClick={handleMatch}>Match</button>
            <button onClick={handleUnlike}>Unlike</button>
        </div>
    );
}

export default Carousel;
