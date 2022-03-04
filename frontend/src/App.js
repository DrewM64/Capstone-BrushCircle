import logo from './logo.svg';
import './App.css';import { useEffect, useState } from 'react';
import axios from 'axios';

function App() {
  const [messasge, setMessage] = useState("Hi");

  useEffect(() => {
    axios.get('http://localhost:8080/')
      .then((response) => {
        setMessage(response.data)
      })
  })

  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
        <h1>
          {messasge}
        </h1>
      </header>
    </div>
  );
}

export default App;
