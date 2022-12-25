import React from 'react';
import ReactDOM from 'react-dom/client';
import './styleSheet/index.css';
import App from './App';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
    <>
        <h1>test</h1>
        <React.StrictMode>
            <App />
        </React.StrictMode>
    </>
);