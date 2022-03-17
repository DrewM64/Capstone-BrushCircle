import React from 'react'

import './styles.css';

function SlidingMenuTest() {
    const onButtonClick = (event) => {
        let currentClass = document.querySelector("#right-sidebar").getAttribute("class");

        if (currentClass == "right-sidebar") {
            document.querySelector("#right-sidebar").setAttribute("class", "right-sidebar-closed");
            document.querySelector("#content").setAttribute("class", "content-expanded");
        } else {
            document.querySelector("#right-sidebar").setAttribute("class", "right-sidebar");
            document.querySelector("#content").setAttribute("class", "content");
        }
    }

    return (
        <div><div id="container">
            <div id="content" className="content">
                <button className="toggle-button" onClick={onButtonClick}>Toggle Sidebar</button>
                <div className="placeholder-container">
                    <div className="box" />
                    <div className="box" />
                    <div className="box" />
                    <div className="box" />
                    <div className="box" />
                    <div className="box" />
                    <div className="box" />
                    <div className="box" />
                    <div className="box" />
                    <div className="box" />
                    <div className="box" />
                    <div className="box" />
                    <div className="box" />
                    <div className="box" />
                    <div className="box" />
                    <div className="box" />
                    <div className="box" />
                    <div className="box" />
                    <div className="box" />
                    <div className="box" />
                    <div className="box" />
                    <div className="box" />
                    <div className="box" />
                    <div className="box" />
                    <div className="box" />
                    <div className="box" />
                    <div className="box" />
                    <div className="box" />
                    <div className="box" />
                    <div className="box" />
                    <div className="box" />
                    <div className="box" />
                    <div className="box" />
                    <div className="box" />
                    <div className="box" />
                    <div className="box" />
                </div>
            </div>
            <div id="right-sidebar" className="right-sidebar">
            </div>
        </div>
        </div>
    )
}

export default SlidingMenuTest